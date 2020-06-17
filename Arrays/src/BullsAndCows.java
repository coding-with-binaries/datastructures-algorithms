/*
 * You are playing the following Bulls and Cows game with your friend:
 * You write down a number and ask your friend to guess what the number is.
 * Each time your friend makes a guess, you provide a hint that indicates how many
 * digits in said guess match your secret number exactly in both digit and position (called "bulls")
 * and how many digits match the secret number but locate in the wrong position (called "cows").
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 *
 * Write a function to return a hint according to the secret number and friend's guess,
 * use A to indicate the bulls and B to indicate the cows.
 * Please note that both secret number and friend's guess may contain duplicate digits.
 * */

import java.util.Scanner;

public class BullsAndCows {
    private static String getHint(String secret, String guess) {
        int[] numbers = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                numbers[secret.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            char curGuess = guess.charAt(i);
            if (secret.charAt(i) != curGuess && numbers[curGuess - '0'] > 0) {
                cows++;
                numbers[curGuess - '0']--;
            }
        }

        return String.format("%sA%sB", bulls, cows);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter secret string");
        String secret = scanner.next();
        System.out.println("Enter guessed string");
        String guess = scanner.next();

        String hint = getHint(secret, guess);
        System.out.println("Hint: " + hint);
    }
}
