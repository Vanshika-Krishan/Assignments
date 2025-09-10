import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of students
        System.out.print("Enter the number of students: ");
        int size = sc.nextInt();
        sc.nextLine();  // Consume newline

        // Arrays to store student details
        String[] rollNo = new String[size];
        String[] name = new String[size];
        String[] course = new String[size];
        double[] marks = new double[size];
        String[] grade = new String[size];

        int studentCount = 0;

        // Menu-driven system
        int choice;
        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    if (studentCount < size) {
                        // Input student details
                        System.out.print("Enter Roll Number: ");
                        rollNo[studentCount] = sc.nextLine();
                        System.out.print("Enter Name: ");
                        name[studentCount] = sc.nextLine();
                        System.out.print("Enter Course: ");
                        course[studentCount] = sc.nextLine();
                        System.out.print("Enter Marks: ");
                        marks[studentCount] = sc.nextDouble();
                        sc.nextLine();  // Consume newline

                        // Calculate grade
                        if (marks[studentCount] >= 90) grade[studentCount] = "A+";
                        else if (marks[studentCount] >= 80) grade[studentCount] = "A";
                        else if (marks[studentCount] >= 70) grade[studentCount] = "B";
                        else if (marks[studentCount] >= 60) grade[studentCount] = "C";
                        else if (marks[studentCount] >= 50) grade[studentCount] = "D";
                        else grade[studentCount] = "F";

                        studentCount++;
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Cannot add more students. Array is full!");
                    }
                    break;
                case 2:
                    if (studentCount == 0) {
                        System.out.println("No student records available!");
                    } else {
                        // Display all students
                        for (int i = 0; i < studentCount; i++) {
                            System.out.println("\nStudent " + (i + 1) + ":");
                            System.out.println("Roll No: " + rollNo[i]);
                            System.out.println("Name: " + name[i]);
                            System.out.println("Course: " + course[i]);
                            System.out.println("Marks: " + marks[i]);
                            System.out.println("Grade: " + grade[i]);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
