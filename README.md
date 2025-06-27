Student-project-management-java by kasish 
🎓 Student Management System (Java, OOP, Console UI)
This project is a Console-Based Student Management System developed in Java, utilizing core Object-Oriented Programming (OOP) principles such as Inheritance, Encapsulation, Abstraction, and Polymorphism. It allows both Admins and Students to perform various tasks like managing courses, subjects, taking exams, and viewing results.

📁 Project Structure
Main.java — Entry point and central controller of the application
User (abstract class) — Base class for Admin and Student
Student, Admin — Extend User with specific features
Course, Subject, Question, ExamResult — Encapsulate core entities and business logic
StudentManagementSystem — Manages the entire system using composition and aggregation
👤 Features
For Students:
Register with name, email, and age
View available courses and select one
Choose subjects under selected course
Attempt multiple-choice question-based (MCQ) exams
View detailed exam results with pass/fail status
For Admin:
Login with predefined credentials
Add new courses and subjects
View all registered students
View all student exam results
