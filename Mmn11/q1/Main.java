/* By Almog Shtaigmann
 * Mmn 11
 */
package Mmn11.q1;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import javax.swing.*;

public class Main {
    private static boolean askForPlayAgain() {
        String input = "";

        while (true) {
            input = JOptionPane.showInputDialog(null, GameMessages.PLAY_AGAIN_MSG, GameMessages.WINDOW_TITLE, JOptionPane.QUESTION_MESSAGE);

            if (input.equals(GameMessages.YES)) {
                return true;
            } else if (input.equals(GameMessages.NO)) {
                return false;
            } else {
                JOptionPane.showMessageDialog(null, GameMessages.INVALID_INPUT_PLAY_AGAIN, GameMessages.WINDOW_TITLE, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static String getUserGuess() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        int maxIncorrectGuess = 12;

        while (maxIncorrectGuess > 0) {

            input = JOptionPane.showInputDialog(null, GameMessages.ENTER_GUESS, GameMessages.WINDOW_TITLE, JOptionPane.QUESTION_MESSAGE);

            if (input.matches("\\d{4}") && areDigitsUnique(input)) {
                return input;
            } else {
                if (!input.matches("\\d{4}")) {
                    JOptionPane.showMessageDialog(null, GameMessages.INVALID_INPUT_GUESS_1, GameMessages.WINDOW_TITLE, JOptionPane.ERROR_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, GameMessages.INVALID_INPUT_GUESS_2, GameMessages.WINDOW_TITLE, JOptionPane.ERROR_MESSAGE);
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
            }
        }
    }
}