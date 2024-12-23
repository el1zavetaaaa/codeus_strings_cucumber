package org.codeus.thursday.warmup;

import org.codeus.thursday.warmup.PatternExercises;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PatternExercisesTest {


    @ParameterizedTest(name = "{0}")
    @MethodSource("provideValidExtractDigitsCases")
    @DisplayName("extract digits")
    public void testExtractDigitsValidCases(String input, String expected) {
        assertEquals(expected, PatternExercises.extractDigits(input));
    }

    private static Stream<Arguments> provideValidExtractDigitsCases() {
        return Stream.of(
                Arguments.of(Named.named("'abc123de45' => '12345'", "abc123de45"), "12345"),
                Arguments.of(Named.named("'no digits here' => ''", "no digits here"), ""),
                Arguments.of(Named.named("'123' => '123'", "123"), "123"),
                Arguments.of(Named.named("'A1B2C3' => '123'", "A1B2C3"), "123")
        );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("extractDigits should throw IllegalArgumentException for null input")
    public void testExtractDigitsThrowsExceptionForNullInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> PatternExercises.extractDigits(input));
    }


    @ParameterizedTest(name = "{0}")
    @MethodSource("provideValidEmails")
    @DisplayName("valid email addresses")
    public void testIsValidEmailValidCases(String email) {
        assertTrue(PatternExercises.isValidEmail(email));
    }

    private static Stream<Arguments> provideValidEmails() {
        return Stream.of(
                Arguments.of(Named.named("'test@example.com' => true", "test@example.com")),
                Arguments.of(Named.named("'user123@domain.co' => true", "user123@domain.co"))
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provideInvalidEmails")
    @DisplayName("invalid email addresses")
    public void testIsValidEmailInvalidCases(String email) {
        assertFalse(PatternExercises.isValidEmail(email));
    }

    private static Stream<Arguments> provideInvalidEmails() {
        return Stream.of(
                Arguments.of(Named.named("'missing domain' => false", "missing@domain")),
                Arguments.of(Named.named("'not an email' => false", "notAnEmail")),
                Arguments.of(Named.named("'invalid@.com' => false", "invalid@.com"))
        );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("isValidEmail should throw IllegalArgumentException for null input")
    public void testIsValidEmailThrowsExceptionForNullInput(String email) {
        assertThrows(IllegalArgumentException.class, () -> PatternExercises.isValidEmail(email));
    }


    @ParameterizedTest(name = "{0}")
    @MethodSource("provideValidFindCapitalizedWordsCases")
    @DisplayName("find capitalized words in valid strings")
    void testFindCapitalizedWordsValidCases(String input, String expected) {
        assertEquals(expected, PatternExercises.findCapitalizedWords(input));
    }

    private static Stream<Arguments> provideValidFindCapitalizedWordsCases() {
        return Stream.of(
                Arguments.of(Named.named("'Hello World!' => 'Hello World!'", "Hello World!"), "Hello World"),
                Arguments.of(Named.named("'java Programming Language' => 'Programming Language'", "java Programming Language"), "Programming Language"),
                Arguments.of(Named.named("'A B C D' => 'A B C D'", "A B C D"), "A B C D")
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provideInvalidFindCapitalizedWordsCases")
    @DisplayName("find capitalized words in strings with no capitalized words")
    public void testFindCapitalizedWordsInvalidCases(String input, String expected) {
        assertEquals(expected, PatternExercises.findCapitalizedWords(input));
    }

    private static Stream<Arguments> provideInvalidFindCapitalizedWordsCases() {
        return Stream.of(
                Arguments.of(Named.named("'all lowercase' => ''", "all lowercase"), ""),
                Arguments.of(Named.named("'12345' => ''", "12345"), ""),
                Arguments.of(Named.named("'' => ''", ""), "")
        );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("findCapitalizedWords should throw IllegalArgumentException for null input")
    public void testFindCapitalizedWordsThrowsExceptionForNullInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> PatternExercises.findCapitalizedWords(input));
    }
}
