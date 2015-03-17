# What is OtrosLogViewer? #

OtrosLogViewer is software for analyzing an application's logs and stack traces.
It's a tool for interactive, not unattended, log monitoring.

## Requirements: ##
  * Java 6

## Features of OtrosLogViewer ##
  * Loads logs from **remote** servers using **ftp**, **sftp**, **ssh**, **samba** and others ([supported file systems](http://commons.apache.org/vfs/filesystems.html))
  * **Tails logs** from a local disk and sftp
  * Decompresses **gzipped** logs on the fly
  * [Parses custom log patterns](Log4jPatternLayout.md)
  * [Enables log events searching](SearchEvents.md)
  * [Provides log filters and pluginnable log filters](Filters.md)
  * [Enables logs highlighting. Automatic log highlightings based on string match, regular expression or custom Java code](MarkingEvents.md)
  * Provides pluginnable log parsers
  * [Enables listening on a socket](ListeningOnSocket.md)
  * [Connects to Log4j SocketHubAppender](SocketHubAppender.md)
  * [Adds notes to a log event](Notes.md)
  * [Saves and loads log investigation with marks and notes](SavingLoadingLogInvestigation.md)


<a href='Hidden comment: next/prev'></a>


&lt;TABLE width="100%"&gt;



&lt;TR&gt;



&lt;TD&gt;



&lt;/TD&gt;



&lt;TD align="right"&gt;

[Requirements and installation -->](RequirementsAndInstallation.md)


&lt;/TD&gt;



&lt;/TR&gt;



&lt;/TABLE&gt;

