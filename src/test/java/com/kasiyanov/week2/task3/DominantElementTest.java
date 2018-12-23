package com.kasiyanov.week2.task3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DominantElementTest {

    @Test
    public void checkDominant() {
        DominantElement dominantElement = new DominantElement();
        int firstDominant;

        List<Integer> firstList = new ArrayList<>();
        firstList.add(10);
        firstList.add(9);
        firstList.add(9);
        firstList.add(9);
        firstList.add(10);

        firstDominant = dominantElement.getDominantElement(firstList);
        assertEquals(firstDominant, 9L);
    }

    @Test
    public void checkDominant2() {
        DominantElement dominantElement = new DominantElement();
        int secondDominant;

        List<Integer> secondList = new ArrayList<>();
        secondList.add(3);
        secondList.add(2);
        secondList.add(3);

        secondDominant = dominantElement.getDominantElement(secondList);
        assertEquals(secondDominant, 3L);
    }

    @Test
    public void checkDominant3() {
        DominantElement dominantElement = new DominantElement();
        int thirdDominant;

        List<Integer> thirdList = new ArrayList<>();
        thirdList.add(2);
        thirdList.add(2);
        thirdList.add(1);
        thirdList.add(1);
        thirdList.add(1);
        thirdList.add(2);
        thirdList.add(2);

        thirdDominant = dominantElement.getDominantElement(thirdList);
        assertEquals(thirdDominant, 2L);
    }

}