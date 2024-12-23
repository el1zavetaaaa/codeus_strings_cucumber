package org.codeus.tuesday.maintask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressProcessor {
    private static final List<String> FLAT_PREFIXES = Arrays.asList("Flat", "Fl", "Apartment", "Apt");
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\b\\d+(?:\\s?[A-Za-z]|[A-Za-z./-]*\\d*)?\\b");

    /**
     * Processes a list of address lines to extract numerics and building name.
     *
     * @param addressLines List of address lines
     * @return String containing extracted numerics
     */
    public static String processAddress(List<String> addressLines) {
        validateInput(addressLines);

        // Create mutable copies of the address lines
        List<StringBuilder> mutableLines = new ArrayList<>();
        for (String line : addressLines) {
            mutableLines.add(new StringBuilder(line));
        }

        return extractNumerics(mutableLines);
    }

    /**
     * Validates the input address lines.
     */
    private static void validateInput(List<String> addressLines) {
        if (addressLines == null || addressLines.isEmpty()) {
            throw new IllegalArgumentException("Address lines cannot be null or empty");
        }
    }

    /**
     * Extracts concatenated numerics from address lines.
     */
    private static String extractNumerics(List<StringBuilder> addressLines) {
        StringBuilder numericsBuilder = new StringBuilder();

        prepareStringWithFlatPrefix(numericsBuilder, addressLines);

        for (StringBuilder line : addressLines) {
            String numericMatch = extractFirstMatch(line);
            if (!numericMatch.isEmpty()) {
                appendWithSeparator(numericsBuilder, numericMatch);
            }
        }

        return numericsBuilder.toString();
    }

    private static void prepareStringWithFlatPrefix(final StringBuilder numericsBuilder, final List<StringBuilder> addressLines) {
        if (isFlatWithLetter(addressLines.get(0).toString()) && addressLines.size() > 1) {
            String flatLetter = getFlatLetter(addressLines.get(0).toString());
            String numericPart = extractFirstMatch(addressLines.get(1));

            if (!numericPart.isEmpty()) {
                appendWithSeparator(numericsBuilder, numericPart + flatLetter);
            }
        }
    }

    /**
     * Checks if a line starts with a flat prefix and contains a single letter.
     */
    private static boolean isFlatWithLetter(String line) {
        return FLAT_PREFIXES.stream().anyMatch(prefix -> line.matches(prefix + " [A-Za-z]"));
    }

    /**
     * Extracts the flat letter from the line.
     */
    private static String getFlatLetter(String line) {
        return line.split(" ")[1];
    }

    /**
     * Extracts the first numeric match from a line and removes it from the line.
     */
    private static String extractFirstMatch(StringBuilder line) {
        Matcher matcher = NUMERIC_PATTERN.matcher(line);
        if (matcher.find()) {
            String match = matcher.group().replace(" ", "");
            line.delete(matcher.start(), matcher.end());
            return match;
        }
        return "";
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
