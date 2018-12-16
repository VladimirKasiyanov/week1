package com.kasiyanov.week1.task3;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market extends Thread {

    private final int THREADPOOL = 10;

    private int cashierTimeForOneGood;
    private int cashiersQuantity = 2;
    private ArrayList<Integer> buyersGoodsInBusketList;

    public Market(int cashierTimeForOneGood, int cashiersQuantity, ArrayList<Integer> buyersGoodsInBusketList) {
        this.cashierTimeForOneGood = cashierTimeForOneGood;
        this.cashiersQuantity = cashiersQuantity;
        this.buyersGoodsInBusketList = buyersGoodsInBusketList;
    }

    private ExecutorService executor = Executors.newFixedThreadPool(THREADPOOL);
    static ConcurrentMap<String, Integer> cashiersWorkingTime = new ConcurrentHashMap<>();

    private void createBuyerQueue(ArrayList buyersGoodsInBusketList) {
        for (int i = 0; i < buyersGoodsInBusketList.size(); i++) {
            BuyerQueue.addToQueue(new Buyer((Integer) buyersGoodsInBusketList.get(i)));
        }
    }

    @Override
    public void run() {
        createBuyerQueue(buyersGoodsInBusketList);
        //System.out.println("Очередь заполнена, кол-во покупателей = " + BuyerQueue.getCount());
        for (int i = 0; i < cashiersQuantity; i++) {
            executor.execute(new Cashier(getCashiersNumbers(), cashierTimeForOneGood));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1L, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //System.out.println("Кассиры завершили работу");
        //System.out.println("Время работы касс " + totalWorkingTime());
    }

    private int cashiersNumber;

    private synchronized int getCashiersNumbers() {
        return ++cashiersNumber;
    }

    public int totalWorkingTime() {
        int maxTime = 0;
        for (String key : Market.cashiersWorkingTime.keySet()) {
            //System.out.println("Значения времени работы касс" + Market.cashiersWorkingTime.get(key));
            if (maxTime < Market.cashiersWorkingTime.get(key)) {
                maxTime = Market.cashiersWorkingTime.get(key);
            }
        }
        return maxTime;
    }
}
