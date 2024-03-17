/*
 * This program calculates the total marks, average percentage, and grade based on marks obtained
 * in multiple subjects entered by the user. It then displays these results to the user.
 *
 * Author: Maswanganyi Successfull
 */

package Task2;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to input the number of subjects
        System.out.println("Enter the number of subjects:");
        int numSubjects = scanner.nextInt();

        int totalMarks = 0; // Variable to store total marks obtained by the student

        // Loop through each subject to input marks obtained and calculate total marks
        for (int i = 1; i <= numSubjects; i++) {
            System.out.println("Enter marks obtained in subject " + i + ":");
            int marks = scanner.nextInt();
            totalMarks += marks; // Accumulate marks for total calculation
        }

        double averagePercentage = (double) totalMarks / numSubjects; // Calculate average percentage

        // Display total marks and average percentage to the user
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");

        char grade = calculateGrade(averagePercentage); // Calculate grade based on average percentage
        System.out.println("Grade: " + grade); // Display the calculated grade

        scanner.close(); // Close scanner to prevent resource leak
    }

    // Method to calculate grade based on average percentage
    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
