## Introduction ##

OtrosLogViewer can listen to the logs on the socket.

## Details ##
OtrosLogViewer is able to receive log events on socket. Port and log format can be choosen. Many sockets with different log format can be opened, all events will be imported into one view.

To enable logs listening, you need to:

  1. Configure you application to send log events on socket ([java.util.logging.SocketHandler](http://java.sun.com/j2se/1.4.2/docs/api/java/util/logging/SocketHandler.html) or [SocketHandler](http://docs.oracle.com/javase/1.4.2/docs/api/java/util/logging/SocketHandler.html)). Log events have to be formatted as plain text (not seriaized java objects)
  1. Select the **Start socket listener** option in the Tools menu in OtrosLogViewer ,
  1. Choose log format and port number,
  1. Start your application with the predefined log configuration.




<a href='Hidden comment: next/prev'></a>


&lt;TABLE width="100%"&gt;



&lt;TR&gt;



&lt;TD&gt;

[<-- Local and remote file systems](LocalAndRemote.md)


&lt;/TD&gt;



&lt;TD align="right"&gt;

[Connect to Log4j SocketHubAppender -->](SocketHubAppender.md)


&lt;/TD&gt;



&lt;/TR&gt;



&lt;/TABLE&gt;

