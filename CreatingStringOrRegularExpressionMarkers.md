## Introduction ##

You can create your log markers by defining a regular expression or string in the **Condition** field to match the condition you are looking for. The markers are saved as a properties file in the `./plugins/markers` folder with `stringMarker` or `regexMarker` extensions.


**The markers are reloaded when the application restarts!**


## Details ##

To create your marker, select **String and Regex marker editor** in the Tools menu.

## String marker ##
A string marker contains the following properties:

  * **File**: File path
  * **Name**: Name of the marker
  * **Description**: Description of the marker
  * **Groups**: Names of the groups, separated with comma
  * **Condition**: String to be found
  * **Ignore case**: Select when you want your match to ignore case
  * **(Pre)condition matches**: Select when you want to search for the string matches or search for logs without the defined string.



## Regular expression marker ##
A regular expression marker contains the following properties:

  * **File**: File path
  * **Name**: Name of the marker
  * **Description**: Description of marker
  * **Groups**: Names of the groups, separated with comma
  * **Condition**: A regular expression to be found
  * **Precondition**: A string that needs to be found **before** checking on the regular expression.
For example, when you define the regular expression `.*return code.*[\1-9].*`, you can search for the `return code` string before checking against the regular expression. Introduced for performance reasons.
  * **Ignore case**: Select when you want your match to ignore case
  * **(Pre)condition matches**: Select when you want to search for precondition string matches or search for logs without the defined string.



<a href='Hidden comment: next/prev'></a>


&lt;TABLE width="100%"&gt;



&lt;TR&gt;



&lt;TD&gt;

[<-- Marking events](MarkingEvents.md)


&lt;/TD&gt;



&lt;TD align="right"&gt;

[Notes -->](Notes.md)


&lt;/TD&gt;



&lt;/TR&gt;



&lt;/TABLE&gt;

