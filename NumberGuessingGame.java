import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int attempts = 5;
        int guess;

        System.out.println("Guess a number between " + lowerBound + " and " + upperBound);
        System.out.println("You have " + attempts + " attempts.");

        while (attempts > 0) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts--;

            if (guess == numberToGuess) {
                System.out.println("🎉 Congratulations! You guessed the correct number.");
                break;
            } else if (guess > numberToGuess) {
                System.out.println("Too High! Attempts left: " + attempts);
            } else {
                System.out.println("Too Low! Attempts left: " + attempts);
            }

            if (attempts == 0) {
                System.out.println("❌ Game Over! The correct number was " + numberToGuess);
            }
        }

        scanner.close();
    }
}