import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("Round " + (rounds + 1) + " - Guess the number between " + lowerBound + " and " + upperBound + ".");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (attempts == maxAttempts) {
                    System.out.println("You've run out of attempts. The correct number was " + targetNumber + ".");
                }
            }

            System.out.println("Your current score: " + score);
            rounds++;

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        } while (true);

        System.out.println("Thanks for playing! Your total score: " + score);
        scanner.close();
    }
}
