package org.example.thursday.warmup;

import java.util.regex.Pattern;

public class PatternExercises {

    private static final Pattern DIGIT_PATTERN = Pattern.compile("");
    private static final Pattern CAPITALIZED_WORD_PATTERN = Pattern.compile("");
    private static final String EMAIL_REGEX = "";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Finds all digits in a given string and returns them concatenated.
     *
     * @param input Input string
     * @return Concatenated digits or an empty string if none found
     * @throws IllegalArgumentException if input is null
     */
    public static String extractDigits(String input) {
        // TODO:
        // 1. Validate the input string to ensure it is not null.
        //    - If null, throw an IllegalArgumentException with the message "Input cannot be null".
        // 2. Use the DIGIT_PATTERN regex to find all digits in the string.
        // 3. Create a StringBuilder to store the matched digits.
        // 4. Use a Matcher to find each digit match in the input string.
        //    - Append each match to the StringBuilder.
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Validates whether a string is a valid email.
     *
     * @param email Input email string
     * @return true if valid email, false otherwise
     * @throws IllegalArgumentException if email is null
     */
    public static boolean isValidEmail(String email) {
        // TODO:
        // 1. Validate the input string to ensure it is not null.
        //    - If null, throw an IllegalArgumentException with the message "Email cannot be null".
        // 2. Use the EMAIL_PATTERN regex to validate the email format.
        //    - Use Pattern.matcher(email).matches() to check if the email matches the regex.
        // 3. Return true if the email matches the regex; otherwise, return false.
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Finds all words that start with a capital letter in the input string.
     *
     * @param input Input string
     * @return Concatenated capitalized words or an empty string if none found
     * @throws IllegalArgumentException if input is null
     */
    public static String findCapitalizedWords(String input) {
        // TODO:
        // 1. Validate the input string to ensure it is not null.
        //    - If null, throw an IllegalArgumentException with the message "Input cannot be null".
        // 2. Use the CAPITALIZED_WORD_PATTERN regex to find all capitalized words in the string.
        // 3. Create a StringBuilder to store the matched words.
        // 4. Use a Matcher to find each match in the input string.
        //    - Append each match to the StringBuilder, separated by a space.
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Validates the input string.
     *
     * @param input   The input string
     * @param message The error message to throw if input is null
     */
    private static void validateInput(String input, String message) {
        // TODO:
        // 1. Check if the input string is null.
        //    - If null, throw an IllegalArgumentException with the provided error message.
        throw new UnsupportedOperationException("Method not implemented");
    }
}
