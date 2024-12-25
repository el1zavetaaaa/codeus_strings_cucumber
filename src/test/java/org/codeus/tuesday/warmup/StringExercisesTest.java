package org.codeus.tuesday.warmup;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


/**
 * {@link StringExercisesTest} validates the correctness of methods in {@link StringExercises}.
 * If a method is not implemented, the test will fail with a clear message.
 */
public class StringExercisesTest {

    @DisplayName("Verify string literals and interned strings point to the same object (string pool behavior)")
    @Test
    public void testIsStringFromPool() {
        assertTrue(StringExercises.isStringFromPool(),
                "String literals and interned strings should refer to the same object");
    }

    @DisplayName("Verify demonstrateImmutability preserves original string after various operations")
    @Test
    public void testDemonstrateImmutability() {
        String original = "immutable";
        String result = StringExercises.demonstrateImmutability(original);
        assertEquals(original, result, "The original string should remain unchanged");

        String modifiedResult = result.replace("a", "o").toUpperCase();
        assertNotEquals(original, modifiedResult, "String operations should not modify the original string");

        assertEquals(original, result, "The original string should still be unchanged");
    }

    @DisplayName("countCharacterOccurrences should throw IllegalArgumentException for null or empty input")
    @ParameterizedTest
    @NullAndEmptySource
    public void testCountCharacterOccurrencesInvalidInputs(String input) {
        assertThrows(IllegalArgumentException.class, () -> StringExercises.countCharacterOccurrences(input, 'a'), "Expected countCharacterOccurrences to throw IllegalArgumentException for input: " + input);
    }

    @DisplayName("Verify countCharacterOccurrences counts correctly for various strings")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideCountCharacterOccurrencesParameters")
    void testCountCharacterOccurrences(String input, char character, int expectedCount) {
        assertEquals(expectedCount, StringExercises.countCharacterOccurrences(input, character),
                "Incorrect count for input: " + input + " and character: " + character);
    }

    private static Stream<Arguments> provideCountCharacterOccurrencesParameters() {
        return Stream.of(
                Arguments.of(Named.named("'banana', 'a' => 3", "banana"), 'a', 3),
                Arguments.of(Named.named("'apple', 'z' => 0", "apple"), 'z', 0),
                Arguments.of(Named.named("'hello', 'o' => 1", "hello"), 'o', 1),
                Arguments.of(Named.named("'aaaa' , 'a' => 4", "aaaa"), 'a', 4),
                Arguments.of(Named.named("'bubble', 'b' => 3", "bubble"), 'b', 3)
        );
    }

    @DisplayName("reverseString should throw IllegalArgumentException for null or empty input")
    @ParameterizedTest
    @NullAndEmptySource
    public void testReverseStringInvalidInputs(String input) {
        assertThrows(IllegalArgumentException.class, () -> StringExercises.reverseString(input),
                "Expected reverseString to throw IllegalArgumentException for input: " + input);
    }

    @DisplayName("Verify reverseString reverses correctly for various strings")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideReverseStringParameters")
    void testReverseString(String input, String expectedReversed) {
        assertEquals(StringExercises.reverseString(input), expectedReversed, "Incorrect reversed string for input: " + input);
    }

    private static Stream<Arguments> provideReverseStringParameters() {
        return Stream.of(
                Arguments.of(Named.named("'hello' => 'olleh'", "hello"), "olleh"),
                Arguments.of(Named.named("'Java' => 'avaJ'", "Java"), "avaJ"),
                Arguments.of(Named.named("'racecar' => 'racecar'", "racecar"), "racecar"),
                Arguments.of(Named.named("'12321' => '12321'", "12321"), "12321"),
                Arguments.of(Named.named("'Hello, World!' => '!dlroW ,olleH'", "Hello, World!"), "!dlroW ,olleH")
        );
    }

    @DisplayName("isPalindrome should throw IllegalArgumentException for null or empty input")
    @ParameterizedTest
    @NullAndEmptySource
    public void testIsPalindromeInvalidInputs(String input) {
        assertThrows(IllegalArgumentException.class, () -> StringExercises.isPalindrome(input),
                "Expected isPalindrome to throw IllegalArgumentException for input: " + input);
    }

    @DisplayName("Verify isPalindrome detects palindromes correctly")
    @ParameterizedTest(name = "{0}")
    @MethodSource("providePalindromeParameters")
    public void testIsPalindromeTrue(String input) {
        assertTrue(StringExercises.isPalindrome(input),
                "Expected the string to be a palindrome: " + input);
    }

    private static Stream<Arguments> providePalindromeParameters() {
        return Stream.of(
                Arguments.of(Named.named("'madam' => true", "madam")),
                Arguments.of(Named.named("'racecar' => true", "racecar")),
                Arguments.of(Named.named("'12321' => true", "12321")),
                Arguments.of(Named.named("'abba' => true", "abba")),
                Arguments.of(Named.named("'a' => true", "a"))
        );
    }

    @DisplayName("Verify isPalindrome detects non-palindromes correctly")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideNonPalindromeParameters")
    public void testIsPalindrome_False(String input) {
        assertFalse(StringExercises.isPalindrome(input),
                "Expected the string to not be a palindrome: " + input);
    }

    private static Stream<Arguments> provideNonPalindromeParameters() {
        return Stream.of(
                Arguments.of(Named.named("'hello' => false", "hello")),
                Arguments.of(Named.named("'java' => false", "java")),
                Arguments.of(Named.named("'world' => false", "world")),
                Arguments.of(Named.named("'12345' => false", "12345")),
                Arguments.of(Named.named("'notapalindrome' => false", "notapalindrome"))
        );
    }


}