<a href='Hidden comment: 
currentVesrion=2012-02-06
'></a>
This page is for automated version checking.

## Changes ##
### Build 2010-09-01 ###
  * Marking rows with space bar
  * Colors added to message detail text area
  * Tab with all notes
  * Go to "Next marked" button changed to "Next marked/noted"
  * Added key mnemonic "Next/Previous marked/noted"
### Build 2010-09-02 ###
  * InternalFrame changed to Tabs

### Build 2010-10-10 ###
  * Parsing different date in Java Util Logger
  * Remove problem with sapces to java (i.e. C:\Program Files\...) in olv.bat

### Build 2010-10-17 ###
  * Improvment of loading window
  * Adding option to stop of loading
  * Added logging.properties file
  * During start trying to set jgoodies PlasticXPLookAndFeel

### Build 2010-11-24 ###
  * Memory info
  * Formatting SOAP messages in message detail
  * Hiding columns in log table
  * Detect if input stream is compressed with gzip
  * Tailing log from local disk

### Build 2011-01-20 ###
  * Multiline LogParser support initialized
  * Tailing through SFTP (using ssh commnad tail -f path)
  * Pause/follow options in tailing mode.
  * Masking password in bookmarks view
  * Warning when closing log(s)
  * Log4J pattern "%d{ISO8601} %-5p [%t] %m%n"
  * Highliting found text in log details panel
  * View level as icon
  * "Focus on this thread" in log table context menu
  * New icons

### Build 2011-02-09 ###
  * Marks all search result
  * Colors for marked introduced
  * Automatic marking new events in tailing mode
  * Persistent configuration introduced
  * Log4j custom pattern log parser introduced (based on [Apache Chainsaw implementation](http://svn.apache.org/repos/asf/logging/log4j/companions/receivers/trunk/src/main/java/org/apache/log4j/varia/LogFilePatternReceiver.java))
  * Loading Log4j pattern parser described in property files (./plugins/logimporters/`*`.pattern)
  * Load Log4J log file formmated with XMLLayout
  * Switching between tabs (Ctrl+Pg up, Ctrl+right next tab, Ctrl+Pgdown, Ctrl+left previous tab)
  * Hot key Ctrl+F focus on search field

### Build 2011-04-04 ###
  * Colors for memory monitor
  * SOAP message formatting and coloring
  * Remove events before and after selected in context menu
  * Possibility to connect SFTP server using key authentication
  * Markers for tailing mode improved
  * [issue 53](https://code.google.com/p/otroslogviewer/issues/detail?id=53) fixed (App do not show last log entry in the result table
  * Application aware of markers change
  * Added functionality to remove log events with lower/higher ID
  * 
### Build 2011-05-08 ###
  * [Issue 47](https://code.google.com/p/otroslogviewer/issues/detail?id=47) fixed Log importers can describe what table columns they need
  * Icons for open mode tail/open
  * Log4jPatternParser editor introduced
  * Filesystem type and host displayed in tab name
  * String/Regular expression filter
  * Quick access to class filter in log table context menu
  * [Issue 22](https://code.google.com/p/otroslogviewer/issues/detail?id=22) fixed Enhance Class/method filtering

### Build 2011-06-04 ###
  * [Issue 2](https://code.google.com/p/otroslogviewer/issues/detail?id=2) Dynamic loading of filters
  * [Issue 55](https://code.google.com/p/otroslogviewer/issues/detail?id=55) Basic Drag and Drop support
  * [Issue 58](https://code.google.com/p/otroslogviewer/issues/detail?id=58) fixed: Log investigation save/load error with multi-line log messages
  * [Issue 59](https://code.google.com/p/otroslogviewer/issues/detail?id=59) Windows is located out of the screen
  * [Issue 61](https://code.google.com/p/otroslogviewer/issues/detail?id=61) Improve search to use regular expression
  * [Issue 62](https://code.google.com/p/otroslogviewer/issues/detail?id=62) Make MessageColorizer and MessageFormatter pluginable
  * [Issue 63](https://code.google.com/p/otroslogviewer/issues/detail?id=63) Implement java stacktrace message colorizer

### Build 2011-06-04 ###
  * [Issue 72](https://code.google.com/p/otroslogviewer/issues/detail?id=72) Olv is aware of changes in message formatters/colorizers
  * [Issue 73](https://code.google.com/p/otroslogviewer/issues/detail?id=73) User can disable/enable message formatter/colorizer for selected tab
  * [Issue 74](https://code.google.com/p/otroslogviewer/issues/detail?id=74) User can define message colorizer based on properties file
  * [Issue 75](https://code.google.com/p/otroslogviewer/issues/detail?id=75) GUI editor for properties base message detail colorizers
  * [Issue 76](https://code.google.com/p/otroslogviewer/issues/detail?id=76) Action for clear marked events
  * [Issue 77](https://code.google.com/p/otroslogviewer/issues/detail?id=77) Message colorizer for search result
  * [Issue 80](https://code.google.com/p/otroslogviewer/issues/detail?id=80) Use JsyntaxPane in Log4j pattern editor
  * [Issue 81](https://code.google.com/p/otroslogviewer/issues/detail?id=81) Fix search on filtered table


### Build 2011-07-31 ###
  * Drag&Drop on Linux fixed.
  * [Issue 83](https://code.google.com/p/otroslogviewer/issues/detail?id=83) SearchResult MessageColorizer should be called as last
  * [Issue 84](https://code.google.com/p/otroslogviewer/issues/detail?id=84) Missing linefeed characters cause lines to be concatenated
  * [Issue 86](https://code.google.com/p/otroslogviewer/issues/detail?id=86) hide cmd after startup
  * [Issue 87](https://code.google.com/p/otroslogviewer/issues/detail?id=87) Add new "remove by" acceptance criteria
  * [Issue 88](https://code.google.com/p/otroslogviewer/issues/detail?id=88) Provide icon for AcceptanceCriteria
  * [Issue 89](https://code.google.com/p/otroslogviewer/issues/detail?id=89) Improve remove by acceptance condition performance
  * [Issue 90](https://code.google.com/p/otroslogviewer/issues/detail?id=90) Remove selected events
  * [Issue 91](https://code.google.com/p/otroslogviewer/issues/detail?id=91) PropertyMessageDetailColorizer do not store test message
  * [Issue 92](https://code.google.com/p/otroslogviewer/issues/detail?id=92) Implement batch mode
  * Splash screen introduced

### 2011-08-06 ###
  * [Issue 95](https://code.google.com/p/otroslogviewer/issues/detail?id=95) Add warning before deleting connection from bookmarks
  * [Issue 94](https://code.google.com/p/otroslogviewer/issues/detail?id=94) Turn on/off message formatter/colorizer perfomance issue


### 2011-10-06 ###
  * [Issue 85](https://code.google.com/p/otroslogviewer/issues/detail?id=85):       Enable viewing and filtering based on custom properties
  * [Issue 96](https://code.google.com/p/otroslogviewer/issues/detail?id=96):       Paste do not work in Log4jPropertyPatternParser editor
  * [Issue 98](https://code.google.com/p/otroslogviewer/issues/detail?id=98):       the log4j tag %L (line number) does not show in logger.
  * [Issue 101](https://code.google.com/p/otroslogviewer/issues/detail?id=101):      Listener not working
  * [Issue 102](https://code.google.com/p/otroslogviewer/issues/detail?id=102):      FocusOnThisAbstractAction do not always work properly
  * [Issue 104](https://code.google.com/p/otroslogviewer/issues/detail?id=104):      Remove events with level lower than ...
  * [Issue 105](https://code.google.com/p/otroslogviewer/issues/detail?id=105):      Store parsed log events in file
  * [Issue 106](https://code.google.com/p/otroslogviewer/issues/detail?id=106):      Window state is not saved
  * [Issue 110](https://code.google.com/p/otroslogviewer/issues/detail?id=110):      Cannot load investigation
  * [Issue 111](https://code.google.com/p/otroslogviewer/issues/detail?id=111):      Application hangs when selected message is very long and contains SOAP message
  * [Issue 112](https://code.google.com/p/otroslogviewer/issues/detail?id=112):      Tool tip of the day
  * [Issue 115](https://code.google.com/p/otroslogviewer/issues/detail?id=115):      Check if compression can be used for SFTP
  * [Issue 116](https://code.google.com/p/otroslogviewer/issues/detail?id=116):      Add configuration parameter to batch mode processing
  * [Issue 117](https://code.google.com/p/otroslogviewer/issues/detail?id=117):      FIlter events based on Logger name
  * Improve SOAP message formatter
  * Improve synchronization and stream closing
  * eclipse class path updated
  * removed commend and sysouts
  * stdout and stderr moved from java class to starting script

### Current ###