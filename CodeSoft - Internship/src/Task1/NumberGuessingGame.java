/*
 * This program implements a Number Guessing Game where the user has to guess a randomly generated number
 * within a specified range. The user has a limited number of attempts to guess the number, and their score
 * is calculated based on the number of correct guesses. The program also allows the user to play multiple rounds.
 *
 * Author: Maswanganyi Successfull
 */

package Task1;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5; // Number of attempts allowed per game
        int score = 0; // Initialize user's score

        System.out.println("Welcome to the Legendary Number Guessing Game!");

        boolean playAgain = true; // Flag to control game loop
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange; // Generate random number
            int attempts = 0; // Initialize attempts counter for each round
            boolean guessedCorrectly = false; // Flag to track if the number was guessed correctly

            System.out.println("\nI have selected a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + attemptsLimit + " attempts to guess it.");

            while (attempts < attemptsLimit) {
                System.out.print("\nEnter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++; // Increment attempts counter

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts!");
                    score++; // Increment user's score for a correct guess
                    guessedCorrectly = true; // Set guessedCorrectly flag to true
                    break; // Exit the loop since the number is guessed correctly
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
            }

            System.out.println("\nYour current score: " + score);
            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();

            if (!playAgainResponse.equals("yes")) {
                playAgain = false; // Exit the game loop if user chooses not to play again
            }
        }

        System.out.println("Thanks for playing the Legendary Number Guessing Game!");
        scanner.close(); // Close scanner to prevent resource leak
    }
}
