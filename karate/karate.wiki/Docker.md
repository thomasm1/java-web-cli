With the [`karate-chrome`](https://hub.docker.com/r/ptrthomas/karate-chrome) Docker image, you can run a Web-UI automation test in 3 steps, with only Docker installed. Yes, you don't need a browser or Java or Maven. You can even view the test in real-time and get a video recording.

And yes, this means you can finally run browser-automation in the background and do your work - without worrying about getting in the way of browser "focus" or keyboard / mouse-events.

See a demo video here: https://twitter.com/KarateDSL/status/1174408469673234432

For more information on the Karate Docker images and how to use / edit them, refer to the [Developer Guide](https://github.com/intuit/karate/wiki/Developer-Guide#docker-images).

## Examples

You can use the [`examples/jobserver`](https://github.com/intuit/karate/tree/develop/examples/jobserver) project, here are the steps.

* start docker and make sure it is running
* in a terminal, change to the root of the `jobserver` project
  * In `pom.xml`, change the `<karate.version>X.X.X</karate.version>` part to use the latest version.
* `docker run --name karate --rm -p 5900:5900 --cap-add=SYS_ADMIN -v "$PWD":/src ptrthomas/karate-chrome`
* leave the above command "hanging" in that terminal and switch to a new one, again be in the project root. stopping is simple, just do `CTRL+C` or kill the terminal / process
* optional step on a mac: `open vnc://localhost:5900`, the password is `karate` - and yes you will be able to see the Chrome browser !
  * for mac users using the built-in VNC viewer, setting (from the menu) `View --> Full Quality` instead of `Adaptive Quality` gives better results if you want to interact with the display
  * for non-mac users, you just need to use a VNC client
  * to improve performance, you can try adding a `--shm-size=512m` or `--shm-size=1g` to the docker options, also [read this for more](https://github.com/puppeteer/puppeteer/blob/master/docs/troubleshooting.md#tips)
* Option 1: run maven via a `docker exec` command from the host directly
  * `docker exec -it -w /src karate mvn clean test -DargLine='-Dkarate.env=docker' -Dtest=WebRunner`
* Option 2: enter the running docker container via a `bash` shell, *remain there* and run tests. This is great because you can keep editing the files (on your real host) and re-run tests without re-starting the docker container running the browser !
  * `docker exec -it -w /src karate bash`
  * now you are within the container and you can run *normal* maven commands !
  * `mvn clean test -DargLine='-Dkarate.env=docker' -Dtest=WebRunner`

## Chrome Remote Debug
* along with `-p 5900:5900`, add `-p 9222:9222 -e KARATE_SOCAT_START=true` to the first docker command that starts the container with Chrome in it
  * `docker run --name karate --rm -p 5900:5900 --cap-add=SYS_ADMIN -v "$PWD":/src -p 9222:9222 -e KARATE_SOCAT_START=true ptrthomas/karate-chrome`
* open Chrome on your host machine and navigate to [`http://localhost:9222`](http://localhost:9222)
* you should see `Inspectable Pages`, click on the first one
* TA DA ! you will now see a mirrored view of the Chrome instance running inside Docker. The great thing is that you can use the whole set of developer tools on your host machine, instead of struggling with the limited capabilities of a VNC remote connection.

## Parallel Execution
Want to test in parallel ? See [Distributed Testing](https://github.com/intuit/karate/wiki/Distributed-Testing).