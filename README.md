# Smart XML Analizer
This program gives the most relevant element in a html file from a given element in another.

## Getting started
this instructions will get you an stdout with the result of the test

### Prerequisites
```` 
Java version > 1.8 
````
### Examples
to run the app you only hava to do this:
```
java -jar <html_original_file> <html_diff_case> <element_target_id>
```

* java -jar examples/sample-0-origin.html examples/sample-1-evil-gemini.html make-everything-ok-button
````
Element: <a id="make-everything-ok-button" class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okDone(); return false;"> Make everything OK </a>
Match: <a class="btn btn-success" href="#check-and-ok" title="Make-Button" rel="done" onclick="javascript:window.okDone(); return false;"> Make everything OK </a>
Path: html[0]  > body[1]  > div[0]  > div[1]  > div[2]  > div[0]  > div[0]  > div[1]  > a[1] 
Matches attributes: 
Text
onclick
title
class
````

* java -jar examples/sample-0-origin.html examples/sample-2-container-and-clone.html make-everything-ok-button
````
Element: <a id="make-everything-ok-button" class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okDone(); return false;"> Make everything OK </a>
Match: <a class="btn test-link-ok" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okComplete(); return false;"> Make everything OK </a>
Path: html[0]  > body[1]  > div[0]  > div[1]  > div[2]  > div[0]  > div[0]  > div[1]  > div[0]  > a[0] 
Matched attributes: 
Text
rel
href
title
````

* java -jar examples/sample-0-origin.html examples/sample-3-the-escape.html make-everything-ok-button
````
Element: <a id="make-everything-ok-button" class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okDone(); return false;"> Make everything OK </a>
Match: <a class="btn btn-success" href="#ok" title="Do-Link" rel="next" onclick="javascript:window.okDone(); return false;"> Do anything perfect </a>
Path: html[0]  > body[1]  > div[0]  > div[1]  > div[2]  > div[0]  > div[0]  > div[2]  > a[0] 
Matched attributes: 
onclick
rel
href
class
````

* java -jar examples/sample-0-origin.html examples/sample-4-the-mash.html make-everything-ok-button
````
Element: <a id="make-everything-ok-button" class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okDone(); return false;"> Make everything OK </a>
Match: <a class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okFinalize(); return false;"> Do all GREAT </a>
Path: html[0]  > body[1]  > div[0]  > div[1]  > div[2]  > div[0]  > div[0]  > div[2]  > a[0] 
Matched attributes: 
rel
href
title
class
````

### To improve
Te weight number given for the different calculations. 



