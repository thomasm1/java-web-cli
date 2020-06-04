Karate has first-class debug support based on the [Debug Adapter Protocol](https://microsoft.github.io/debug-adapter-protocol/) (DAP) standard. As of now the [Karate Visual Studio Code Extension](https://marketplace.visualstudio.com/items?itemName=kirkslota.karate-runner) (created by [Kirk Slota](https://twitter.com/kirk_slota)) has support for debugging Karate, but we expect support in other IDE-s to be a matter of time.

The Karate Extension takes care of starting a debug session automatically and passing the details of feature files and break-points to the debug server. See [video](https://twitter.com/KarateDSL/status/1167533484560142336) - and there is more information [on the wiki](https://github.com/intuit/karate/wiki/IDE-Support#vs-code-karate-plugin).

The information below is for those who may want to start a debug-server manually and then you can point Visual Studio Code to it by using the following property in your [launch configuration](https://code.visualstudio.com/docs/editor/debugging#_launch-configurations) - once you have debug support for Karate `*.feature` files installed.

```
"debugServer": 4711
```

# Karate CLI
Karate has a Command Line Interface (CLI) by which you can perform some actions without needing to write Java code, and all you need is a `*.feature` file and other optional Karate artifacts. There are two entry points depending on whether you are using Karate as a [Java library](https://github.com/intuit/karate#maven) or the [Standalone JAR](https://github.com/intuit/karate/tree/master/karate-netty#standalone-jar).

In both versions of the CLI, the command to start a debug server is `-d` or `--debug` and a port number is optional. Besides printing the chosen port to the console, Karate will save a file called `karate-debug-port.txt` after the server is ready to receive connections - and this will be in the default build directory (typically `./target`). This file is designed for IDE-s that run in a different process to be able to start and synchronize debug sessions cleanly.

> If you are on Windows and run into issues, see the [Windows](#windows) section of this page.

## Standalone JAR
So for the standalone JAR - this will start the debug server on any free port.

```
java -jar karate.jar -d
```

Or to force a port:
```
java -jar karate.jar -d 4711
```

## Classpath
For the standalone-jar, you may need finer control over the classpath, refer to the [documentation](https://github.com/intuit/karate/tree/master/karate-netty#custom-classpath) for more. For example the below adds the "current directory" (`.`) to the root of the classpath on linux / mac.
```
java -cp karate.jar:. com.intuit.karate.Main -d
```

If you are on windows - use `;` instead of `:` in the above classpath. Also see [Windows](#windows).


## Maven
When using Karate as a Java library (typically via Maven or Gradle), the "main class" to use is `com.intuit.karate.cli.Main`. You can directly use it via Maven like this:

```
mvn test-compile exec:java -Dexec.mainClass=com.intuit.karate.cli.Main -Dexec.args=-d -Dexec.classpathScope=test
```

### Windows

If you are on Windows or run into some problems because of the command-line arguments not being parsed properly, try wrapping the critical command-line arguments within quotes. This may be needed especially if you are using "powershell". If you are stuck, you can also try to change the shell that VS Code uses by [changing the default terminal](https://stackoverflow.com/q/44435697/143475).

For setting the [Classpath](#classpath) (note the single-quotes):

```
java -cp 'karate.jar;some-other.jar;.' com.intuit.karate.Main
```

And for [Maven](#maven):

```
mvn test-compile exec:java '-Dexec.mainClass=com.intuit.karate.cli.Main' '-Dexec.args=-d' '-Dexec.classpathScope=test'
```

See the comments on [this Stack Overflow answer](https://stackoverflow.com/a/60326917/143475) for more.

## Gradle
If using [Gradle](https://github.com/intuit/karate/wiki/Gradle), you can define a task to do this:

```gradle
task karateDebug(type: JavaExec) {
    classpath = sourceSets.test.runtimeClasspath
    main = 'com.intuit.karate.cli.Main'
}
```

And with that, on the command-line you can do this:

```
gradle karate --args="-d" 
```

## Karate Options
The good thing about both [CLI Options](#karate-cli) is that both support the same flags like the [Karate Options](https://github.com/intuit/karate#command-line).

* `-t` tags
* `-T` threads
* `-n` `Scenario` name
* feature-file or path (directory) as the last parameter
* you can append a line-number (e.g: `:30`) to the feature-file above if you want to only execute that `Scenario` (or `Scenario Outline` row in an `Examples` table.

What this means is you can debug parallel-execution if you want - which may be useful to troubleshoot problems in large test-suites. VS Code plugin users can create an additional launch configuration and instead of using the `feature` key, add a new one called `karateOptions` - where you can add the details of the tags, threads and feature / paths to execute as the `feature` property.

```json
        {
            "type": "karate",
            "name": "Karate (debug)",
            "request": "launch",
            "karateOptions": "-t ~@ignore -T 5 classpath:demo/cats",
            "karateCli": "java -jar karate.jar -d"
        }
```

If you run into problems with VS Code starting the debug server, you can fall back to the last resort - of starting the debug server manually. The nice thing about VS Code is that it supports an extra `"debugServer": 4711` property in the above launch-config snippet. And if present, VS Code will completely bypass the plugin when you hit the debug "play" button and will connect to the Karate server *directly*.