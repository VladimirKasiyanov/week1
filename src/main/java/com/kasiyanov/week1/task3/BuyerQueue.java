package com.kasiyanov.week1.task3;

import java.util.concurrent.LinkedBlockingDeque;

public class BuyerQueue {

    private static LinkedBlockingDeque<Buyer> deque = new LinkedBlockingDeque<>();

    static void addToQueue(Buyer buyer) {
        try {
            deque.putLast(buyer);
            //System.out.println("Покупатель добавлен в очередь, кол-во покупок - " + buyer.getGoodsInBusket());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer extractBuyerFromQueue() {
        try {
            return deque.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    static synchronized int getCount() {
        return deque.size();
    }
}
