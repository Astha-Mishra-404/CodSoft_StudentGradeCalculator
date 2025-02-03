import java.util.Scanner;

public class StudentGradeCalculator {

    // Function to calculate total marks
    public static int calculateTotalMarks(int[] marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return totalMarks;
    }

    // Function to calculate average percentage
    public static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    // Function to determine grade based on average percentage
    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B+";
        } else if (averagePercentage >= 60) {
            return "B";
        } else if (averagePercentage >= 50) {
            return "C";
        } else if (averagePercentage >= 40) {
            return "D";
        } else {
            return "F"; // Fail grade
        }
    }

    // Function to validate input
    public static int getValidMarks(Scanner scanner, int subjectNumber) {
        int marks;
        while (true) {
            System.out.print("Enter marks for subject " + subjectNumber + " (0-100): ");
            marks = scanner.nextInt();
            if (marks >= 0 && marks <= 100) {
                break;
            } else {
                System.out.println("Invalid input. Please enter marks between 0 and 100.");
            }
        }
        return marks;
    }

    // Function to display student results
    public static void displayResults(int totalMarks, double averagePercentage, String grade, int numSubjects) {
        System.out.println("\n--- Student Grade Report ---");
        System.out.println("Total Marks: " + totalMarks + "/" + (numSubjects * 100));
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numSubjects = 5;

        // Main menu loop
        while (true) {
            System.out.println("\n--- Student Grade Calculator ---");
            System.out.println("1. Enter marks for " + numSubjects + " subjects");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            if (option == 1) {
                // Initialize array to hold the marks for each subject
                int[] marks = new int[numSubjects];

                // Input marks for each subject
                System.out.println("Enter marks for " + numSubjects + " subjects (out of 100):");
                int totalMarks = 0;
                for (int i = 0; i < numSubjects; i++) {
                    marks[i] = getValidMarks(scanner, i + 1);
                    totalMarks += marks[i];
                }

                // Calculate Average Percentage
                double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

                // Determine Grade
                String grade = calculateGrade(averagePercentage);

                // Display results
                displayResults(totalMarks, averagePercentage, grade, numSubjects);
            } else if (option == 2) {
                System.out.println("Exiting the program...");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}