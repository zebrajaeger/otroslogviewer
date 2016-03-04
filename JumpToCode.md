# What is jump to code #

Jump to code is integration of OtrosLogViewer with Java IDE (currently we are supporting only IntelliJ IDEA). If log event contains stack trace user can move mouse on selected stack element and click on it. IDE will open java class at selected line (if class is accessible). If user hover mouse on stack trace element, tooltip with code fragment will show up.


This is how tooltip with code fragment looks like:
![http://wiki.otroslogviewer.googlecode.com/git/screen-IdeIntegration-tooltip.png](http://wiki.otroslogviewer.googlecode.com/git/screen-IdeIntegration-tooltip.png)

On screenshot below is shown how IDEA Intellij performs jump to code (yellow line):
![http://wiki.otroslogviewer.googlecode.com/git/screen-IdeIntegration-jump.png](http://wiki.otroslogviewer.googlecode.com/git/screen-IdeIntegration-jump.png)

Integration with Intellij IDEA is more advance. It requires information only about logging class or logger and log message. Based on this it will try to locate part of code responsilble for logging.

Integration with Eclipse requires that log line will contain information about location in code (file and line). Logger can be configured to add this information but it is costly operation (requires throwing and catching exception for every log event).

# How to install integration with [IntelliJ IDEA](http://www.jetbrains.com/idea/) #
  1. In Intellij IDEA you have to install OtrosJumpToCode plugin from Jetbrains repository: http://plugins.jetbrains.com/plugin/7406?pr=
  1. Open logs from your application
  1. In Intellij IDEA open sources of your application
  1. When log event with stack trace is displayed, click on stack trace element

# How to install integration with [Eclipse](https://www.eclipse.org/) #
Currently there is no plugin for Eclipse. Plugin is in development phase. If you are looking forward for Eclipse integration [retweet us](https://twitter.com/OtrosSystems/status/463966056235536384)

