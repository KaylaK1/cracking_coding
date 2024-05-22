package com.crackingcoding;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class BasicTests {
    @Test
    @DisplayName("First number is greater than the second")
    public void compare() {
        Basics basicTests = new Basics();
        int value = basicTests.compare(2, 1); // should return -1

        Assertions.assertEquals(1, value);
    }

    @Test
    @DisplayName("First number is less than the second")
    public void compare2() {
        Basics basicTests = new Basics();
        int value = basicTests.compare(1, 2); // should return -1

        Assertions.assertEquals(-1, value);
    }

    @Test
    @DisplayName("Array Sorted")
    public void sortArray() {
        Basics basicTests = new Basics();
        int[] array = { 5, 8, 3, 9, 1, 6 };
        basicTests.sortArray(array);

        Assertions.assertArrayEquals(new int[] { 1, 3, 5, 6, 8, 9 }, array);
    }
}
