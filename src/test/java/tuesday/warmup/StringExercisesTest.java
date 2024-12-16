package com.example.exercises;

import org.example.tuesday.warmup.StringExercises;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * {@link StringExercisesTest} validates the correctness of methods in {@link StringExercises}.
 * If a method is not implemented, the test will fail with a clear message.
 */
public class StringExercisesTest {

    @Test
    public void testIsStringFromPool() {
        try {
            assertTrue("String literals and interned strings should refer to the same object",
                    StringExercises.isStringFromPool());
        } catch (UnsupportedOperationException e) {
            fail("Method isStringFromPool is not implemented: " + e.getMessage());
        }
    }

    @Test
    public void testCountCharacterOccurrences() {
        try {
            assertEquals(3, StringExercises.countCharacterOccurrences("banana", 'a'));
            assertEquals(0, StringExercises.countCharacterOccurrences("apple", 'z'));
            assertEquals(1, StringExercises.countCharacterOccurrences("hello", 'o'));
            assertEquals(4, StringExercises.countCharacterOccurrences("aaaa", 'a'));
            assertEquals(3, StringExercises.countCharacterOccurrences("bubble", 'b'));
        } catch (UnsupportedOperationException e) {
            fail("Method countCharacterOccurrences is not implemented: " + e.getMessage());
        }
    }

    @Test
    public void testReverseString() {
        try {
            assertEquals("olleh", StringExercises.reverseString("hello"));
            assertEquals("avaJ", StringExercises.reverseString("Java"));
            assertEquals("racecar", StringExercises.reverseString("racecar"));
            assertEquals("12321", StringExercises.reverseString("12321"));
            assertEquals("!dlroW ,olleH", StringExercises.reverseString("Hello, World!"));
        } catch (UnsupportedOperationException e) {
            fail("Method reverseString is not implemented: " + e.getMessage());
        }
    }

    @Test
    public void testIsPalindrome() {
        try {
            assertTrue(StringExercises.isPalindrome("madam"));
            assertTrue(StringExercises.isPalindrome("racecar"));
            assertTrue(StringExercises.isPalindrome("12321"));
            assertTrue(StringExercises.isPalindrome("abba"));
            assertTrue(StringExercises.isPalindrome("a"));
            assertFalse(StringExercises.isPalindrome("hello"));
            assertFalse(StringExercises.isPalindrome("java"));
        } catch (UnsupportedOperationException e) {
            fail("Method isPalindrome is not implemented: " + e.getMessage());
        }
    }
}
