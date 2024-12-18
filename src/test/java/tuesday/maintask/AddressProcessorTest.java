package tuesday.maintask;

import org.example.tuesday.maintask.AddressProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddressProcessorTest {

    @DisplayName("Should throw IllegalArgumentException when address lines are null or empty")
    @ParameterizedTest(name = "{index} => Input: {0}")
    @NullAndEmptySource
    public void testInvalidInputs(List<String> addressLines) {
        assertThrows(IllegalArgumentException.class, () -> AddressProcessor.processAddress(addressLines),
                "Expected IllegalArgumentException for null or empty input");
    }

    @Test
    @DisplayName("Test for null input")
    public void testForNullInput() {
        assertThrows(IllegalArgumentException.class, () -> AddressProcessor.processAddress(null),
                "Expected IllegalArgumentException for null input");
    }

    @DisplayName("Process addresses with only numbers")
    @ParameterizedTest(name = "{index} => Input: {0} => Expected: {1}")
    @MethodSource("provideNumericCases")
    public void testNumericCases(List<String> addressLines, String expectedNumerics, String expectedBuildingName) {
        Map<String, String> result = AddressProcessor.processAddress(addressLines);
        assertEquals(expectedNumerics, result.get("Numerics"));
        assertEquals(expectedBuildingName, result.get("BuildingName"));
    }

    private static Stream<Arguments> provideNumericCases() {
        return Stream.of(
                Arguments.of(Named.named("Single numeric address", List.of("73 Baker Street")), "73", "73 Baker Street"),
                Arguments.of(Named.named("Flat range address", List.of("111-113 Baker Street")), "111-113", "111-113 Baker Street"),
                Arguments.of(Named.named("Decimal number address", List.of("1.4 Baker Street")), "1.4", "1.4 Baker Street"),
                Arguments.of(Named.named("Fractional address", List.of("1/4 Baker Street")), "1/4", "1/4 Baker Street")
        );
    }

    @DisplayName("Process addresses with numbers and letters")
    @ParameterizedTest(name = "{index} => Input: {0} => Expected: {1}")
    @MethodSource("provideNumbersWithLetters")
    public void testNumbersWithLetters(List<String> addressLines, String expectedNumerics, String expectedBuildingName) {
        Map<String, String> result = AddressProcessor.processAddress(addressLines);
        assertEquals(expectedNumerics, result.get("Numerics"));
        assertEquals(expectedBuildingName, result.get("BuildingName"));
    }

    private static Stream<Arguments> provideNumbersWithLetters() {
        return Stream.of(
                Arguments.of(Named.named("Number with letter", List.of("73A Baker Street")), "73A", "73A Baker Street"),
                Arguments.of(Named.named("Space-separated letter", List.of("73 A Baker Street")), "73A", "73 A Baker Street")
        );
    }

    @DisplayName("Process flat lines with numbers")
    @ParameterizedTest(name = "{index} => Input: {0} => Expected: {1}")
    @MethodSource("provideFlatWithNumbers")
    public void testFlatWithNumbers(List<String> addressLines, String expectedNumerics, String expectedBuildingName) {
        Map<String, String> result = AddressProcessor.processAddress(addressLines);
        assertEquals(expectedNumerics, result.get("Numerics"));
        assertEquals(expectedBuildingName, result.get("BuildingName"));
    }

    private static Stream<Arguments> provideFlatWithNumbers() {
        return Stream.of(
                Arguments.of(Named.named("Flat with single number", List.of("Flat 1", "73 Baker Street")), "1:73", "73 Baker Street"),
                Arguments.of(Named.named("Flat with number and letter", List.of("Flat 1A", "73 Baker Street")), "1A:73", "73 Baker Street"),
                Arguments.of(Named.named("Flat with fraction", List.of("Flat 1/4", "73 Baker Street")), "1/4:73", "73 Baker Street")
        );
    }

    @DisplayName("Process flats with only one letter")
    @ParameterizedTest(name = "{index} => Input: {0} => Expected: {1}")
    @MethodSource("provideFlatWithSingleLetter")
    public void testFlatWithSingleLetter(List<String> addressLines, String expectedNumerics, String expectedBuildingName) {
        Map<String, String> result = AddressProcessor.processAddress(addressLines);
        assertEquals(expectedNumerics, result.get("Numerics"));
        assertEquals(expectedBuildingName, result.get("BuildingName"));
    }

    private static Stream<Arguments> provideFlatWithSingleLetter() {
        return Stream.of(
                Arguments.of(Named.named("Flat letter with number", List.of("Flat A", "73 Baker Street")), "73A", "73 Baker Street"),
                Arguments.of(Named.named("Flat letter only", List.of("Flat C", "Tulip Avenue")), "", "Tulip Avenue C")
        );
    }
}
