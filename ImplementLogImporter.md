# Introduction #

OtrosLogViewer can load custom [LogImporter](http://code.google.com/p/otroslogviewer/source/browse/trunk/OtrosLogViewer-app/src/main/java/pl/otros/logview/importer/LogImporter.java).


# Details #

LogImporter takes InputStream as a source of log events. Parsed log events have to added to LogDataCollector. ParsingContext can be used to store data and objects like date formatter. LogImporter is not thread safe, it can be invoked by many thread at the same time.

To implement LogImporter you have to:
  1. Implement LogImporter interface
  1. Put your jar into $OLV/plugins/logimporters or $HOME/.otroslogviewer/plugins/logimporters
  1. Your implementation will be detected and loaded during application start

LogImporter interface
```
public interface LogImporter extends PluginableElement {

public static final int LOG_IMPORTER_VERSION_1 = 1;

public final String PARSER_CLASS = "parser.class";

public final String PARSER_DISPLAYABLE_NAME = "parser.displayableName"; public final String PARSER_MNEMONIC = "parser.mnemonic"; public final String PARSER_KEY_STROKE_ACCELELATOR = "parser.keyStrokeAccelelator"; public final String PARSER_ICON = "parser.icon";

public void init(Properties properties) throws InitializationException;

/** * Initialize parsing context specific resources, which are not thread safe (i.e. DateFormat) 
  * *  @param parsingContext 
  */
public void initParsingContext(ParsingContext parsingContext);

public void importLogs(InputStream in, LogDataCollector dataCollector, ParsingContext parsingContext);

public String getKeyStrokeAccelelator();

public int getMnemonic();

public Icon getIcon(); 
}

```



<a href='Hidden comment: next/prev'></a>


&lt;TABLE width="100%"&gt;



&lt;TR&gt;



&lt;TD&gt;

[<-- Implementing custom filters](ImplementingLogFilter.md)


&lt;/TD&gt;



&lt;TD align="right"&gt;

[Implementing custom message formatter -->](ImplementingMessageFormatter.md)


&lt;/TD&gt;



&lt;/TR&gt;



&lt;/TABLE&gt;

