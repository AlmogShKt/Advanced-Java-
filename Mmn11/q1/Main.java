package Mmn11.q1;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main {
    private static boolean askForPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.println("Do you want to play again? (yes/no): ");
            input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please type 'yes' or 'no'.");
            }
        }
    }

    private static String getUserGuess() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        int maxIncorrectGuess = 12;

        while (maxIncorrectGuess > 0) {
            System.out.println("Enter your guess (4 unique digits):");
            input = scanner.nextLine();

            if (input.matches("\\d{4}") && areDigitsUnique(input)) {
                return input;
            } else {
                if (!input.matches("\\d{4}")) {
                    System.out.println("Invalid input. Please enter exactly 4 digits.");
                } else {
                    System.out.println("Invalid input. Please ensure all digits are unique.");
                }
                maxIncorrectGuess -= 1;
            }
        }
        return "";
    }

    // Helper method to check if all digits in the input string are unique
    private static boolean areDigitsUnique(String input) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char digit : input.toCharArray()) {
            if (!uniqueDigits.add(digit)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HitGame hitGame = new HitGame();
        boolean gameOver = false;
        String userGuess = "";

        while (!gameOver) {
            userGuess = getUserGuess();

            if (hitGame.guessNumber(userGuess)) {
                hitGame.win();
                if (askForPlayAgain()) {
                    hitGame.resetGame();
                } else {
                    gameOver = true;
                }
            } else {
                hitGame.printTotalGuesses();
                hitGame.printCorrectGuess();
            }
        }
    }
}