# Extensions #

OtrosLogViewer support a few kind of extenstions.
  * [Log importers](ImplementLogImporter.md)
  * [Automatic markers](ImplementingAutomaticLogMarker.md)
  * [Log filters](ImplementingLogFilter.md)
  * [Message formatters](ImplementingMessageFormatter.md)
  * [ImplementingMessageColorizer Message colorizer

## How to install ##
OtrosLogViewer loads extensions from 2 directories:
  * $OLV\_HOME/plugins - for all users
  * $HOME/.otroslogviewer/plugins - for one user only
When you have implemented extension, copy jar to a apropriate folder. Your extension will be automaticlly loaded at application start.

Structure of plugins folder is
```
$OLV_HOME|$HOME/.otroslogviewer
   plugins/
      filters/  -> put your log filter jar here
      logimporters/ -> put your log importer/parser jar/property definition here
      markers/ -> put your log automatic marker jar/property definition here
      message/ -> put your MessageFormatters/MessageColorizer jar/property definition here
```
