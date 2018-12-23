package com.kasiyanov.week2.task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AnagramSearcherTest {

    @Test
    public void searchAnagram() {
        String line[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        AnagramSearcher anagramSearcher = new AnagramSearcher();
        List<List<String>> expectedAnagramsWordsLists = new ArrayList<>();

        List<String> firstAnagramList = new ArrayList<>();
        firstAnagramList.add("ate");
        firstAnagramList.add("eat");
        firstAnagramList.add("tea");

        List<String> secondAnagramList = new ArrayList<>();
        secondAnagramList.add("nat");
        secondAnagramList.add("tan");

        List<String> thirdAnagramList = new ArrayList<>();
        thirdAnagramList.add("bat");

        expectedAnagramsWordsLists.add(firstAnagramList);
        expectedAnagramsWordsLists.add(secondAnagramList);
        expectedAnagramsWordsLists.add(thirdAnagramList);

        List<List<String>> resultAnagramsWordsLists = anagramSearcher.convertToAnagramLists(line);

        /*for (List<String> words : resultAnagramsWordsLists) {
            for (String word : words) {
                System.out.print(word + " ");
            }
            System.out.println();
        }*/

        assertEquals(expectedAnagramsWordsLists, resultAnagramsWordsLists);
    }
}
