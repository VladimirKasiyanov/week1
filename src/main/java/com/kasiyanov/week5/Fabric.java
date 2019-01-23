package com.kasiyanov.week5;

import com.kasiyanov.week5.util.RandomUtil;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class Fabric implements Runnable {

    private final List<Part> pickedUpParts;
    private final Object monitor;
    private final int countOfNights;

    @Override
    public void run() {
        List<Part> parts = Arrays.asList(Part.values());
        createStartPickedUpPartsList(parts);
        int night = 1;
        while (night <= countOfNights) {
            night++;
            synchronized (pickedUpParts) {
                for (int i = 0; i < RandomUtil.generate(parts.size()); i++) {
                    pickedUpParts.add(parts.get(RandomUtil.generate(parts.size())));
                }
            }
            synchronized (monitor) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void createStartPickedUpPartsList(List<Part> parts) {
        for (int i = 0; i < 20; i++) {
            pickedUpParts.add(parts.get(RandomUtil.generate(parts.size())));
        }
    }
}
