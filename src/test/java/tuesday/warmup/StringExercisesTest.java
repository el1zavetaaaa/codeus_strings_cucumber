package tuesday.warmup;

import org.example.tuesday.warmup.StringExercises;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * {@link StringExercisesTest} validates the correctness of methods in {@link StringExercises}.
 * If a method is not implemented, the test will fail with a clear message.
 */
public class StringExercisesTest {

    @DisplayName("Verify string literals and interned strings point to the same object (string pool behavior)")
    @Test
    public void testIsStringFromPool() {
        assertTrue("String literals and interned strings should refer to the same object",
                StringExercises.isStringFromPool());
    }

    @DisplayName("Verify demonstrateImmutability preserves original string after various operations")
    @Test
    public void testDemonstrateImmutability() {
        String original = "immutable";
        String result = StringExercises.demonstrateImmutability(original);
        assertEquals("The original string should remain unchanged", original, result);

        String modifiedResult = result.replace("a", "o").toUpperCase();
        assertNotEquals("String operations should not modify the original string", original, modifiedResult);

        assertEquals("The original string should still be unchanged", original, result);
    }

    @DisplayName("countCharacterOccurrences should throw IllegalArgumentException for null or empty input")
    @ParameterizedTest
    @NullAndEmptySource
    public void testCountCharacterOccurrencesInvalidInputs(String input) {
        assertThrows("Expected countCharacterOccurrences to throw IllegalArgumentException for input: " + input,
                IllegalArgumentException.class, () -> StringExercises.countCharacterOccurrences(input, 'a'));
    }

    @DisplayName("Verify countCharacterOccurrences counts correctly for various strings")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideCountCharacterOccurrencesParameters")
    void testCountCharacterOccurrences(String input, char character, int expectedCount) {
        assertEquals("Incorrect count for input: " + input + " and character: " + character,
                expectedCount, StringExercises.countCharacterOccurrences(input, character));
    }

    private static Stream<Arguments> provideCountCharacterOccurrencesParameters() {
        return Stream.of(
                Arguments.of(Named.named("Count 'a' in 'banana' -> 3", "banana"), 'a', 3),
                Arguments.of(Named.named("Count 'z' in 'apple' -> 0", "apple"), 'z', 0),
                Arguments.of(Named.named("Count 'o' in 'hello' -> 1", "hello"), 'o', 1),
                Arguments.of(Named.named("Count 'a' in 'aaaa' -> 4", "aaaa"), 'a', 4),
                Arguments.of(Named.named("Count 'b' in 'bubble' -> 3", "bubble"), 'b', 3)
        );
    }

    @DisplayName("reverseString should throw IllegalArgumentException for null or empty input")
    @ParameterizedTest
    @NullAndEmptySource
    public void testReverseStringInvalidInputs(String input) {
        assertThrows("Expected reverseString to throw IllegalArgumentException for input: " + input,
                IllegalArgumentException.class, () -> StringExercises.reverseString(input));
    }

    @DisplayName("Verify reverseString reverses correctly for various strings")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideReverseStringParameters")
    void testReverseString(String input, String expectedReversed) {
        assertEquals("Incorrect reversed string for input: " + input, expectedReversed, StringExercises.reverseString(input));
    }

    private static Stream<Arguments> provideReverseStringParameters() {
        return Stream.of(
                Arguments.of(Named.named("Reverse 'hello' -> 'olleh'", "hello"), "olleh"),
                Arguments.of(Named.named("Reverse 'Java' -> 'avaJ'", "Java"), "avaJ"),
                Arguments.of(Named.named("Reverse 'racecar' -> 'racecar'", "racecar"), "racecar"),
                Arguments.of(Named.named("Reverse '12321' -> '12321'", "12321"), "12321"),
                Arguments.of(Named.named("Reverse 'Hello, World!' -> '!dlroW ,olleH'", "Hello, World!"), "!dlroW ,olleH")
        );
    }

    @DisplayName("isPalindrome should throw IllegalArgumentException for null or empty input")
    @ParameterizedTest
    @NullAndEmptySource
    public void testIsPalindromeInvalidInputs(String input) {
        assertThrows("Expected isPalindrome to throw IllegalArgumentException for input: " + input,
                IllegalArgumentException.class, () -> StringExercises.isPalindrome(input));
    }

    @DisplayName("Verify isPalindrome detects palindromes correctly")
    @ParameterizedTest(name = "{0}")
    @MethodSource("providePalindromeParameters")
    public void testIsPalindromeTrue(String input) {
        assertTrue("Expected the string to be a palindrome: " + input, StringExercises.isPalindrome(input));
    }

    private static Stream<Arguments> providePalindromeParameters() {
        return Stream.of(
                Arguments.of(Named.named("Palindrome 'madam'", "madam")),
                Arguments.of(Named.named("Palindrome 'racecar'", "racecar")),
                Arguments.of(Named.named("Palindrome '12321'", "12321")),
                Arguments.of(Named.named("Palindrome 'abba'", "abba")),
                Arguments.of(Named.named("Palindrome 'a'", "a"))
        );
    }

    @DisplayName("Verify isPalindrome detects non-palindromes correctly")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideNonPalindromeParameters")
    public void testIsPalindrome_False(String input) {
        assertFalse("Expected the string to not be a palindrome: " + input, StringExercises.isPalindrome(input));
    }

    private static Stream<Arguments> provideNonPalindromeParameters() {
        return Stream.of(
                Arguments.of(Named.named("Non-palindrome 'hello'", "hello")),
                Arguments.of(Named.named("Non-palindrome 'java'", "java")),
                Arguments.of(Named.named("Non-palindrome 'world'", "world")),
                Arguments.of(Named.named("Non-palindrome '12345'", "12345")),
                Arguments.of(Named.named("Non-palindrome 'notapalindrome'", "notapalindrome"))
        );
    }


}
