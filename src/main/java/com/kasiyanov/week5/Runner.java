package com.kasiyanov.week5;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static final Object MONITOR = new Object();

    public static void main(String[] args) {
        List<Part> pickedUpParts = new ArrayList<>();
        int countOfNights = 100;

        Scientist firstScientist = new Scientist(pickedUpParts, MONITOR, countOfNights);
        Scientist secondScientist = new Scientist(pickedUpParts, MONITOR, countOfNights);

        Thread nightTimerThread = new Thread(new NightTimer(countOfNights, MONITOR));
        Thread fabricThread = new Thread(new Fabric(pickedUpParts, MONITOR, countOfNights));
        Thread firstScientistThread = new Thread(firstScientist);
        Thread secondScientistThread = new Thread(secondScientist);

        nightTimerThread.start();
        fabricThread.start();
        firstScientistThread.start();
        secondScientistThread.start();

        try {
            nightTimerThread.join();
            fabricThread.join();
            firstScientistThread.join();
            secondScientistThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Первый учёный собрал " + firstScientist.getRobotsCount() + " роботов");
        System.out.println("Второй учёный собрал " + secondScientist.getRobotsCount() + " роботов");

        findWinner(firstScientist, secondScientist);

    }

    private static void findWinner(Scientist firstScientist, Scientist secondScientist) {
        if (firstScientist.getRobotsCount() > secondScientist.getRobotsCount()) {
            System.out.println("Первый учёный победил");
        } else if (firstScientist.getRobotsCount() < secondScientist.getRobotsCount()) {
            System.out.println("Второй учёный победил");
        } else {
            System.out.println("Ничья");
        }
    }


}
