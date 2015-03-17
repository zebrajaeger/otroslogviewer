

# Introduction #

How to parse log4j pattern layout


# Details #

There are several ways to parse log4j log messages:
  1. Using the new log4j-native parser
  1. Using the log4j PatternLayout parser
  1. Using the rePattern parser

# The log4j-native parser #

The simplest way is to create a log4j-native parser.
  1. Create _filename_.pattern file in the ./plugins/logimporters/ directory.
  1. Edit the file.
  1. Add the 'type' property and set its value to 'log4j-native'.
  1. Specify the parser name by adding the 'name' property.
  1. Specify the description (used as _tooltip_) by adding the 'description ' property.
  1. Specify the conversionPattern property by copying the conversionPattern used in the log4j configuration file. The following fields are parsed:
    * %c, %C : Class
    * %d : Timestamp
    * %F : File
    * %L : Line
    * %m : Message
    * %M : Method
    * %n : new line
    * %p : Level
    * %t : Thread
    * %x : NDC
  1. The date format is parsed according to the PatternLayout specification.

## Examples: ##

File for parsing log4j pattern "%d{yyyy-MM-dd HH:mm:ss.SSS} %-5p [%t] %c: %m%n":
```
type=log4j-native
conversionPattern=%d{yyyy-MM-dd HH:mm:ss.SSS} %-5p [%t] %c: %m%n
name=Log4j-pattern: %d{yyyy-MM-dd HH:mm:ss.SSS} %-5p [%t] %c: %m%n
```

# The log4j PatternLayout parser #

To create a log4j PatternLayout parser:
  1. Create _filename_.pattern file in the ./plugins/logimporters/ directory.
  1. Edit the file.
  1. Add the 'type' property and set its value to 'log4j'.
  1. Specify the parser name by adding the 'name' property.
  1. Specify the description (used as _tooltip_) by adding the 'description ' property.
  1. Specify the log pattern by adding the 'pattern' property which will be applied to the first line of input log files. The supplied keywords in value field are:
    * TIMESTAMP
    * LOGGER
    * LEVEL
    * THREAD
    * CLASS
    * FILE
    * LINE
    * METHOD
    * RELATIVETIME
    * MESSAGE
    * NDC
    * PROP(key)
  1. Specify date format by adding the property 'dateFormat', using patterns from [java.text.SimpleDateFormat](http://download.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html)
  1. For custom level mapping, add the property 'customLevels' providing values in the format CustomeLevel1=Log4jLevel,CustomeLevel2=Log4jLevel
  1. Since `*.pattern` files are Java properties files, rules for line continuation, encoding, and special characters (for example in your `description` setting) are documented in the [javadoc for java.util.Properties](http://docs.oracle.com/javase/7/docs/api/java/util/Properties.html#load(java.io.Reader)).  One significant consequence of this is that the  order of your properties in the file makes no difference.

## Examples: ##


If your file pattern layout is like in the example:

`%d %-5p [%t] %C{2} (%F:%L) - %m%n `

specify the following value for the pattern variable:

`TIMESTAMP LEVEL [THREAD] CLASS (FILE:LINE) - MESSAGE `


File for parsing log4j pattern "%d{ISO8601} %-5p [%t] %m%n":
```
type=log4j
pattern=TIMESTAMP LEVEL [THREAD]  MESSAGE
dateFormat=yyyy-MM-dd HH:mm:ss,SSS
name=Lo4j-pattern: %d{ISO8601} %-5p [%t] %m%n
```

Defining custom levels:
```
customLevels=I=INFO,D=DEBUG,W=WARN,E=ERROR
```

# rePattern Alternative #

## rePattern Purpose and Prerequisites ##
This section explains how to use property `rePattern` instead of `pattern`.
This feature is only available from OtrosLogViewer version 1.1.0 forward.
If the `pattern` setting works for you, then that is more simple and you should not use rePattern.
`rePattern` specifications are more complicated than `pattern` specifications, but they can parse out logging fields from any text log file, not just Log4j text log files.
The additional power comes from the ability to capture or ignore any characters in the input log, and to capture fields conditionally.

Before using rePattern, you should understand everything in the main section of this page, because everything works the same other than
  1. You specify a `rePattern` property instead of a `pattern` property
  1. You specify multiple `<FIELDNAME>.group` properties
Both of these settings are detailed below.

## rePattern syntax and rules ##

  * **`rePattern` property**
> > A regular expression written with [Java regular expression syntax](http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html) (which is nearly exactly the same as Perl r.e. syntax and very close to Python r.e. syntax).
    1. Since the `*.pattern` file is a [Java properties file](http://docs.oracle.com/javase/7/docs/api/java/util/Properties.html#load(java.io.Reader)), you must double up back-slashes, so that if you intend "\s", you must type in "\\s".
    1. The pattern must match the entire first line input log records.  We use the Java [matches operation](http://docs.oracle.com/javase/7/docs/api/java/util/regex/Matcher.html#matches()), not the more liberal find operation.
    1. Your pattern must include a (parenthesized) _capture group_ for each field that you want to capture.  The capture groups may be optional by using the ? operator or by including them in a larger optional expression.  You specify fields in the `rePattern` string just with parentheses (the target field names will be specified next...).
    1. There is a limitation in version 1.1.0 where custom fields may not be optional.  The fix for this has been committed and the limitation will be eliminated with version 1.2.0.
  * **`<FIELDNAME>.group` properties**
> > For each capture group in your `rePattern` string, you must specify the the field name for that capture group.  For example, if you set `LEVEL.group=1`, that means that the first () capture group in your `rePattern` string should be mapped to the field `LEVEL`.
    1. Since the `*.pattern` file is a [Java properties file](http://docs.oracle.com/javase/7/docs/api/java/util/Properties.html#load(java.io.Reader)), the order of the multiple `<FIELDNAME>.group` settings doesn't matter, and it doesn't matter if the ```rePattern`` setting comes before, after or in between them.
    1. You must specify one `<FIELDNAME>.group` value for each and every () capture group, with the value of the first field set to `1`, the value of the second field set to `2`, etc.
    1. If you set a property `TIMESTAMP.group`, then the `dateFormat` pattern will be applied to that field value to extract the date/time from it.
    1. Specify custom fields exactly the same as for pre-defined fields.  There is no need to use `PROP(key)` syntax.  If you specify a custom field like `CUSTOMFIELD.group=3`, it will just work.
    1. You can use the `(?i)` operator to toggle case-sensitivity for all or parts of your pattern.  See [the syntax reference](http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html).

**GOTCHA!**  Remember to double back-slashes in your pattern files. It's very easy to miss one, and one is all it takes to break a pattern.

The general limitation (of Log4jPatternLayout) that only the first line of each log record can be parsed into specified fields applies to rePattern too.
All subsequent lines are interpreted as part of the message field or of a stack trace.

## rePattern Examples ##
### rePattern Example 1 ###
This example is only for educational purposes, because you should use the simple `pattern` setting for this use case in the real world.
This is the exact same situation for the first example given above.
Here we are just using `rePattern` instead of `pattern` to load the same input log files.

To repeat from the setup of example #1 above, we want to load log files written with Log4j [ConversionPattern](http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html):

`%d %-5p [%t] %C{2} (%F:%L) - %m%n `

Here is the complete, working `*.pattern` file to load it using `rePattern`.  You can download this as [rePattern\_ex1.pattern](http://wiki.otroslogviewer.googlecode.com/git/rePattern_ex1.pattern).
```properties

```
name=rePattern emulating Simple Log4j pattern
description=Example from https://code.google.com/p/otroslogviewer/wiki/Log4jPatternLayout

type=log4j
rePattern=(\\S+ \\S+) (\\S+) +\\[([^\\]]+)\\] (\\S+) \\(([^:]+):(\\d+)\\) - (.+)
# Following is the equivalent simple pattern setting:
#pattern=TIMESTAMP LEVEL [THREAD] CLASS (FILE:LINE) - MESSAGE
dateFormat=yyyy-MM-dd HH:mm:ss,SSS
charset=UTF-8

TIMESTAMP.group=1
LEVEL.group=2
THREAD.group=3
CLASS.group=4
FILE.group=5
LINE.group=6
MESSAGE.group=7
```
```
To convert this to simple `pattern` usage, remove the `#` character from the `pattern` line and comment out or delete the `rePattern` and `*.group` lines.


### rePattern Example 2 ###
This is a realistic example where you are capturing log files that contain some text that you want to ignore, and which has fields that are not always represented.
The log files may have been written by a non-Java application or even shell scripts.

Here are sample lines from a log file that we want to view.  To try out the example, download this as   You can download this as [rePattern\_ex2.log](http://wiki.otroslogviewer.googlecode.com/git/rePattern_ex2.log).
```
2013-12-27 10:41:42,7928 Presentation FATAL [TID:4321] User:blaine A fatal message
2013-12-27 10:41:42,8037 Core         INFO  User:debbie An info message
2013-12-27 10:41:43,2953 Presentation FATAL A fatal message
2013-12-27 10:41:43,2955 DB           INFO  [TID:4321] An info message
2013-12-27 10:41:43,8151 Core         FATAL [TID:N/A] A fatal message
```

Not the following peculiarities here that a simple `pattern` specification can't handle:
  * Field-indicator context strings like "[TID:" and "User:" are sometimes present and sometimes not.  These strings are not log data so we don't ever want to extract them, but we do want to use their presence and location to figure out when to capture the accompanying data values.
  * Time specifications are to 1/10000 s.  Since OtrosLogViewer (like most Java logging applications) only tracks log entries to the millisecond, we want to ignore the last digit.
  * The Thread ID field is sometimes present and sometimes not
  * We want to ignore non-numeric thread IDs because we know that only numeric thread IDs are valid for the log-writing application.
  * The user field is sometimes present and sometimes not.  We will capture this to the predefined field "NDC" so they will be presented in a dedicated column.  (More importantly, as of today, custom fields may not be optional like our user field is here).
  * We want to capture the application level field (which is always present) to a custom field named `APPLEVEL`.  (Custom fields are presented in the OLV Properties column).

Here is the pattern file that works for this.  You can download this as [rePattern\_ex2.pattern](http://wiki.otroslogviewer.googlecode.com/git/rePattern_ex2.pattern)
```
name=rePattern with optional ignore and capture strings
description=Example from https://code.google.com/p/otroslogviewer/wiki/Log4jPatternLayout

type=log4j
rePattern=(\\S+ \\S+)\\d (\\S+) +(\\S+) +(?:\\[TID:(\\d+)?[^\\]]*\\] )?(?:User:(\\S+) )?(.*)
dateFormat=yyyy-MM-dd HH:mm:ss,SSS
charset=UTF-8

TIMESTAMP.group=1
# APPLEVEL is a Custom field.  Displayed as key=value pairs in OLV Properties column.
APPLEVEL.group=2
LEVEL.group=3
THREAD.group=4
NDC.group=5
MESSAGE.group=6
```

And finally, here is what you see when you load the log file sample above with the pattern file above:
![http://wiki.otroslogviewer.googlecode.com/git/rePattern-ex2.png](http://wiki.otroslogviewer.googlecode.com/git/rePattern-ex2.png)

<a href='Hidden comment: next/prev'></a>


&lt;TABLE width="100%"&gt;



&lt;TR&gt;



&lt;TD&gt;

[<-- Included log parsers](IncludedLogParsers.md)


&lt;/TD&gt;



&lt;TD align="right"&gt;

[Searching for events -->](SearchEvents.md)


&lt;/TD&gt;



&lt;/TR&gt;



&lt;/TABLE&gt;

