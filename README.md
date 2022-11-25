Chronoswim
===============
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![en](https://img.shields.io/badge/lang-en-red.svg)](https://github.com/alejandroMAD/chronoswim/blob/master/README.md)
[![es](https://img.shields.io/badge/lang-es-yellow.svg)](https://github.com/alejandroMAD/chronoswim/blob/master/README.es.md)

Demo
----------
![Demo screenshot](/screenshot.png)

A Java Swing application to record competitive races times and keep a database file of races results, 
using a MVC architectural pattern and performing CRUD on a CSV file of records. Compile with Java 1.8 or higher.

Features
-------------------
* Races allow registration of a name of the event, the date-time stamp and names of 8 competitors.
* A race can be run without specifying a name ("Default Race" will be used), but not without registering 8 competitors, with form validation rules to enforce it.
* The race clock is shown in a format: minutes:seconds,fractionSeconds similarly to real time sports events.
* A race Timer allows to get the individual finish time of every competitor.
* Races results can be saved in a plain CSV file including the names and times of the athletes finishing in the first, second and third place.
* CRUD database operations can be performed on the dynamically indexed CSV file of races records.
* Updating of records is restricted to modifying the race name only to prevent the tampering of sports events results.


Credits
-------------------

* Stop Sign: [Icons created by Freepik - Flaticon](https://www.flaticon.es/iconos-gratis/detener)
* Medals Icons: [Icons created by Freepik - Flaticon](https://www.flaticon.com/free-icons/medal)
* Stopwatch App Icon: [created by Yogi Aprelliyanto - Flaticon](https://www.flaticon.com/free-icons/stopwatch)
* Swimming pool background: [created by Cmapm](https://commons.wikimedia.org/wiki/File:Swimming_pool_50m_2008.svg)


License
--------
    Copyright (C) 2022  Alejandro M. González
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
    
    MIT License: http://opensource.org/licenses/MIT
