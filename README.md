## Student Report Card Generator
A console-based Java application for managing student report cards using object-oriented programming and file handling. The system supports creating, storing, retrieving, and deleting student academic records in a structured format.

## Overview

This project demonstrates the practical application of core Java concepts in a real-world scenario. It provides a menu-driven interface that allows users to manage student report data efficiently with persistent storage.

## Features

* Create and store student report cards
* Automatic calculation of total, average, and grade
* Persistent storage using file handling
* Display all saved records
* Delete records using roll number
* Structured and modular code design


## Technology Stack

* **Language:** Java
* **Concepts:** Object-Oriented Programming (Inheritance, Encapsulation)
* **I/O Handling:** FileReader, FileWriter, BufferedReader, BufferedWriter
* **User Input:** Scanner

## Project Structure

```id="projstruct02"
.
├── src/
│   ├── StudentReportCardGenerator.java
│   ├── Student.class
│   ├── ReportCard.class
│   ├── FileHandler.class
│   └── App.java
│
├── ReportCards.txt
├── README.md
└── .vscode/settings.json
```
## System Workflow

1. Input student details (name, roll number, class)
2. Enter marks for five subjects
3. System calculates total, average, and grade
4. Data is stored in a file for future use

## Data Format

Stored in `ReportCards.txt` as:

```id="dataformat02"
Name,RollNo,Class,Total,Average,Grade
```

## Grading Criteria

| Average Score | Grade |
| ------------- | ----- |
| 90 and above  | A     |
| 75 – 89       | B     |
| 60 – 74       | C     |
| 50 – 59       | D     |
| Below 50      | F     |


## How to Run

### Using Terminal

```bash id="run02"
javac StudentReportCardGenerator.java
java StudentReportCardGenerator
```

### Using VS Code

1. Install Java Extension Pack
2. Open the project folder
3. Run `StudentReportCardGenerator.java`

## Sample Output

```id="output02"
--- REPORT CARD ---
Student Name : John
Roll Number  : 101
Class        : B.Tech
Total Marks  : 450
Average      : 90.0
Grade        : A

## Key Design Elements
* Inheritance used to extend student details into report card functionality
* Encapsulation for controlled data access
* Separation of concerns through a dedicated file handling class
* Menu-driven interface for better usability
## Challenges Faced
* File Handling Complexity:
  Managing read/write operations while maintaining correct data format required careful implementation, especially when appending and parsing records.
* Data Consistency:
  Ensuring that stored data remains structured (CSV format) so it can be reliably read and displayed later.
* User Input Handling:
  Managing input using `Scanner` (especially mixing `nextInt()` and `nextLine()`) required handling buffer issues properly.
* Program Flow Control:
  Designing a clean and error-free menu-driven system with continuous execution until exit.
## Limitations
* No graphical user interface
* No validation for incorrect or invalid inputs
* Data stored in plain text format
* No option to update existing records

## Future Enhancements
* Integration with a database (MySQL or SQLite)
* GUI using JavaFX or Swing
* Input validation and better error handling
* Update/edit functionality for reports
* Export reports to PDF or Excel
