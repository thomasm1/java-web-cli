Many popular text editors such as [Visual Studio Code](#visual-studio-code) have support for the [Gherkin](https://docs.cucumber.io/gherkin/) syntax. Using a Java IDE with Cucumber-JVM support is recommended for the best developer experience. All the options below provide syntax-coloring and the ability to run a test without writing a single line of Java code. And in IntelliJ and Eclipse you will get the [JUnit HTML report](https://github.com/intuit/karate#junit-html-report).

## IntelliJ Community Edition
Refer to this video for clear instructions, skip to 3:45 if needed: [Getting Started](https://youtu.be/W-af7Cd8cMc?t=227).

* install only the "Cucumber for Java" plugin and this will automatically prompt you to install the "Gherkin" plugin as well which is required.
* do *NOT* install the Substeps IntelliJ Plugin, make sure you un-select it if you see it selected anywhere when it comes to installing a plugin.
* you will be able to right-click on a `*.feature` file and run it via the [Run 'Feature:'] menu option
* you will even able to select a `Scenario` in the editor view and right-click and run it via the [Run 'Scenario:'] menu option
* if you see warnings such as `Unimplemented substep definition` - refer to [this ticket](https://github.com/intuit/karate/issues/90)

## IntelliJ IDEA
* the needed plugins are already installed, see above for troubleshooting

## Eclipse
* install the free Cucumber-Eclipse plugin from https://cucumber.io/cucumber-eclipse/
* then you will be able to right-click within any `*.feature` file and [Run As -> Cucumber Feature]
* Refer to the Cucumber-Eclipse wiki for more: http://bit.ly/2mDaXeV
* If you see warnings such as `Step 'xxx' does not have a matching glue code` or `required(..)+ loop did not match anything at input Scenario:` - refer to [this ticket](https://github.com/intuit/karate/issues/90)

## Visual Studio Code
You can choose to install just syntax support such as [this one](https://marketplace.visualstudio.com/items?itemName=stevejpurves.cucumber). But for the best experience, read on below.

### VS Code Karate Plugin
The [Karate Plugin](https://marketplace.visualstudio.com/items?itemName=kirkslota.karate-runner) created by Kirk Slota supports the [stand alone JAR executable](https://github.com/intuit/karate/wiki/Karate-UI) ([see video](https://twitter.com/KarateDSL/status/1149828960101924864)). It also works with standard Maven projects (or Gradle projects with some tweaks) and you can switch between other Java IDE-s if you want.

The best part about this plugin is a "native" step-through and debug experience ([see video](https://twitter.com/KarateDSL/status/1167533484560142336)). You can even step *back* during a session, re-play steps and *even* edit and hot-reload code at the same time ! 

To get the best experience after installing [Visual Studio Code](https://code.visualstudio.com) we suggest the following extensions. To configure, go to the `View Menu` -> `Extensions`.
* [Cucumber (Gherkin) Full Support](https://marketplace.visualstudio.com/items?itemName=alexkrechik.cucumberautocomplete) (required for debug support to work)
* [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

# Other Useful Links

[Soumendra Daas](https://twitter.com/sdaas) has created a nice example and guide that you can use as a reference here: [`hello-karate`](https://github.com/Sdaas/hello-karate). This demonstrates a Java Maven + JUnit4 project set up to test a [Spring Boot](http://projects.spring.io/spring-boot/) app.

Another blog post which is a good step-by-step reference is [this one by Micha Kops](https://semaphoreci.com/community/tutorials/testing-a-java-spring-boot-rest-api-with-karate) - especially if you use the 'default' maven folder structure instead of the [one recommended](https://github.com/intuit/karate#folder-structure) in the Karate documentation.

And one more up-to-date and useful reference is this [step-by-step guide by Andy Knight](https://automationpanda.com/2018/12/10/testing-web-services-with-karate/) using Visual Studio Code instead of Eclipse or IntelliJ.