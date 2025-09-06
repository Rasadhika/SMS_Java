# Student Management System (Java + JDBC + MySQL)

## Overview
A console-based Java application to manage students using JDBC with MySQL (XAMPP).  

Features:
- Add Student
- View Students
- Update Student
- Delete Student

---

## Requirements
- Java 8 or later
- MySQL (via XAMPP)
- MySQL Connector/J

---

## Setup
1. Start XAMPP → Start MySQL.  
2. Create the database:
   ```sql
   CREATE DATABASE studentdb;
   USE studentdb;
   CREATE TABLE students (
       id INT PRIMARY KEY,
       name VARCHAR(100),
       age INT,
       course VARCHAR(100)
   );

