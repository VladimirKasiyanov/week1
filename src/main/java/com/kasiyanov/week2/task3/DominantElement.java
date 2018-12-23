package com.kasiyanov.week2.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DominantElement {
    private Map<Integer, Integer> numbersMap = new HashMap<>();

    public int getDominantElement(List<Integer> list) {
        int counter;
        int max = 0;
        int dominant = 0;

        for (Integer currentNumber : list) {
            if (numbersMap.get(currentNumber) == null) {
                counter = 1;
                numbersMap.put(currentNumber, counter);
            } else {
                counter = numbersMap.get(currentNumber) + 1;
                numbersMap.put(currentNumber, counter);
            }
        }

        for (Map.Entry<Integer, Integer> entry : numbersMap.entrySet()) {
            Integer value = entry.getValue();
            if (max < value) {
                max = value;
                dominant = entry.getKey();
            }
        }

        return dominant;
    }
}
