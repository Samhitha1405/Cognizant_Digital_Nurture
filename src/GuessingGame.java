import java.util.*;
public class GuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = new Random().nextInt(100) + 1;
        int guess = 0 , attempts = 0;
        System.out.println("Welcome to the Guessing Game!");
        do {
            System.out.print("Guess a number (1 - 100): ");
            guess = sc.nextInt();
            attempts++;
            if (guess < n) {
                System.out.println("Too low! Try again.");
            } else if (guess > n) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            }
        } while (guess != n);
        sc.close();
    }
}