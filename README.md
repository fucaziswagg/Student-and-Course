# Student-and-Course
This software was created by coding 2 classes, "student" and "course", using a test driven development approach. There were three JUnit test suites provided that ensured the functionality of the code.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  The student class created a student object with the properties (instance variables) of first and last name (string), student ID number (int), attempted credits (double), passing credits (double), total grade quality points (double), and bear bucks balance (double; Washington University's campus currency). This class have several getter methods, allowing users to read the name of a student object, the ID number, the total attempted credits, the total passing credits, and the current bear bucks balance. Additioanlly, other methods included: 
- submitting a final grade (based on credits and numeric grade value)
- calculating GPA
- getting current class standing (based on total passing credits, returning a string value of freshamn, sophomore, junior, or senior)
- deposting, deducting, and cashing out bear bucks
- student object to a string (returned students full name and student ID)
- eligibility for Phi Beta Kappa greek organization (returned a boolean based on completed/passed credits and GPA requirements)
- create legacy class (returned a new student object. Took in the parameters of the new students first name, a secondary parent object, a boolean to determine if the new students last name would be hyphenated, and an ID for the new student).

The course class implemented the student class, and created a course object with the properties (instance variables) of course name (string), credit hours (int), roster (array of student objects), and capacity (int). This class have several getter methods, allowing users to read the values of the instance variables, as well as the number of currently enrolled students and the total seats remaining. Additioanlly, other methods included:
- adding a student object to the roster (returned a boolean based off if the student was successfully added)
- return the Student object at a particular index in the roster
- return the roster of students (returned a string)
- calculate the average GPA of the students in the course (returned a double)
- a course object to a string (retuned the course name and the credit hours)
