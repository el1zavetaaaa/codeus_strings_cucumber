package org.example.tuesday.warmup;

public class StringExercises {

    public static boolean isStringFromPool() {
        String literal = "hello";
        String created = new String("hello").intern();
        return literal == created;
    }

    public static String demonstrateImmutability(String original) {
        original.replace("x", "y")
                .substring(1, 2)
                .toUpperCase();
        return original;
    }

    public static int countCharacterOccurrences(String str, char c) {
        validateString(str);
        return (int) str.chars()
                .filter(ch -> ch == c)
                .count();
    }

    public static String reverseString(String str) {
        validateString(str);
        char[] chars = str.toCharArray();
        StringBuilder reversed = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed.append(chars[i]);
        }
        return reversed.toString();
    }

    public static boolean isPalindrome(String str) {
        validateString(str);
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    private static void validateString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }
    }
}
