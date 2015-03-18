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


