package com.kasiyanov.week5;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NightTimer implements Runnable {

    private int countOfNights;
    private final Object monitor;

    @Override
    public void run() {
        for (int i = 0; i <= countOfNights; i++) {
            synchronized (monitor) {
                monitor.notifyAll();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
