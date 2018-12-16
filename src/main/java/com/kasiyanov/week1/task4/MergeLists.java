package com.kasiyanov.week1.task4;

import java.util.ArrayList;
import java.util.List;

public class MergeLists {

    public List<Integer> MergeTwoSortedList(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> mergedList = new ArrayList<>(firstList.size() + secondList.size());
        int firstListElemetn = 0;
        int secondListElemetn = 0;
        while (firstListElemetn < firstList.size() &&
                secondListElemetn < secondList.size()) {
            if (firstList.get(firstListElemetn) <= secondList.get(secondListElemetn)) {
                mergedList.add(firstList.get(firstListElemetn++));
            } else {
                mergedList.add(secondList.get(secondListElemetn++));
            }
        }
        while (firstListElemetn < firstList.size()) {
            mergedList.add(firstList.get(firstListElemetn++));
        }
        while (secondListElemetn < secondList.size()) {
            mergedList.add(secondList.get(secondListElemetn++));
        }

        return mergedList;
    }
}
