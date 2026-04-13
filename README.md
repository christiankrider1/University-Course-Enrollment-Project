# Course Management System (Java)

## Description

This is a simple console-based Course Management System written in Java. It allows users to create courses, enroll students, assign grades, and calculate overall course performance through an interactive menu.

The program focuses on basic object-oriented programming concepts such as classes, methods, input validation, and data management using collections.

---

## Features

* Add new courses with a name, code, and student capacity
* Create new students or use existing ones
* Enroll students in courses
* Assign grades (0–100) to students for specific courses
* Calculate overall grades for a student across all enrolled courses
* Input validation to prevent invalid data entry
* Menu-driven interface for easy navigation

---

## How It Works

When the program runs, users are presented with a menu:

1. Add new course
2. Enroll students
3. Assign grades
4. Calculate overall course grades
5. Exit program

Users select an option by entering a number, and the program guides them through the required steps.

---

## Requirements

* Java Development Kit (JDK) 8 or higher
* A Java IDE (e.g., IntelliJ, Eclipse) or command-line environment

---

## How to Run

1. Compile the program:

   ```
   javac Main.java
   ```

2. Run the program:

   ```
   java Main
   ```

---

## Project Structure

This program relies on multiple classes:

* `Main` – Handles user input and menu navigation
* `Student` – Stores student information and enrolled courses
* `Course` – Stores course details
* `CourseManagement` – Handles operations like adding courses, enrolling students, assigning grades, and calculating averages

---

## Example Usage

* Create a course called "Intro to Java"
* Add a student named "John" with ID 101
* Enroll John in the course
* Assign a grade of 90
* Calculate John’s overall grade

---

## Notes

* All inputs are validated to ensure correct data types and ranges
* Students must be enrolled in a course before receiving a grade
* Courses must exist before students can be enrolled

---

## Future Improvements

* Save data to a file or database
* Add a graphical user interface (GUI)
* Support multiple instructors or departments
* Display detailed grade reports

---

## Author

Created as a beginner-friendly Java project to practice core programming concepts.
