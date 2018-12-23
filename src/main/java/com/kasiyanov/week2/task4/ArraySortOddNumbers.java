package com.kasiyanov.week2.task4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraySortOddNumbers {

    private Map<Integer, Integer> evenNumbersMap = new HashMap<>();

    public int[] sortOddNumbers(int[] inputArray) {
        int counter = 0;
        int resultArray[] = new int[inputArray.length];
        List<Integer> oddList = new ArrayList<>();

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] % 2 > 0) {
                oddList.add(inputArray[i]);
            } else {
                evenNumbersMap.put(i, inputArray[i]);
            }
        }

        oddList.sort(Comparator.naturalOrder());

        for (int i = 0; i < resultArray.length; i++) {
            if (evenNumbersMap.get(i) == null) {
                resultArray[i] = oddList.get(counter);
                counter++;
            } else {
                resultArray[i] = evenNumbersMap.get(i);
            }
        }

        return resultArray;
    }
}
