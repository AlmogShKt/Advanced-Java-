/* By Almog Shtaigmann
 * Mmn 11
 */

package Mmn11.q1;

import javax.swing.*;
import java.util.*;

// Class for manage the Hit Game
public class HitGame {
    private final int TOTAL_DIGITS = 4;
    private Character[] secretNumber; // Stores the correct number as a list of chars
    private String targetNumberString; // Stores the correct number as a String
    private int previousGuesses; // Counts the number of guesses made so fay by the user

    public HitGame() {
        initGame();
    }

    public void resetGame() {
        initGame();
    }

    // Constructs a string representation of the current correct guess
    public String getCorrectGuessString() {
        StringBuilder msg = new StringBuilder(GameMessages.CURRENT_CORRECT_GUESS_MSG);
        for (char digit : secretNumber) {
            msg.append(digit);
        }
        return msg.toString();
    }

    // Processes a guess and returns true if it's correct
    public boolean guessNumber(String number) {
        int hitCount = 0;
        int blowsCount = 0;
        for (int i = 0; i < TOTAL_DIGITS; i++) {
            if (targetNumberString.charAt(i) == number.charAt(i)) {
                hitCount++;
                secretNumber[i] = targetNumberString.charAt(i);
            } else if (targetNumberString.contains(String.valueOf(number.charAt(i)))) {
                blowsCount++;
            }
        }

        if (hitCount == 4) {
            return true;
        }

        printHitAndBlowsCount(hitCount, blowsCount);

        previousGuesses++;
        return false;
    }

    // Displays the number of hits and blows for the current guess
    public void printHitAndBlowsCount(int hits, int blows) {
        String msg = String.format(GameMessages.HITS_AND_BLOWS_MSG,
                hits, blows, getCorrectGuessString());
        JOptionPane.showMessageDialog(null, msg, GameMessages.WINDOW_TITLE, JOptionPane.INFORMATION_MESSAGE);
    }

    // Displays the winning message
    public void win() {
        String message = String.format("%s\n%s%s\n%s",
                GameMessages.CONGRATULATIONS,
                GameMessages.CORRECT_NUMBER, targetNumberString,
                String.format(GameMessages.GUESSES_MADE, previousGuesses + 1));

        JOptionPane.showMessageDialog(null, message, GameMessages.WINDOW_TITLE, JOptionPane.INFORMATION_MESSAGE);
    }

    // Initializes or resets the game state
    private void initGame() {
        secretNumber = new Character[TOTAL_DIGITS];
        Arrays.fill(secretNumber, '-');
        previousGuesses = 0;
        generateUniqueFourDigitNumber();

        System.out.println("for cheaters.. see the logs :) ->" + targetNumberString);
    }

    /**
     * Generates a unique number based on the following rules:
     * - The number has a total of TOTAL_DIGITS (default is 4).
     * - All digits in the number are unique.
     * - The first digit cannot be 0.
     */
    private void generateUniqueFourDigitNumber() {
        List<Integer> digits = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(digits, new Random());

        if (digits.get(0) == 0) {
            Collections.swap(digits, 0, digits.indexOf(Collections.min(digits.subList(1, 10))));
        }
        targetNumberString = "";
        for (int i = 0; i < TOTAL_DIGITS; i++) {
            targetNumberString += digits.get(i);
        }
    }
}