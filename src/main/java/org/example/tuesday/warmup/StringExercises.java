package org.example.tuesday.warmup;

public class StringExercises {
    /**
     * Determines whether a string created using `new String()` and then interned is from the string pool.
     *
     * @return true if the literal and the interned string are the same object; false otherwise
     */
    public static boolean isStringFromPool() {
        // TODO:
        // 1. Declare a string literal, e.g., `String literal = "hello";`.
        // 2. Create another string using `new String("hello")`.
        // 3. Use the `intern()` method to move the created string to the string pool.
        // 4. Compare the literal and the interned string using `==` (reference equality).
        // 5. Return the result of the comparison.
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Demonstrates that strings are immutable by attempting multiple operations and returning the original string.
     *
     * @param original The original string
     * @return The unchanged original string
     */
    public static String demonstrateImmutability(String original) {
        // TODO:
        // 1. Perform a series of string operations like `replace()`, `substring()`, `toUpperCase()` on `original`.
        // 2. Return `original` to show that none of the operations modified the original string.
        //    Instead, they returned new string objects.
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Counts the number of occurrences of a specific character in a string.
     *
     * @param str The input string
     * @param c   The character to count
     * @return The count of occurrences
     */
    public static int countCharacterOccurrences(String str, char c) {
        // TODO:
        // 1. Validate the input string by checking if it is null or empty (throw an exception if invalid).
        // 2. Use `str.chars()` to get a stream of characters from the string.
        // 3. Use `filter()` to include only characters equal to `c`.
        // 4. Use `count()` to count the filtered characters.
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Reverses the input string.
     *
     * @param str The input string
     * @return The reversed string
     */
    public static String reverseString(String str) {
        // TODO:
        // 1. Validate the input string by checking if it is null or empty (throw an exception if invalid).
        // 2. Convert the string to a character array using `str.toCharArray()`.
        // 3. Create an empty `StringBuilder` to store the reversed string.
        // 4. Loop through the character array from the end to the beginning.
        // 5. Append each character to the `StringBuilder`.
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Checks if a string is a palindrome (reads the same backward as forward).
     *
     * @param str The input string
     * @return true if the string is a palindrome; false otherwise
     */
    public static boolean isPalindrome(String str) {
        // TODO:
        // 1. Validate the input string by checking if it is null or empty (throw an exception if invalid).
        // 2. Use two pointers:
        //    a. `left` starting from the beginning of the string.
        //    b. `right` starting from the end of the string.
        // 3. Loop until the `left` pointer is greater than or equal to the `right` pointer.
        // 4. Compare the characters at the `left` and `right` positions.
        //    a. If they are not equal, return `false` (not a palindrome).
        // 5. If the loop completes without mismatches, return `true`.
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Validates if the input string is not null or empty.
     *
     * @param str The input string
     * @throws IllegalArgumentException if the input string is null or empty
     */
    private static void validateString(String str) {
        // TODO:
        // 1. Check if `str` is null or if its length is 0.
        // 2. If either condition is true, throw an `IllegalArgumentException` with a meaningful error message.
        throw new UnsupportedOperationException("Method not implemented");
    }
}
