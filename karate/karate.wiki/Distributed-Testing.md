In 0.9.5 onwards Karate can split a test-suite across multiple nodes that can be running remotely. This means that you can run Web-UI automation in parallel but get a single consolidated report which includes video of each `Scenario`.

> We really need you to try this and help us stabilize this ! Right now 0.9.5 is available.

Here is how it works.

* a [Docker container](https://hub.docker.com/r/ptrthomas/karate-chrome) based on JDK8 and Maven to which the Karate "fatjar" and also the Chrome browser has been added (non-headless mode).
* a [`JobConfig`](https://github.com/intuit/karate/blob/develop/karate-core/src/main/java/com/intuit/karate/job/JobConfig.java) interface which you need to implement (but we have some ready-made ones)
* you start a test using the [`Runner`](https://github.com/intuit/karate/blob/develop/karate-core/src/main/java/com/intuit/karate/Runner.java) - but instead of calling `parallel(threads)` you call a method `startServerAndWait(config)`, here is an [example](https://github.com/intuit/karate/blob/develop/examples/jobserver/src/test/java/jobtest/web/WebDockerJobRunner.java).
* what this does is start an HTTP job-server that will wait for remote "executors" to connect and ask for "job chunks". The unit of work is a Karate `Scenario`. When all `Scenario`-s are done, the job-server will aggregate the report.
* the design is such that no continuous communication is needed with the remote executors, see life-cycle below
* we provide a convenience implementation called [`MavenJobConfig`](https://github.com/intuit/karate/blob/develop/karate-core/src/main/java/com/intuit/karate/job/MavenJobConfig.java) and [`MavenChromeJobConfig`](https://github.com/intuit/karate/blob/develop/karate-core/src/main/java/com/intuit/karate/job/MavenChromeJobConfig.java) - these will fire `docker` commands to the local shell by default
* but you can override the `JobConfig.startExecutors()` method to do anything you want, for example Kubernetes deployments if that is your thing :)
  * if you set the `executorCount` in the `MavenJobConfig` to -1, Karate will assume that you are going to provision the JobExecutors and will do nothing. This is typical for CI pipelines, e.g. using Jenkins and Docker
* the responsibilities of the [`JobExecutor`](https://github.com/intuit/karate/blob/develop/karate-core/src/main/java/com/intuit/karate/job/JobExecutor.java) are very simple, the *only* input is the `KARATE_JOBURL`. If you use the Docker container, you pass this as an environment variable. This is the life-cycle
  * connect to the job-server and download a zip, extract it
  * ask job-server for `init` config, e.g. startup and shutdown commands to run
  * while the server does not respond with `stop`
    * ask for `next` job chunk
    * execute commands as instructed by server
    * zip and upload results to the server
  * execute shutdown commands (which will stop the Java process and kill the Docker container)

Right now this works for Maven projects. This can be made to work for Gradle with very little effort but we need your help. And yes, a way to execute [`karate-gatling`](#gatling) tests in parallel should be eminently possible.

## Karate Example
You can use this project as a reference and run this locally (with or without Docker) to get a feel of the whole thing and what to expect [`examples/jobserver`](https://github.com/intuit/karate/tree/develop/examples/jobserver).

## Example Jenkins pipeline
![](https://pbs.twimg.com/media/EEwpHjSUwAA6VGR?format=jpg&name=large)

## Example Jenkins config

![](https://pbs.twimg.com/media/EEwpHjPU4AArz2j?format=jpg&name=4096x4096)

The following Jenkins config uses a *very* simple `Dockerfile` which can be avoided if you know your way around Docker and Jenkins. Here we are using the [Jenkins-Kubernetes plugin](https://github.com/jenkinsci/kubernetes-plugin) with a [docker container available](https://github.com/jenkinsci/kubernetes-plugin/blob/master/examples/dood.groovy). But you just need an environment in which you can run docker commands and you should be all set ! So just Jenkins should work if you have Docker support. Do let us know how we can improve these instructions.

Here the Git "clone" step is omitted, but all the steps here assume that we are in the root folder of your maven project.

```dockerfile
FROM ptrthomas/karate-chrome

COPY . /src
```

### Jenkins Config
```gradle
node {
    karateWorker = "docker run -d --network=karate --rm --cap-add=SYS_ADMIN -e KARATE_JOBURL=http://karate:9080 karate"
}

pipeline {
    agent {
        kubernetes {
            label "${config.pod_label}"
            yamlFile 'KubernetesPods.yaml'
        }
    }
    stages {
        stage('Docker Build') {
            steps {
                container('docker') {
                    sh "docker rm karate || true"
                    sh "docker network create karate || true"
                    sh "docker build --pull -t karate ."                  
                }
            }
        }
        stage('Karate Tests') {
            parallel {
                stage('Boss') {
                    steps {
                        container('docker') {
                            sh "docker run --network=karate --name karate --cap-add=SYS_ADMIN -w /src karate mvn clean test -Dtest=JenkinsJobRunner"
                        }
                    }                    
                }
                stage('Workers') {
                    steps {
                        container('docker') {
                            sh karateWorker 
                            sh karateWorker 
                            sh karateWorker                     
                        }
                    }
                }                
            }
        }
    }
    post {
        always {
            container('docker') {
                sh "docker cp karate:/src/target ."
            }            
            junit "target/surefire-reports/*.xml"
            publishHTML(
                target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: "target/cucumber-html-reports",
                    reportFiles: 'overview-features.html',
                    reportName: "Features"
                ]
            )
            zip zipFile: "target.zip", archive: false, dir: "target", glob: "surefire-reports/*,**/*.log"
            archiveArtifacts "target.zip"
        }
    }    
}

```

And here is the code for the `JenkinsJobRunner`

```java
package web;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.job.MavenChromeJobConfig;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class JenkinsJobRunner {

    @Test
    void testAll() {
        MavenChromeJobConfig config = new MavenChromeJobConfig(-1, "karate", 9080);
        System.setProperty("karate.env", "jobserver");
        Results results = Runner.path("classpath:web").tags("~@ignore")
                .timeoutMinutes(5).startServerAndWait(config);
        AllTest.generateReport(results.getReportDir());
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

}
```

# Gatling
> This is experimental, please test, provide feedback and contribute if you can !

The [`JobExecutor`](https://github.com/intuit/karate/blob/develop/karate-core/src/main/java/com/intuit/karate/job/JobExecutor.java) should work for [`karate-gatling`](https://github.com/intuit/karate/tree/master/karate-gatling) tests. And we have a [`GatlingMavenJobConfig`](https://github.com/intuit/karate/blob/develop/karate-gatling/src/main/scala/com/intuit/karate/gatling/GatlingMavenJobConfig.java) and a [`GatlingJobServer`](https://github.com/intuit/karate/blob/develop/karate-gatling/src/main/scala/com/intuit/karate/gatling/GatlingJobServer.java) - which is quite simple, it just takes the `karate-gatling` project (which invoked it) and multiplies it by the number of "executors" that call-back. When each executor completes, the contents of the `target/gatling` folder (which contains `simulation.log`) are uploaded. The "server" takes care of renaming the Gatling `simulation.log` files to be unique and then invokes the Gatling routine to generate the aggregated report.

Here is an example that uses Docker on the same local node (on a Mac) [`GatlingDockerJobRunner`](https://github.com/intuit/karate/blob/develop/examples/gatling/src/test/java/jobtest/GatlingDockerJobRunner.java)

You should be able to use the same approach to "scale-out" across multiple hardware nodes.Just start multiple `JobExecutor`-s once the server `jobUrl` is known. The example above is for Maven, but you should be able to figure out an approach for Gradle if needed.