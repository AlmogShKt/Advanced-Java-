package Mmn11.q1;

import java.util.*;

public class HitGame {
    private final int TOTAL_DIGITS = 4;
    private Character[] secretNumber;
    private String targetNumberString;

    private int previousGuesses;

    public HitGame() {
        initGame();
    }

    public void resetGame() {
        initGame();
    }

    public void printTotalGuesses() {
        System.out.println("You guessed so far: " + previousGuesses);
    }

    public void printCorrectGuess() {
        System.out.println("Your current correct guess is:");
        for (char digit : secretNumber) {
            System.out.print(digit);
        }
        System.out.println();
    }

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

        printHitCount(hitCount);
        printBlowsCount(blowsCount);

        if (hitCount == 4) {
            return true;
        }

        previousGuesses++;
        return false;
    }

    public void printHitCount(int hits) {
        System.out.printf("Hits: %d%n", hits);
    }

    public void printBlowsCount(int blows) {
        System.out.printf("Blows %d%n", blows);
    }


    public void win() {
        System.out.println("Congratulations! You've guessed the correct number!");
        System.out.println("The correct number was: " + targetNumberString);
        System.out.println("You made " + (previousGuesses + 1) + " guesses.");
    }

    private void initGame() {
        secretNumber = new Character[TOTAL_DIGITS];
        Arrays.fill(secretNumber, '-');
        previousGuesses = 0;
        generateUniqueFourDigitNumber();

        System.out.println("ALL SET - Lets play!");
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