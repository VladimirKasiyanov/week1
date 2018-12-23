package com.kasiyanov.week2.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramSearcher {

    private List<String> keyWordsList = new ArrayList<>();
    private List<List<String>> anagramsWordsLists = new ArrayList<>();
    private Map<String, List<String>> wordsMap = new HashMap<>();

    public List<List<String>> convertToAnagramLists(String[] words) {
        createAnagramsHashMap(words);
        sortMapList();

        for (int i = 0; i < wordsMap.size(); i++) {
            anagramsWordsLists.add(wordsMap.get(keyWordsList.get(i)));
        }

        return anagramsWordsLists;
    }

    private void createAnagramsHashMap(String[] words) {
        List<String> currentWordsList;
        String currentWord;
        char[] currentWordSymbolsArray;
        String wordKey;

        for (String word : words) {
            currentWord = word;
            currentWordSymbolsArray = currentWord.toCharArray();
            Arrays.sort(currentWordSymbolsArray);

            wordKey = Arrays.toString(currentWordSymbolsArray);

            currentWordsList = wordsMap.get(wordKey);

            if (currentWordsList == null) {
                currentWordsList = new ArrayList<>();
                currentWordsList.add(currentWord);
                keyWordsList.add(wordKey);
            } else {
                currentWordsList.add(currentWord);
            }

            wordsMap.put(wordKey, currentWordsList);
        }
        sortMapList();
    }

    private void sortMapList() {
        List<String> words;
        for (Map.Entry entry : wordsMap.entrySet()) {
            words = wordsMap.get(entry.getKey());
            words.sort(Comparator.naturalOrder());
        }
    }
}
