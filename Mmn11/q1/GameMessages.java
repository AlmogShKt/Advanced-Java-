/* By Almog Shtaigmann
 * Mmn 11
 */
package Mmn11.q1;

public class GameMessages {
    public static final String PLAY_AGAIN_MSG = "Do you want to play again? (yes/no):";
    public static final String WINDOW_TITLE = "Hit Game";
    public static final String INVALID_INPUT_PLAY_AGAIN = "Invalid input. Please type 'yes' or 'no'.";
    public static final String INVALID_INPUT_GUESS_1 = "Invalid input. Please enter exactly 4 digits.";
    public static final String INVALID_INPUT_GUESS_2 = "Invalid input. Please ensure all digits are unique.";
    public static final String ENTER_GUESS = "Enter your guess (4 unique digits):";
    public static final String YES = "yes";
    public static final String NO = "no";
    public static final String CONGRATULATIONS = "Congratulations! You've guessed the correct number!";
    public static final String CORRECT_NUMBER = "The correct number was: ";
    public static final String GUESSES_MADE = "You made %d guesses.";
    public static final String CURRENT_CORRECT_GUESS_MSG = "\nYour current correct guess is: ";
    public static final String HITS_AND_BLOWS_MSG = "Hits: %d\nBlows: %d%s";

    private GameMessages() {
    }
}