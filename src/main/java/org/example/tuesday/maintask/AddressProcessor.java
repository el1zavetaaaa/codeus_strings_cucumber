package org.example.tuesday.maintask;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class AddressProcessor {

    // Add needed items to flat prefixes list.
    private static final List<String> FLAT_PREFIXES = Arrays.asList();
    // Create a pattern which will retract numerics from the given String.
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("");

    /**
     * Processes a list of address lines to extract numerics.
     *
     * @param addressLines List of address lines
     * @return String containing extracted numerics
     * @throws IllegalArgumentException if addressLines is null or empty
     */
    public static String processAddress(List<String> addressLines) {
        // TODO:
        // 1. **Input Validation**:
        //    - Check if the `addressLines` list is null or empty.
        //    - If so, throw an `IllegalArgumentException` with an appropriate error message.
        //
        // 2. **Prepare Mutable Lines**:
        //    - Convert each line in `addressLines` into a mutable `StringBuilder` object.
        //    - Store these mutable lines in a new list.
        //
        // 3. **Handle Flat Prefix Case**:
        //    - Check if the first line starts with a flat-related prefix (e.g., "Flat A").
        //    - If true:
        //      - Extract the flat letter (e.g., "A") from the first line.
        //      - Find the numeric part of the second line (e.g., "73").
        //      - Append the numeric part concatenated with the flat letter (e.g., "73A") to the result.
        //
        // 4. **Extract Remaining Numerics**:
        //    - Loop through each line (after processing the flat prefix case).
        //    - Use the `NUMERIC_PATTERN` regex to extract the first numeric match from each line.
        //    - Remove the matched numeric part from the line (to prevent duplication in later logic).
        //    - Append the extracted numeric match to the result, separated by a colon (`:`) if necessary.
        //
        // 5. **Return the Result**:
        //    - Concatenate all numeric matches into a single string and return it.
        //
        // Example Outputs:
        //    - Input: ["Flat A", "73 Baker Street"] -> Output: "73A"
        //    - Input: ["Flat 1/4", "111-113 Maple Street"] -> Output: "1/4:111-113"
        //    - Input: ["111 Baker Street"] -> Output: "111"
        //
        throw new UnsupportedOperationException("Method not implemented");
    }
}
