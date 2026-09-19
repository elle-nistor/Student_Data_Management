# Student Data Management & Sorting CLI

This Java application is a terminal-based student database and gradebook manager. It allows a user to input, store, and run analytical queries on student academic records entirely from the command line.

## Features

* **Data Entry & Storage:** Allows teachers or admins to input detailed student profiles, including name, gender, grades across 8 subjects, attendance records, and behavioral standing.
* **Data Persistence:** Automatically loads existing student records from a local file (`date_elevi.txt`) when it starts, and saves all new changes back to the file when the user exits, ensuring data is never lost between sessions.
* **Analytics & Filtering:** Through an interactive menu, the user can run specific queries to find:
  * The smartest student overall (highest total score).
  * Students with the best attendance (fewest combined absences).
  * The overall grade average of the entire class.
  * Specific demographics (e.g., finding the female student with the lowest English grade to offer tutoring).
  * "Exemplary" students (perfect behavior, perfect Math/CS scores, zero unexcused absences).
* **Sorting:** Includes custom algorithms to sort and display the student roster either alphabetically by name, or by ranking the top 5 students based on their overall GPA (using a Bubble Sort).

> **In short:** It takes raw student data, stores it securely, and acts as a search engine to help a teacher quickly find performance trends and specific student metrics.

## Tech Stack

* **Language:** Java
* **Concepts:** Object Serialization, File I/O, Custom Sorting Algorithms (Bubble Sort), Command Line Interfaces
