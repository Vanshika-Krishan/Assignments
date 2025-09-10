import java.util.Scanner;

// Student class
class Student {
    String rollNo, name, course, grade;
    double marks;

    // Input student details
    public void inputStudent(Scanner sc) {
        System.out.print("Enter Roll Number: ");
        rollNo = sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Course: ");
        course = sc.nextLine();
        System.out.print("Enter Marks: ");
        marks = sc.nextDouble();
        sc.nextLine(); // Consume newline
        calculateGrade();
    }

    // Calculate grade based on marks
    private void calculateGrade() {
        if (marks >= 90) grade = "A+";
        else if (marks >= 80) grade = "A";
        else if (marks >= 70) grade = "B";
        else if (marks >= 60) grade = "C";
        else if (marks >= 50) grade = "D";
        else grade = "F";
    }

    // Display student details
    public void displayStudent() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("-----------------------------------");
    }
}

// StudentManagementSystem class
class StudentManagementSystem {
    Student[] students;
    int studentCount = 0;

    // Initialize system with a specific number of students
    public void initializeSystem(int size) {
        students = new Student[size];
    }

    // Add a new student
    public void addStudent(Scanner sc) {
        if (studentCount < students.length) {
            Student s = new Student();
            s.inputStudent(sc);
            students[studentCount++] = s;
            System.out.println("Student added successfully!\n");
        } else {
            System.out.println("Cannot add more students. Array is full!");
        }
    }

    // Display all students
    public void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No student records available!\n");
        } else {
            for (int i = 0; i < studentCount; i++) {
                students[i].displayStudent();
            }
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        // Initialize system
        System.out.print("Enter the maximum number of students: ");
        int size = sc.nextInt();
        sc.nextLine(); // Consume newline
        sms.initializeSystem(size);

        int choice;
        do {
            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1: sms.addStudent(sc); break;
                case 2: sms.displayAllStudents(); break;
                case 3: System.out.println("Exiting the program. Goodbye!"); break;
                default: System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
