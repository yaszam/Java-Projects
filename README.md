# Java-Projects
An assignment from my 2011 Data Structures course. 
We are to create a sparse list using the List Interface in which an element may be inserted at any non negative integer, with no restrictions.
Its behaviour is similar to a javascript list. Concepts such as inheritance and generics are used.


As an example, if we have a list with an element stored in indexes 0, 1, 2, and 3, it is possible to add an element to index 57. 
The indexes 4-56 will have "null" printed as their value (when toString() is called) unless the user gives a value to store for these "unspecified indexes". 
The unspecified indexes are not stored within the internal structure of the class, so these indexes do not waste memory.


Once I completed this project, I had realized the way in which I find the size of the list is slow. To improve my implementation I would have a "size" counter
be incremented when the user adds an item to the list. This would make my implementation cosiderably faster.
