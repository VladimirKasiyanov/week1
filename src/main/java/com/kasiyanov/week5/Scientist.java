package com.kasiyanov.week5;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class Scientist implements Runnable {

    private final List<Part> pickedUpParts;
    private final Object monitor;
    private final int countOfNights;

    @Getter
    private int robotsCount;
    private List<Part> partsList = Arrays.asList(Part.values());
    private Map<Part, Integer> partsInStock = new HashMap<>();

    @Override
    public void run() {
        createPartInStockMap();
        Acolyte acolyte = new Acolyte(this.pickedUpParts, partsInStock);
        int night = 1;
        while (night <= countOfNights) {
            night++;
            synchronized (pickedUpParts) {
                acolyte.collectParts();
            }
            acolyte.getCollectedParts();
            createRobotsIfPossible();
            synchronized (monitor) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void createRobotsIfPossible() {
        int minCountCurrentPartInStock = partsInStock.values()
                .stream().min(Integer::compare).orElse(0);
        if (minCountCurrentPartInStock > 0) {
            partsInStock.forEach((key, value) ->
                    partsInStock.put(key, (value - minCountCurrentPartInStock)));
            robotsCount += minCountCurrentPartInStock;
        }
    }

    private void createPartInStockMap() {
        partsList.forEach(part -> partsInStock.put(part, 0));
    }
}
