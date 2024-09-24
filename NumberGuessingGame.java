import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean keepPlaying = true;
        int roundsWon = 0;
        int totalAttempts = 0;

        while (keepPlaying) {
            int numberToGuess = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.println(" HEY Try to guess the number I'm thinking of between " + MIN_RANGE + " and " + MAX_RANGE + "!");
            
            while (attemptsLeft > 0) {
                System.out.print("Enter your Guessing number: ");
                int userGuess = scanner.nextInt();

                if (userGuess < MIN_RANGE || userGuess > MAX_RANGE) {
                    System.out.println("Guess must be between " + MIN_RANGE + " and " + MAX_RANGE + ".");
                    continue;
                }

                if (userGuess == numberToGuess) {
                    int attemptsUsed = MAX_ATTEMPTS - attemptsLeft + 1; // Including the successful attempt
                    System.out.println("You did it! Congratulations on guessing the number!");
                    guessedCorrectly = true;
                    roundsWon++;
                    totalAttempts += attemptsUsed;
                    System.out.println("You guessed it in " + attemptsUsed + " attempts.");
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attemptsLeft--;
                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("Sorry, you're out of attempts. The number was " + numberToGuess + ".");
                }
            }

            System.out.println("Would you like to play another round? (yes/no)");
            String response = scanner.next().trim().toLowerCase();
            keepPlaying = response.equals("yes");
        }

        double averageAttempts = roundsWon > 0 ? (double) totalAttempts / roundsWon : 0;
        System.out.println("Thanks for playing! You won " + roundsWon + " rounds.");
        System.out.println("Average number of attempts per round: " + averageAttempts);

        scanner.close();
    }
}