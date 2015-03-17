# Searching events #
Screenshots below show search toolbar:

![http://otroslogviewer.googlecode.com/svn/wiki/screen-toolbar.png](http://otroslogviewer.googlecode.com/svn/wiki/screen-toolbar.png) In **Search** field you can specify the text you are looking for. The found text in _details_ view is marked in yellow. Following search methods are provided:
  * String contains
  * Regex
  * Query search


## String contains ##
'String contaions' mode compares whether the message log contains the provided text (case insensitive).

## Regex search ##
'Regex mode' test whether the message log matches provided regular expression (case insensitive).


## Query search options ##
'Query' mode is using SQL-like query language (i.e. level>=warning && msg~=failed && thread==t1) to find log events.

Supported filed identifiers
  * LOGGER
  * LEVEL
  * CLASS
  * FILE
  * LINE
  * METHOD
  * MSG/MESSAGE
  * NDC
  * EXCEPTION -- remove
  * TIMESTAMP/DATE
  * THREAD
//Logsource?
  * MARK
  * NOTE
  * PROP.[name](key.md)
NOTE: To build expressions using PROP (properties) field identifier, the key being evaluated must be added after the field identifier and a period
PROP keys are **case sensitive**. PROP.server is not equivalent to PROP.SERVER

Supported operators:
  * == equals
  * ~= case-insensitive partial-text match
  * != not equals
  * LIKE supports regular expressions
  * EXISTS not null
  * < inequality operators
  * <=
  * >
  * >=
  * && logical and
  * || logical or
  * ! logical not

Date formatts
//TODO

Expression shortcut:
Since it is very common need to perform a case-insensitive partial-text match against the Message field, any single word or any single phrase (the phrase must be delimited by single-quote marks) will act as a rule defined using the MSG ~= syntax.

Example: to search the Message field for the phrase 'logged in', instead of defining the expression MSG ~= 'logged in', use 'logged in' by itself (including the single quotes). Instead of using MSG ~= evaluation to search for the word 'evaluation', use evaluation by itself (no need for single quotes since it's a single word).

NOTE: This shortcut syntax is designed to be used to search for single words or phrases only, and will not work when used in combination with other operators or expressions. When building complex expressions, use the MSG ~= syntax.
Operator limitations:

Inequality operators are supported for Levels (LEVEL > info) and anything that can be converted to a numeric value (including timestamps).
In order to build expressions using the Timestamp field, provide the Timestamp value in this format: 'yyyy-MM-dd HH:mm:ss'. Note the single ticks, which are required because of the space between the days and hours. The Timestamp field contains millisecond information, but the milliseconds are rounded off during event evaluation.

Examples:
  * date<'2012-02-22 19:35:43' -> events before 2012-02-22 19:35:43
  * (date>'2012-02-22 19:35:43' || msg~=import) && !(class~=Parser) -> events after 2012-02-22 19:35:43 or message contains string "import", but class name do not contains string Parser
  * mark==true -> marked events
  * mark==Aqua -> marked with color Aqua

### Shourtcuts ###
Search box has the following shortcuts:
  * Enter - search next
  * Alt+enter - search previous
  * Ctrl+enter - mark all found events

If you want to mark your search result you can:
  * Select option **Mark search result** and perform the search. The result events are marked.
  * Enter the text you want to search and click on **Mark all found**. All matching events are marked. You can also select the marking color.

Other search related actions:

  * ![http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/arrow-270-medium.png](http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/arrow-270-medium.png) Search the next event
  * ![http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/arrow-090-medium.png](http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/arrow-090-medium.png) Search the previous event
  * ![http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/navigation-270-button.png](http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/navigation-270-button.png) Go to the next marked event or with note
  * ![http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/navigation-090-button.png](http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/navigation-090-button.png) Go to the previous marked event or with note
  * ![http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/compile.png](http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/compile.png) Go to the next event with level Info or higher
  * ![http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/compile-warning.png](http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/compile-warning.png) Go to the next event with level Warning or higher
  * ![http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/compile-error.png](http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/compile-error.png) Go to the next event with level Severe
  * ![http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/compile-flip.png](http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/compile-flip.png) Go to the previous event with level Info or higher
  * ![http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/compile-warning-flip.png](http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/compile-warning-flip.png) Go to the previous event with level Warning or higher
  * ![http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/compile-error-flip.png](http://otroslogviewer.googlecode.com/svn/trunk/OtrosLogViewer-app/src/main/resources/img/fugue/compile-error-flip.png) Go to the previous event with level Severe or higher



<a href='Hidden comment: next/prev'></a>


&lt;TABLE width="100%"&gt;



&lt;TR&gt;



&lt;TD&gt;

[<-- Log4j PatternLayout](Log4jPatternLayout.md)


&lt;/TD&gt;



&lt;TD align="right"&gt;

[Marking events -->](MarkingEvents.md)


&lt;/TD&gt;



&lt;/TR&gt;



&lt;/TABLE&gt;

