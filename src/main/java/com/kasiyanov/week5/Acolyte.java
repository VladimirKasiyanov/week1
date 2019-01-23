package com.kasiyanov.week5;

import com.kasiyanov.week5.util.RandomUtil;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class Acolyte {

    private final List<Part> pickedUpParts;
    private final Map<Part, Integer> partsInStock;
    private final List<Part> collectedParts = new ArrayList<>();

    private List<Part> parts = Arrays.asList(Part.values());

    public void collectParts() {
        for (int i = 0; i < RandomUtil.generate(parts.size()); i++) {
            if (!pickedUpParts.isEmpty()) {
                collectedParts.add(pickedUpParts.remove(RandomUtil.generate(pickedUpParts.size())));
            }
        }
    }

    public void getCollectedParts() {
        if (!collectedParts.isEmpty()) {
            collectedParts.forEach(part -> partsInStock.
                    computeIfPresent(part, (key, value) -> value + 1));
            collectedParts.clear();
        }
    }
}
