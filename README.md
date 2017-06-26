# TomTom-Quiz

The submission is evaluated based on following:
Proper use of object oriented design to ensure extendibility. As an example, how much would the design have to change if 10 new patterns were to be added?
Loose coupling between input source, core logic, and output source.
Unit tests that test behavior instead of just methods.
Program should be packaged such that no setup is required to make it run.
 
Write a program (source and unit tests) "PatternCounter" that reads an input document from a file (path provided as first command line argument) and calculates the number of occurrences of one of the 3 patterns based on the second command line argument:
1: Counts occurrences of each unique word in the document
2: Counts occurrences of each unique number in the document
3: Counts occurrences of each unique phrase of three consecutive words in the document
 
It then prints each word, number or phrase and its count on standard output separated by a comma in a new line. For the purpose of this exercise, use space character as the de-limiter for words. String matching should be case sensitive. Here are some examples of output with a sample input file using different arguments:
 
Contents of Input document (Input.txt): "1000 a big surprise 2000 hello is a big surprise 1000"
 
PatternCounter Input.txt 1
a, 2
big, 2
surprise, 2
hello, 1
is, 1
 
PatternCounter Input.txt 2
1000, 2
2000, 1
 
PatternCounter Input.txt 3
1000 a big, 1
a big surprise, 2
big surprise 2000, 1
surprise 2000 hello, 1
2000 hello is, 1
hello is a, 1
is a big, 1
big surprise 1000, 1
 
The output could be empty if there are less than 3 words in the document.
