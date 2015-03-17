The instructions provided describe how to add and implement your own log filter.


## Details ##

To write your filter, you need to:
  * Implement the `pl.otros.logview.filter.LogFilter` interface,
  * Implement GUI for the filter (if necessary),
  * Call the `LogFilterValueChangeListener.valueChanged()` method when a filter GUI option changes (for example, `Level`),
  * Put your jar in the `./plugins/filters` directory.

### LogFilter interface ###
```
public interface LogFilter {

    public String getName();

    public void init(Properties properties, LogDataTableModel logDataTableModel);

    public boolean accept(LogData logData, int row, boolean marked);

    public void setEnable(boolean enable); 

    public boolean isEnable();

    public Component getGUI();

    public void setValueChangeListener(LogFilterValueChangeListener listener);

}

```



<a href='Hidden comment: next/prev'></a>


&lt;TABLE width="100%"&gt;



&lt;TR&gt;



&lt;TD&gt;

[<-- Custom marker - Java code](ImplementingAutomaticLogMarker.md)


&lt;/TD&gt;



&lt;TD align="right"&gt;

[Implementing custom log importer -->](ImplementLogImporter.md)


&lt;/TD&gt;



&lt;/TR&gt;



&lt;/TABLE&gt;

