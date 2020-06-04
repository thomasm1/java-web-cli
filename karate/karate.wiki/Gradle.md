Here is a simple `build.gradle` for Karate and JUnit 5. Please also refer to the [main README](https://github.com/intuit/karate#gradle). You can also find a standalone project within the Karate source code here: [`jobserver`](https://github.com/intuit/karate/tree/develop/examples/jobserver).

```gradle
plugins {
    id 'java'
}

ext {
    karateVersion = '1.0.0'
}

dependencies {
    testCompile "com.intuit.karate:karate-junit5:${karateVersion}"
    testCompile "com.intuit.karate:karate-apache:${karateVersion}"
    testCompile "net.masterthought:cucumber-reporting:3.8.0"
}

sourceSets {
    test {
        resources {
            srcDir file('src/test/java')
            exclude '**/*.java'
        }
    }
}

test {
    useJUnitPlatform()
    systemProperty "karate.options", System.properties.getProperty("karate.options")
    systemProperty "karate.env", System.properties.getProperty("karate.env")
    outputs.upToDateWhen { false }
}

repositories {
    mavenCentral()
    // mavenLocal()
}

task karateDebug(type: JavaExec) {
    classpath = sourceSets.test.runtimeClasspath
    main = 'com.intuit.karate.cli.Main'
}
```

The optional `karate` task makes it easier to connect tools such as the [Visual Studio Code IDE](https://code.visualstudio.com) and use the [dedicated Karate extension](https://github.com/intuit/karate/wiki/IDE-Support#vs-code-karate-plugin).

For example, to start the Karate [Debug Server](https://github.com/intuit/karate/wiki/Debug-Server):
```
gradle karate --args='-d'
```

# Gatling
It is possible to use the [Karate Gatling integration](https://github.com/intuit/karate/tree/master/karate-gatling) with Karate by using a custom `JavaExec` task as shown above. Refer to the [documentation here](https://github.com/intuit/karate/tree/master/karate-gatling#gradle).