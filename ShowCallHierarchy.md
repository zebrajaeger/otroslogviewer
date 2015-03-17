# Introduction #

How "Show call hierarchy" works.

# Details #

OtrosLogViewer can show call hierarchy. To make it possible log events message have to begin with "ENTRY" or "ENTER" when login entering method and "RETURN" or "EXIT" when returning from method (return value or throw exception). You can find example log [here](http://code.google.com/p/otroslogviewer/source/browse/trunk/test/resources/hierarchy/hierarchy.log). When log file is imported, select event and from right-click menu choose "Show call hierarchy". Call hierarchy filter will be activated and events not matching to call hierarcy will be fitered out.