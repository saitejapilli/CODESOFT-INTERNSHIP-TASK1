import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            int maxAttempts = 10;
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have picked a number between 1 and 100. Try to guess it!");

            while (numberOfAttempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.println("Attempt " + (numberOfAttempts + 1) + " of " + maxAttempts + ":");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;

                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    totalScore += (maxAttempts - numberOfAttempts + 1); // Score is based on remaining attempts
                    System.out.println("Congratulations! You guessed the number correctly.");
                    System.out.println("Your score for this round: " + (maxAttempts - numberOfAttempts + 1));
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + numberToGuess);
            }

            System.out.print
            ("Your total score so far: " + totalScore);
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
