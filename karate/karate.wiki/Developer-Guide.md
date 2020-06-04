### Prerequisites:
* [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
* [JDK 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (even [OpenJDK](https://openjdk.java.net/install/index.html) is fine)
* [Eclipse](http://www.eclipse.org/downloads/) or any Java IDE that supports Maven
  * for example in [IntelliJ](https://www.jetbrains.com/idea/download) and [NetBeans](http://netbeans.apache.org), you can [directly open a folder](https://stackoverflow.com/a/36242422/143475) with a `pom.xml` file in it as a "project", and things will *just work*
  * if you are behind a proxy, [this article may be helpful](https://www.javahelps.com/2015/08/set-proxy-for-maven-in-eclipse.html)
* [Maven](http://maven.apache.org/) - optional, but recommended - especially to build the JAR-s / binaries

### Git Clone:
```
git clone https://github.com/intuit/karate.git
```

### Build

If you just want to build the binaries to test locally, and you have trouble installing (or want to avoid installing) Java and Maven, see [Docker](#docker).

* change to the `karate` folder created when you cloned the project from GitHub
* make sure you switch to the right branch. most likely you want to do this:
  * `git checkout develop`
* to build the maven artifacts locally:
  * `mvn clean install -P pre-release`
    * unit tests should never fail and if they do, please do consider debugging and letting us know the fix. but if you get stuck, you can add a `-DskipTests` at the end of the above command to proceed
    * the `karate-robot` module will download a lot of large JAR files by default because of the [`javacpp-presets`](https://github.com/bytedeco/javacpp-presets) dependency, you can limit these to what is sufficient for your OS by [following these instructions](https://github.com/bytedeco/javacpp-presets/wiki/Reducing-the-Number-of-Dependencies) - or you can just comment out the `karate-robot` module in the parent `pom.xml` if you don't care about using that JAR
  * this will locally "install" the `karate-apache`, `karate-junit5` and other Maven output artifacts, and then you can refer to them in a Java project
  * just make sure you update the version of the Karate dependencies (typically `karate-apache` and `karate-junit5`) in the `pom.xml` (or `build.gradle`) that you are testing to match what was just "built"

### Build Standalone JAR and ZIP
> Note that this is optional if you only need the Maven (or Gradle) artifacts.
* After you ran the above command, change to the `karate/karate-netty` folder
* `mvn install -P fatjar`
* you will get the [JAR](https://github.com/intuit/karate/tree/master/karate-netty#standalone-jar) in `karate/karate-netty/target/karate-<version>.jar`
* you will also get the [ZIP](https://github.com/intuit/karate/wiki/ZIP-Release) in `karate/karate-netty/target/karate-<version>.zip`

### Build Standalone Karate Robot JAR
> Note that this is optional if you only need the Maven (or Gradle) artifacts.
* change to the `karate/karate-robot` folder
* edit the [`pom.xml`](https://github.com/intuit/karate/blob/develop/karate-robot/pom.xml)
  * look for the `fatjar` profile, and tweak the `maven-shade-plugin` `<exclusions>` to only include the "platform" you want to build a JAR for
  * you can run `mvn dependency:tree` to get a sense of all possible platforms
* run `mvn install -P fatjar`

### Gradle
To develop Karate you need to use Maven. If you are trying to build the `karate-demo` project and run into issues, please [read this](https://github.com/intuit/karate/issues/463#issuecomment-406348465).

## Docker
The "foolproof" way to build Karate using OpenJDK 8 and Docker goes like this. The best part is you *only* need Docker to be installed !

Note that the `-v "$HOME/.m2":/root/.m2` re-uses your local Maven JAR download "cache" (which saves time), but you can omit it if needed for a true "from scratch" experience. But you most likely should use it, because it makes sure the Java libraries (JAR files) are "installed" locally so that you can refer to them in your maven `pom.xml`.

```
docker run -it --rm -v "$(pwd)":/src -w /src -v "$HOME/.m2":/root/.m2 maven:3-jdk-8 mvn clean install -P pre-release
```

And to build the stand-alone JAR:

```
docker run -it --rm -v "$(pwd)":/src -w /src/karate-netty -v "$HOME/.m2":/root/.m2 maven:3-jdk-8 mvn install -P fatjar
```

Like mentioned above, if unit-tests fail (they ideally should not, and if you see some that do, please help us fix it !) you can add a `-DskipTests` to the above commands. This command has been tested to work even up to `jdk-12`.

## Docker Images
The [`karate-chrome`](https://hub.docker.com/r/ptrthomas/karate-chrome) Docker container can be built locally by running the `build.sh` in the [`karate-docker/karate-chrome`](https://github.com/intuit/karate/tree/develop/karate-docker/karate-chrome) folder. Of course you need Docker installed and running.

> If you are interested, the release process is documented here and can give you some insights into the structure: [`readme.txt`](https://github.com/intuit/karate/blob/develop/karate-core/src/test/resources/readme.txt)

Once you build the container and if you have made changes, you can (optionally) "tag" it locally if you need to test any code or config that points to the `ptrthomas/karate-chrome` image:

```
docker tag karate-chrome ptrthomas/karate-chrome:latest
```

Refer to the [Docker wiki](https://github.com/intuit/karate/wiki/Docker) for more.