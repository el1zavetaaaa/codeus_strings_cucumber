package org.example.tuesday.maintask;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressProcessor {
    private static final List<String> FLAT_PREFIXES = Arrays.asList("Flat", "Fl", "Apartment", "Apt");
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\b\\d+(?:\\s?[A-Za-z]|[A-Za-z./-]*\\d*)?\\b");

    /**
     * Main method to process the list of address lines.
     *
     * @param addressLines List of address lines
     * @return A result map with extracted numerics and building name
     */
    public static Map<String, String> processAddress(List<String> addressLines) {
        Map<String, String> result = new HashMap<>();
        if (addressLines == null || addressLines.isEmpty()) {
            throw new IllegalArgumentException("Address lines cannot be null or empty");
        }

        result.put("Numerics", extractNumerics(addressLines));
        result.put("BuildingName", extractBuildingName(addressLines));

        return result;
    }

    /**
     * Extracts numerics from address lines. Handles cases with flat prefixes.
     *
     * @param addressLines List of address lines
     * @return String containing concatenated numerics or an empty string
     */
    private static String extractNumerics(List<String> addressLines) {
        StringBuilder numericsBuilder = new StringBuilder();

        if (isFlatWithLetter(addressLines.get(0)) && addressLines.size() > 1) {
            String flatLetter = getFlatLetter(addressLines.get(0));
            String numericPart = extractFirstMatch(addressLines.get(1));
            if (!numericPart.isEmpty()) {
                appendWithSeparator(numericsBuilder, numericPart + flatLetter);
            }
        }

        for (String line : addressLines) {
            String numericMatch = extractFirstMatch(line);
            if (!numericMatch.isEmpty()) {
                appendWithSeparator(numericsBuilder, numericMatch);
            }
        }

        return numericsBuilder.toString();
    }

    /**
     * Extracts the building name, appending flat letters if applicable.
     *
     * @param addressLines List of address lines
     * @return Building name with optional flat letter
     */
    private static String extractBuildingName(List<String> addressLines) {
        if (isFlatWithLetter(addressLines.get(0)) && addressLines.size() > 1) {
            return appendFlatToBuildingName(addressLines.get(1), getFlatLetter(addressLines.get(0)));
        }
        return addressLines.get(0);
    }

    /**
     * Appends flat letter to the building name.
     */
    private static String appendFlatToBuildingName(String buildingName, String flatLetter) {
        return buildingName + (flatLetter.isEmpty() ? "" : " " + flatLetter);
    }

    /**
     * Checks if the line starts with a flat prefix followed by a single letter.
     */
    private static boolean isFlatWithLetter(String line) {
        return FLAT_PREFIXES.stream().anyMatch(prefix -> line.matches(prefix + " [A-Za-z]"));
    }

    /**
     * Extracts the flat letter following the prefix.
     */
    private static String getFlatLetter(String line) {
        return line.split(" ")[1];
    }

    /**
     * Extracts the first numeric match in a line.
     */
    private static String extractFirstMatch(String line) {
        Matcher matcher = NUMERIC_PATTERN.matcher(line);
        return matcher.find() ? matcher.group().replace(" ", "") : "";
    }

    /**
     * Appends a value to the StringBuilder with a colon separator.
     */
    private static void appendWithSeparator(StringBuilder builder, String value) {
        if (!builder.isEmpty()) {
            builder.append(":");
        }
        builder.append(value);
    }

}
