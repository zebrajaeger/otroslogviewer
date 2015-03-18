## Introduction ##

The instructions provided describe how to add and implement your log maker (highliter).


## Details ##
To write your filter, you need to:

  * Implement the `pl.otros.logview.markers.AutomaticMarker` interface,
> Note: The `toMark` method returns `true` when the condition for the `LogData` is fulfilled. The `getMarkerGroups` method returns `groups` in pop-up menu of the marked entry. Separate the groups with commas.
  * Put your jar in the `./plugins/markers` directory.


## AutomaticMarker interface ##

```

public interface AutomaticMarker {

  public boolean toMark(LogData data);

  public String getName();

  public String getDescripion();

  public String[] getMarkerGroups();

  public MarkerColors getColors();

}


```

