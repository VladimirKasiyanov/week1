package com.kasiyanov.week2.task4;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArraySortOddNumbersTest {

    @Test
    public void checkSortedNumbers() {
        int[] numbersArray = {5, 3, 2, 8, 1, 4};
        int[] expectedArray = {1, 3, 2, 8, 5, 4};
        int[] resultArray;
        ArraySortOddNumbers arraySortOddNumbers = new ArraySortOddNumbers();

        resultArray = arraySortOddNumbers.sortOddNumbers(numbersArray);
        assertArrayEquals(expectedArray, resultArray);
    }

}