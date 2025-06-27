// Main.java
import java.util.*;
import java.io.*;

// User abstract class (Inheritance and Abstraction)
abstract class User {
    protected String name;
    protected String email;
    protected int age;

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayMenu();

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
}

// Admin class (Inheritance)
class Admin extends User {
    private String adminId;

    public Admin(String name, String email, int age, String adminId) {
        super(name, email, age);
        this.adminId = adminId;
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== ADMIN MENU ===");
        System.out.println("1. Add Course");
        System.out.println("2. Add Subject to Course");
        System.out.println("3. View All Courses");
        System.out.println("4. View All Students");
        System.out.println("5. View Student Results");
        System.out.println("6. Logout");
    }

    public String getAdminId() { return adminId; }
}

// Student class (Inheritance)
class Student extends User {
    private String studentId;
    private Course enrolledCourse;
    private List<Subject> selectedSubjects;
    private ExamResult examResult;

    public Student(String name, String email, int age, String studentId) {
        super(name, email, age);
        this.studentId = studentId;
        this.selectedSubjects = new ArrayList<>();
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== STUDENT MENU ===");
        System.out.println("1. View Available Courses");
        System.out.println("2. Select Course");
        System.out.println("3. Choose Subjects");
        System.out.println("4. Take Exam");
        System.out.println("5. View My Results");
        System.out.println("6. Logout");
    }

    // Getters and Setters
    public String getStudentId() { return studentId; }
    public Course getEnrolledCourse() { return enrolledCourse; }
    public void setEnrolledCourse(Course course) { this.enrolledCourse = course; }
    public List<Subject> getSelectedSubjects() { return selectedSubjects; }
    public void addSelectedSubject(Subject subject) { this.selectedSubjects.add(subject); }
    public ExamResult getExamResult() { return examResult; }
    public void setExamResult(ExamResult result) { this.examResult = result; }
}

// Course class (Encapsulation)
class Course {
    private String courseId;
    private String courseName;
    private List<Subject> subjects;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    // Getters
    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public List<Subject> getSubjects() { return subjects; }

    @Override
    public String toString() {
        return "Course ID: " + courseId + ", Name: " + courseName +
                ", Subjects: " + subjects.size();
    }
}

// Subject class (Encapsulation)
class Subject {
    private String subjectId;
    private String subjectName;
    private List<Question> questions;

    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.questions = new ArrayList<>();
        initializeQuestions(); // Add sample questions
    }

    private void initializeQuestions() {
        // Sample questions for each subject
        if (subjectName.equalsIgnoreCase("Java")) {
            questions.add(new Question("What is Java?",
                    new String[]{"Programming Language", "Coffee", "Island", "Car"}, 0));
            questions.add(new Question("Which is not a Java keyword?",
                    new String[]{"static", "Boolean", "void", "private"}, 1));
            questions.add(new Question("What does OOP stand for?",
                    new String[]{"Object Oriented Programming", "Only One Program", "Open Online Platform", "None"}, 0));
            questions.add(new Question("Which method is the entry point of Java program?",
                    new String[]{"start()", "main()", "run()", "execute()"}, 1));
            questions.add(new Question("Java is platform independent. True or False?",
                    new String[]{"True", "False", "Sometimes", "Depends"}, 0));
        } else if (subjectName.equalsIgnoreCase("Python")) {
            questions.add(new Question("Python is interpreted language?",
                    new String[]{"True", "False", "Sometimes", "Never"}, 0));
            questions.add(new Question("Which is not a Python data type?",
                    new String[]{"list", "tuple", "array", "dict"}, 2));
            questions.add(new Question("What is the extension of Python files?",
                    new String[]{".py", ".python", ".pt", ".p"}, 0));
            questions.add(new Question("Who created Python?",
                    new String[]{"Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup"}, 0));
            questions.add(new Question("Python supports multiple inheritance?",
                    new String[]{"True", "False", "Only single", "Not sure"}, 0));
        } else {
            // Generic questions for other subjects
            questions.add(new Question("What is programming?",
                    new String[]{"Writing code", "Playing games", "Watching movies", "Reading books"}, 0));
            questions.add(new Question("Which is a programming concept?",
                    new String[]{"Loop", "Dance", "Sleep", "Eat"}, 0));
            questions.add(new Question("What does debugging mean?",
                    new String[]{"Finding and fixing errors", "Adding features", "Writing documentation", "Testing"}, 0));
            questions.add(new Question("Which is not a data structure?",
                    new String[]{"Array", "Stack", "Queue", "Pencil"}, 3));
            questions.add(new Question("Algorithm is a step-by-step procedure?",
                    new String[]{"True", "False", "Maybe", "Never"}, 0));
        }
    }

    // Getters
    public String getSubjectId() { return subjectId; }
    public String getSubjectName() { return subjectName; }
    public List<Question> getQuestions() { return questions; }

    @Override
    public String toString() {
        return "Subject ID: " + subjectId + ", Name: " + subjectName;
    }
}

// Question class for MCQs
class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    // Getters
    public String getQuestionText() { return questionText; }
    public String[] getOptions() { return options; }
    public int getCorrectAnswerIndex() { return correctAnswerIndex; }
}

// ExamResult class
class ExamResult {
    private int totalQuestions;
    private int correctAnswers;
    private double score;
    private boolean passed;

    public ExamResult(int totalQuestions, int correctAnswers) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.score = (double) correctAnswers / totalQuestions * 100;
        this.passed = score >= 60; // 60% passing criteria
    }

    // Getters
    public int getTotalQuestions() { return totalQuestions; }
    public int getCorrectAnswers() { return correctAnswers; }
    public double getScore() { return score; }
    public boolean isPassed() { return passed; }

    @Override
    public String toString() {
        return String.format("Score: %.2f%% (%d/%d) - %s",
                score, correctAnswers, totalQuestions,
                passed ? "PASSED" : "FAILED");
    }
}

// Main System Class (Polymorphism and Composition)
class StudentManagementSystem {
    private List<Course> courses;
    private List<Student> students;
    private Admin admin;
    private Scanner scanner;

    public StudentManagementSystem() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        scanner = new Scanner(System.in);

        // Initialize admin
        admin = new Admin("System Admin", "admin@school.com", 30, "ADMIN001");

        // Add some default courses
        initializeDefaultCourses();
    }

    private void initializeDefaultCourses() {
        Course java = new Course("CS001", "Java Programming");
        java.addSubject(new Subject("SUB001", "Java"));
        java.addSubject(new Subject("SUB002", "OOP Concepts"));

        Course python = new Course("CS002", "Python Programming");
        python.addSubject(new Subject("SUB003", "Python"));
        python.addSubject(new Subject("SUB004", "Data Structures"));

        Course webDev = new Course("CS003", "Web Development");
        webDev.addSubject(new Subject("SUB005", "HTML/CSS"));
        webDev.addSubject(new Subject("SUB006", "JavaScript"));

        courses.add(java);
        courses.add(python);
        courses.add(webDev);
    }

    public void run() {
        System.out.println("=== WELCOME TO STUDENT MANAGEMENT SYSTEM ===");

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Registration");
            System.out.println("3. Student Login");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    studentRegistration();
                    break;
                case 3:
                    studentLogin();
                    break;
                case 4:
                    System.out.println("Thank you for using Student Management System!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void adminLogin() {
        System.out.print("Enter Admin ID: ");
        String adminId = scanner.nextLine();

        if (adminId.equals(admin.getAdminId())) {
            System.out.println("Admin login successful!");
            adminMenu();
        } else {
            System.out.println("Invalid Admin ID!");
        }
    }

    private void adminMenu() {
        while (true) {
            admin.displayMenu();
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    addSubjectToCourse();
                    break;
                case 3:
                    viewAllCourses();
                    break;
                case 4:
                    viewAllStudents();
                    break;
                case 5:
                    viewStudentResults();
                    break;
                case 6:
                    System.out.println("Admin logged out successfully!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void addCourse() {
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        Course newCourse = new Course(courseId, courseName);
        courses.add(newCourse);
        System.out.println("Course added successfully!");
    }

    private void addSubjectToCourse() {
        viewAllCourses();
        System.out.print("Enter Course ID to add subject: ");
        String courseId = scanner.nextLine();

        Course course = findCourseById(courseId);
        if (course != null) {
            System.out.print("Enter Subject ID: ");
            String subjectId = scanner.nextLine();
            System.out.print("Enter Subject Name: ");
            String subjectName = scanner.nextLine();

            Subject newSubject = new Subject(subjectId, subjectName);
            course.addSubject(newSubject);
            System.out.println("Subject added successfully!");
        } else {
            System.out.println("Course not found!");
        }
    }

    private void viewAllCourses() {
        System.out.println("\n=== ALL COURSES ===");
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (Course course : courses) {
                System.out.println(course);
                System.out.println("Subjects:");
                for (Subject subject : course.getSubjects()) {
                    System.out.println("  - " + subject);
                }
                System.out.println();
            }
        }
    }

    private void viewAllStudents() {
        System.out.println("\n=== ALL REGISTERED STUDENTS ===");
        if (students.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            for (Student student : students) {
                System.out.println("Student ID: " + student.getStudentId());
                System.out.println("Name: " + student.getName());
                System.out.println("Email: " + student.getEmail());
                System.out.println("Age: " + student.getAge());
                System.out.println("Enrolled Course: " +
                        (student.getEnrolledCourse() != null ?
                                student.getEnrolledCourse().getCourseName() : "Not enrolled"));
                System.out.println("Selected Subjects: " + student.getSelectedSubjects().size());
                System.out.println("Exam Status: " +
                        (student.getExamResult() != null ? "Completed" : "Not taken"));
                System.out.println("-".repeat(50));
            }
        }
    }

    private void viewStudentResults() {
        System.out.println("\n=== STUDENT EXAM RESULTS ===");
        boolean hasResults = false;

        for (Student student : students) {
            if (student.getExamResult() != null) {
                hasResults = true;
                System.out.println("Student: " + student.getName() +
                        " (ID: " + student.getStudentId() + ")");
                System.out.println("Course: " + student.getEnrolledCourse().getCourseName());
                System.out.println("Result: " + student.getExamResult());
                System.out.println("-".repeat(50));
            }
        }

        if (!hasResults) {
            System.out.println("No exam results available.");
        }
    }

    private void studentRegistration() {
        System.out.println("\n=== STUDENT REGISTRATION ===");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String studentId = "STU" + String.format("%03d", students.size() + 1);
        Student newStudent = new Student(name, email, age, studentId);
        students.add(newStudent);

        System.out.println("Registration successful!");
        System.out.println("Your Student ID is: " + studentId);
    }

    private void studentLogin() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        Student student = findStudentById(studentId);
        if (student != null) {
            System.out.println("Student login successful! Welcome " + student.getName());
            studentMenu(student);
        } else {
            System.out.println("Invalid Student ID!");
        }
    }

    private void studentMenu(Student student) {
        while (true) {
            student.displayMenu();
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewAvailableCourses();
                    break;
                case 2:
                    selectCourse(student);
                    break;
                case 3:
                    chooseSubjects(student);
                    break;
                case 4:
                    takeExam(student);
                    break;
                case 5:
                    viewMyResults(student);
                    break;
                case 6:
                    System.out.println("Student logged out successfully!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void viewAvailableCourses() {
        viewAllCourses();
    }

    private void selectCourse(Student student) {
        viewAllCourses();
        System.out.print("Enter Course ID to select: ");
        String courseId = scanner.nextLine();

        Course course = findCourseById(courseId);
        if (course != null) {
            student.setEnrolledCourse(course);
            System.out.println("Course selected successfully: " + course.getCourseName());
        } else {
            System.out.println("Course not found!");
        }
    }

    private void chooseSubjects(Student student) {
        if (student.getEnrolledCourse() == null) {
            System.out.println("Please select a course first!");
            return;
        }

        Course course = student.getEnrolledCourse();
        System.out.println("\nAvailable subjects in " + course.getCourseName() + ":");

        List<Subject> availableSubjects = course.getSubjects();
        for (int i = 0; i < availableSubjects.size(); i++) {
            System.out.println((i + 1) + ". " + availableSubjects.get(i).getSubjectName());
        }

        System.out.print("Enter subject numbers to select (comma-separated): ");
        String input = scanner.nextLine();
        String[] subjectIndices = input.split(",");

        student.getSelectedSubjects().clear(); // Clear previous selections

        for (String indexStr : subjectIndices) {
            try {
                int index = Integer.parseInt(indexStr.trim()) - 1;
                if (index >= 0 && index < availableSubjects.size()) {
                    student.addSelectedSubject(availableSubjects.get(index));
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + indexStr);
            }
        }

        System.out.println("Selected " + student.getSelectedSubjects().size() + " subjects.");
    }

    private void takeExam(Student student) {
        if (student.getSelectedSubjects().isEmpty()) {
            System.out.println("Please select subjects first!");
            return;
        }

        System.out.println("\n=== STARTING EXAM ===");
        System.out.println("Total subjects: " + student.getSelectedSubjects().size());

        int totalQuestions = 0;
        int correctAnswers = 0;

        for (Subject subject : student.getSelectedSubjects()) {
            System.out.println("\n--- " + subject.getSubjectName() + " ---");
            List<Question> questions = subject.getQuestions();

            for (Question question : questions) {
                totalQuestions++;
                System.out.println("\nQ" + totalQuestions + ": " + question.getQuestionText());
                String[] options = question.getOptions();

                for (int i = 0; i < options.length; i++) {
                    System.out.println((i + 1) + ". " + options[i]);
                }

                System.out.print("Your answer (1-" + options.length + "): ");
                int answer = scanner.nextInt() - 1;
                scanner.nextLine(); // consume newline

                if (answer == question.getCorrectAnswerIndex()) {
                    correctAnswers++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("Wrong! Correct answer: " +
                            options[question.getCorrectAnswerIndex()]);
                }
            }
        }

        ExamResult result = new ExamResult(totalQuestions, correctAnswers);
        student.setExamResult(result);

        System.out.println("\n=== EXAM COMPLETED ===");
        System.out.println(result);
    }

    private void viewMyResults(Student student) {
        if (student.getExamResult() == null) {
            System.out.println("You haven't taken the exam yet!");
        } else {
            System.out.println("\n=== YOUR EXAM RESULT ===");
            System.out.println("Student: " + student.getName());
            System.out.println("Course: " + student.getEnrolledCourse().getCourseName());
            System.out.println("Subjects: " + student.getSelectedSubjects().size());
            System.out.println("Result: " + student.getExamResult());
        }
    }

    // Helper methods
    private Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    private Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}

// Main class to run the application
public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.run();
    }
}