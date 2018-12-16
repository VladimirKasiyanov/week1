package com.kasiyanov.week1.task3;

import lombok.Getter;

import static com.kasiyanov.week1.task3.Market.cashiersWorkingTime;

public class Cashier extends Thread {

    @Getter
    private String cashierName;
    private int number;
    private int timeForOneGood;

    Cashier(int number, int timeForOneGood) {
        this.number = number;
        this.cashierName = "Кассир № " + this.number;
        this.timeForOneGood = timeForOneGood;
    }

    @Override
    public void run() {
        //System.out.println("Кассир " + cashierName + " начал работать");
        while (BuyerQueue.getCount() > 0) {
            Buyer buyer = BuyerQueue.extractBuyerFromQueue();
            if (buyer != null) {
                int workingTime;
                //System.out.println("Покупатель подошёл к кассе, кол-во покупок - " + buyer.getGoodsInBusket());
                if (cashiersWorkingTime.get(this.getCashierName()) != null) {
                    workingTime = cashiersWorkingTime.get(this.getCashierName()) + timeForOneGood * buyer.getGoodsInBusket();
                    //System.out.println("Кассир " + cashierName + " отработал " + workingTime + " секунд");
                } else {
                    workingTime = timeForOneGood * buyer.getGoodsInBusket();
                    //System.out.println("Кассир " + cashierName + " отработал " + workingTime + " секунд");
                }

                cashiersWorkingTime.put(this.getCashierName(), workingTime);

                try {
                    Thread.sleep(timeForOneGood * buyer.getGoodsInBusket() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
