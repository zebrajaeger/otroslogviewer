# Requirements and installation #

# Requirements #

Java Runtime Environment 6 is reuqired to run OtrosLogViewer

# Downloads #

Downloads are hosted on Source Forge: [https://sourceforge.net/projects/otroslogviewer/files/](https://sourceforge.net/projects/otroslogviewer/files/)

# Installation #

OtrosLogViewer is not providing installer. You have to uzip package and run olv.[bat|sh].
If you want to run OtrosLogViewer for batch processing you have to run olv-batch.[bat|sh]. For more information about batch processing read //TODO

# Where OtrosLogViewer stores files #
OtrosLogViewer stores plugins in 2 places:
  * $OLV\_HOME/plugins - all users will use this plugins
  * $HOME/.otroslogviewer - plugins only for selected user

OtrosLogViewer stores configuration in 2 places:
  * $OLV\_HOME/config.xml - configuration loaded first, for all users. Changes will not be save here automatically.
  * $HOME/.otroslogviewer -  loaded second, configuration for user. Changes are saved here.

Bookmarks are stored in $HOME/.vfsjfilechooser/favorites.xml. This file is encrypted. //TODO check algorithm




<a href='Hidden comment: next/prev'></a>


&lt;TABLE width="100%"&gt;



&lt;TR&gt;



&lt;TD&gt;

[<-- Introduction](Introduction.md)


&lt;/TD&gt;



&lt;TD align="right"&gt;

[Opening logs -->](OpeningLogs.md)


&lt;/TD&gt;



&lt;/TR&gt;



&lt;/TABLE&gt;

