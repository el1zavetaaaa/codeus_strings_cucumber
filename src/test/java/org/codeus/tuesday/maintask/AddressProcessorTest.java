package org.codeus.tuesday.maintask;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddressProcessorTest {

    @DisplayName("Should throw IllegalArgumentException when address lines are null or empty")
    @ParameterizedTest(name = "{0}")
    @NullAndEmptySource
    public void testInvalidInputs(List<String> addressLines) {
        assertThrows(IllegalArgumentException.class, () -> AddressProcessor.processAddress(addressLines),
                "Expected IllegalArgumentException for null or empty input");
    }

    @DisplayName("Process addresses with only numbers")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideNumericCases")
    public void testNumericCases(List<String> addressLines, String expectedNumerics) {
        String result = AddressProcessor.processAddress(addressLines);
        assertEquals(expectedNumerics, result);
    }

    private static Stream<Arguments> provideNumericCases() {
        return Stream.of(
                Arguments.of(Named.named("['73 Baker Street'] => '73'", List.of("73 Baker Street")), "73"),
                Arguments.of(Named.named("['111-113 Baker Street'] => '111-113'", List.of("111-113 Baker Street")), "111-113"),
                Arguments.of(Named.named("['1.4 Baker Street'] => '1.4'", List.of("1.4 Baker Street")), "1.4"),
                Arguments.of(Named.named("['1/4 Baker Street'] => '1/4'", List.of("1/4 Baker Street")), "1/4")
        );
    }

    @DisplayName("Process addresses with numbers and letters")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideNumbersWithLetters")
    public void testNumbersWithLetters(List<String> addressLines, String expectedNumerics) {
        String result = AddressProcessor.processAddress(addressLines);
        assertEquals(expectedNumerics, result);
    }

    private static Stream<Arguments> provideNumbersWithLetters() {
        return Stream.of(
                Arguments.of(Named.named("['73A Baker Street'] => '73A'", List.of("73A Baker Street")), "73A"),
                Arguments.of(Named.named("['73 A Baker Street'] => '73A'", List.of("73 A Baker Street")), "73A")
        );
    }

    @DisplayName("Process flat lines with numbers")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideFlatWithNumbers")
    public void testFlatWithNumbers(List<String> addressLines, String expectedNumerics) {
        String result = AddressProcessor.processAddress(addressLines);
        assertEquals(expectedNumerics, result);
    }

    private static Stream<Arguments> provideFlatWithNumbers() {
        return Stream.of(
                Arguments.of(Named.named("['Flat 1', '73 Baker Street'] => '1:73'", List.of("Flat 1", "73 Baker Street")), "1:73"),
                Arguments.of(Named.named("['Flat 1A', '73 Baker Street'] => '1A:73'", List.of("Flat 1A", "73 Baker Street")), "1A:73"),
                Arguments.of(Named.named("['Flat 1/4', '73 Baker Street'] => '1/4:73'", List.of("Flat 1/4", "73 Baker Street")), "1/4:73"),
                Arguments.of(Named.named("['Flat A', '73 Baker Street'] => '1/4:73'", List.of("Flat A", "73 Baker Street")), "73A")
        );
    }

}
