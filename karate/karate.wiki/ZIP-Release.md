Karate can be used as a [stand-alone executable](https://github.com/intuit/karate/tree/master/karate-netty#standalone-jar), ideal for teams that don't want to use a Java IDE. And you get all the features such as API [test-doubles](https://github.com/intuit/karate/tree/master/karate-netty) (or mocks) and [UI automation](https://github.com/intuit/karate/tree/master/karate-core) with [parallel-execution](https://github.com/intuit/karate/tree/master/karate-netty#parallel-execution).

## No Need to Compile Code

The ZIP release (version 0.9.5 onwards) is even more convenient because it comes with some sample test-scripts, mocks and even web-UI automation scripts out of the box, ideal for demo-ing Karate to others or just getting started quickly.

And you have [Visual Studio Code](#ide-support) as an IDE option which even has full-fledged debug support !

## Pre-Requisites
The only pre-requisite is that Java (just the [Runtime Environment](http://www.oracle.com/technetwork/java/javase/downloads/index.html) and not the full-fledged JDK) should be installed and in your system [PATH](https://www.java.com/en/download/help/path.xml). It is quite likely that you already have this in place.

To test, type this in a terminal or console window:

```
java -version
```

If it responds with a version that is 1.8.0_112 or greater (Java version 8), you are all set !

> Note: Java versions 13 and above are not yet supported.

## Downloading
Look for the file that starts with `karate-` and has a `*.zip` extension, 

* Option 1: Download from Bintray: [https://dl.bintray.com/ptrthomas/karate/](https://dl.bintray.com/ptrthomas/karate/)
* Option 2: Look for the [latest release](https://github.com/intuit/karate/releases) on GitHub and scroll down to find the "Assets"

Here is a [video of what to expect](https://twitter.com/KarateDSL/status/1163296799999705095).

## Installing
Just extract the ZIP to any directory.

## Running
You can run commands from the terminal or console after changing to the root of the folder created when you extracted the ZIP file. Also see [IDE Support](#IDE-Support). To see a list of all possible commands (`--help`) you can do this:

Mac users:
```
./karate -h
```

Windows users:
```
karate -h
```

And you can also refer to the [detailed documentation](https://github.com/intuit/karate/tree/master/karate-netty#usage). And yes, you can [run tests in parallel](https://github.com/intuit/karate/tree/master/karate-netty#parallel-execution).

### Web Automation
To run the web-browser automation demo, [Google Chrome](https://www.google.com/chrome/) should be installed. Karate should be able to use it if it is in the default install location for your OS.

Mac users:
```
./karate src/demo/web/google.feature
```

Windows users:
```
karate src/demo/web/google.feature
```

To change browsers or write more tests, please refer to the [documentation](https://github.com/intuit/karate/tree/develop/karate-core). 

### API Testing
Note how you can give a path and Karate will find all `*.feature` files within it. You may have to use [tags](https://github.com/intuit/karate/tree/master/karate-netty#tags) to "exclude" files as shown below:

Mac users:
```
./karate -t ~@ignore src/demo/api
```

Windows users:
```
karate -t ~@ignore src/demo/api
```

### API Mocks
A great way to demo Karate's capabilities is with this "full-stack" demo, that includes a server and an HTML client.

Mac users:
```
./karate -p 8080 -m src/demo/mock/cats-mock.feature 
```

Windows users:
```
karate -p 8080 -m src/demo/mock/cats-mock.feature 
```

And then open the `src/mock/cats.html` in a browser by double-clicking on it. You can click the "Create Cat" button and see HTTP requests being handled by the mock and the UI processing the responses. Navigate to [http://localhost:8080/cats](http://localhost:8080/cats) and observe the raw JSON server responses.

You can also get more insights about this demo here: [The World's Smallest Microservice](https://github.com/intuit/karate/tree/master/karate-netty#the-worlds-smallest-microservice-).

# IDE Support
The [Karate plugin for Visual Studio Code](https://marketplace.visualstudio.com/items?itemName=kirkslota.karate-runner) created by Kirk Slota gives you syntax coloring and a way to run tests from within the IDE. Here is a [video of what to expect](https://twitter.com/KarateDSL/status/1163492999906484224).

And you can debug tests ! See [this video](https://twitter.com/KarateDSL/status/1167533484560142336).

For more details see the wiki on [IDE Support](https://github.com/intuit/karate/wiki/IDE-Support#visual-studio-code).

## Karate Robot
For [Desktop Automation](https://github.com/intuit/karate/tree/master/karate-robot) on Windows and Mac OSX, you can [download](#download) the `karate-robot` JAR file separately. To add this to the classpath, just edit the batch file for your OS after renaming the JAR to `karate-robot.jar` for convenience (remove the version number).

Windows users - edit `karate.bat`:
```
java -cp 'karate.jar;karate-robot.jar;.' com.intuit.karate.Main %*
```

Mac users - edit `karate` (the file without an extension in the root folder):
```
java -cp karate.jar:karate-robot.jar:. com.intuit.karate.Main $*
```

And when using the [Karate Runner](https://github.com/intuit/karate/wiki/IDE-Support#visual-studio-code), go to the Karate Runner "Extension Settings", and change the value in the "Karate Jar: Command Line Args" to the above, and omit the last `%*` or `$*` part. For e.g. on Windows:
```
java -cp 'karate.jar;karate-robot.jar;.' com.intuit.karate.Main
```


