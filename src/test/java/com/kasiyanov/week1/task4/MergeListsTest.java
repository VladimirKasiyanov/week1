package com.kasiyanov.week1.task4;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MergeListsTest {

    @Test
    public void checkMergingTwoSortedList() {
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(3);
        firstList.add(5);

        List<Integer> secondList = new ArrayList<>();
        secondList.add(2);
        secondList.add(6);
        secondList.add(8);

        List<Integer> resultSecondList = secondList;

        List<Integer> resultList = new ArrayList<>();
        resultList.add(1);
        resultList.add(2);
        resultList.add(3);
        resultList.add(5);
        resultList.add(6);
        resultList.add(8);

        MergeLists mergeLists = new MergeLists();
        firstList = mergeLists.MergeTwoSortedList(firstList, secondList);

        Assert.assertEquals(resultList, firstList);
        Assert.assertEquals(resultSecondList, secondList);
    }
}