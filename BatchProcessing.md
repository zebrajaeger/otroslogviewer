# Introduction #

The following page describes how to use OtrosLogViewer for batch processing.


# Details #

## What (for) is batch processing ##

Batch processing can be used to retrieve a required information from your logs (for example, you can draw charts with response times, count errors, etc.). Batch processing is run by the  olv-batch.[sh|bat] script.

## Modes - entry points in processing log files ##
OtrosLogViewer provides 3 entry points in batch processing.
  * when a single Log event is parsed (see Implement your own logic)
  * when parsing of new log file is started or finished (see Notify when processing of a new log file is started or finished)
  * when processing of all files is started or finished (see Notify when processing of all files is started or finished)

### Implement your own logic ###
To process the log in batch mode, create a class that implements the interface [LogDataParsedListener](http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/java/pl/otros/logview/batch/LogDataParsedListener.java) and select your implementation when starting OLV. For every parsed log event method  `void logDataParsed(LogData data, BatchProcessingContext context)` is called.

### Notify when processing of a new log file is started or finished ###
If you want to be notified when parsing of a new log file is started or finished, implement [SingleFileBatchProcessingListener](http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/java/pl/otros/logview/batch/SingleFileBatchProcessingListener.java).

` SingleFileBatchProcessingListener ` interface looks like the following:

```
public interface SingleFileBatchProcessingListener {

  public void processingFileStarted(BatchProcessingContext batchProcessingContext);

  public void processingFileFinished(BatchProcessingContext batchProcessingContext);

}
```
Method ` processingFileStarted ` is called before processing the file.
Method ` processingFileFinished ` is called after processing the file.


### Notify when processing of all files is started or finished ###
If you want to be notified when a new log parsing is started or finished, implement [BatchProcessingListener](http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/java/pl/otros/logview/batch/BatchProcessingListener.java).

` BatchProcessingListener ` interface looks like the following:

The ` processingFinished ` method is called after processing all files. You can implement this method for example to print the results.
```
public interface BatchProcessingListener {

  public void processingStarted(BatchProcessingContext batchProcessingContext);

  public void processingFinished(BatchProcessingContext batchProcessingContext);

}
```
The ` processingStarted ` method is called before processing all files. In this method you can initialize your objects used in processing.



## Making your classes available for OLV ##
  1. Create a jar with your classes
  1. Put your jar and the required libs into a selected folder
  1. When running the olv-batch.[sh|bat], point to the folder using `-d` switch.

## Running batch processing ##
To run batch processing, you need to point to the LogDataParsedListener implementation and the logs that are to be processed.


## Example ##

See the [example](http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/java/examples/ExampleLogDataParsedListener.java). This example implementation counts log events with level WARNING or higher in every log file.
Follow the pattern below to see how it works:
```
./olv-batch.sh -c examples.ExampleLogDataParsedListener  http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/test/resources/log4j.txt http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/test/resources/log_es_ES.txt
Batch processing started
Processing file log4j.txt have started
Event with level WARNING at 00:02:30 11-01-2011: some message 1
with multiline!
Event with level WARNING at 00:03:30 11-01-2011: some message 2
second with multiline
Event with level WARNING at 00:06:30 11-01-2011: some message 3 with empty line
Event with level WARNING at 00:10:30 11-01-2011: some message 4
Event with level WARNING at 00:20:30 11-01-2011: some message 6
Event with level SEVERE at 00:20:30 11-01-2011: some message 7
Event with level WARNING at 01:00:30 11-01-2011: some message 8
Event with level WARNING at 01:00:30 11-01-2011: some message 9
Event with level WARNING at 02:03:30 11-01-2011: some message 10
Finished parsing file log4j.txt, found 9 event at level warning or higher
Processing file log_en_US.txt have started
Event with level WARNING at 12:46:34 9-10-2010: Message in locales en_US 7
Event with level WARNING at 12:46:34 9-10-2010: Message in locales en_US 8
Event with level SEVERE at 12:46:34 9-10-2010: Message in locales en_US 9
Event with level SEVERE at 12:46:34 9-10-2010: Message in locales en_US 10
Finished parsing file log_en_US.txt, found 4 event at level warning or higher
Finished parsing all files, found 13 event at level warning or higher

```

<a href='Hidden comment: next/prev'></a>


&lt;TABLE width="100%"&gt;



&lt;TR&gt;



&lt;TD&gt;

[<-- HotKeys](HotKeys.md)


&lt;/TD&gt;



&lt;TD align="right"&gt;

[DevelopingPlugins -->](DevelopingPlugins.md)


&lt;/TD&gt;



&lt;/TR&gt;



&lt;/TABLE&gt;

