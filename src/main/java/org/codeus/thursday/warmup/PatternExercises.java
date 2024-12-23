package org.codeus.thursday.warmup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExercises {
    private static final Pattern DIGIT_PATTERN = Pattern.compile("\\d");
    private static final Pattern CAPITALIZED_WORD_PATTERN = Pattern.compile("\\b[A-Z][a-z]*\\b");
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]{2,3}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Finds all digits in a given string and returns them concatenated.
     *
     * @param input Input string
     * @return Concatenated digits or an empty string if none found
     * @throws IllegalArgumentException if input is null
     */
    public static String extractDigits(String input) {
        validateInput(input, "Input cannot be null");
        return findMatches(input, DIGIT_PATTERN);
    }

    /**
     * Validates whether a string is a valid email.
     *
     * @param email Input email string
     * @return true if valid email, false otherwise
     * @throws IllegalArgumentException if email is null
     */
    public static boolean isValidEmail(String email) {
        validateInput(email, "Email cannot be null");
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Finds all words that start with a capital letter in the input string.
     *
     * @param input Input string
     * @return Concatenated capitalized words or an empty string if none found
     * @throws IllegalArgumentException if input is null
     */
    public static String findCapitalizedWords(String input) {
        validateInput(input, "Input cannot be null");
        return findMatches(input, CAPITALIZED_WORD_PATTERN, " ");
    }

    /**
     * Validates the input string.
     *
     * @param input   The input string
     * @param message The error message to throw if input is null
     */
    private static void validateInput(String input, String message) {
        if (input == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Finds all matches in the input string for a given pattern and concatenates them without a separator.
     *
     * @param input   The input string
     * @param pattern The pattern to match
     * @return Concatenated matches or an empty string if none found
     */
    private static String findMatches(String input, Pattern pattern) {
        return findMatches(input, pattern, "");
    }

    /**
     * Finds all matches in the input string for a given pattern and concatenates them with a separator.
     *
     * @param input     The input string
     * @param pattern   The pattern to match
     * @param separator The separator to use between matches
     * @return Concatenated matches or an empty string if none found
     */
    private static String findMatches(String input, Pattern pattern, String separator) {
        Matcher matcher = pattern.matcher(input);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            if (!result.isEmpty()) {
                result.append(separator);
            }
            result.append(matcher.group());
        }
        return result.toString();
    }
}
