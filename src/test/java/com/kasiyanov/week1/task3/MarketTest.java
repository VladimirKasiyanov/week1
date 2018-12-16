package com.kasiyanov.week1.task3;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MarketTest {

    @Test
    public void checkTotalWorkingTime1() {
        int cashierTimeForOneGood = 1;
        int cashiersQuantity = 1;
        ArrayList<Integer> buyersGoodsInBusketList;
        buyersGoodsInBusketList = new ArrayList<>();
        buyersGoodsInBusketList.add(5);
        buyersGoodsInBusketList.add(3);
        buyersGoodsInBusketList.add(4);

        Market market = new Market(cashierTimeForOneGood, cashiersQuantity, buyersGoodsInBusketList);
        market.start();

        try {
            market.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(12L, market.totalWorkingTime());
    }

    @Test
    public void checkTotalWorkingTime2() {
        int cashierTimeForOneGood = 1;
        int cashiersQuantity = 2;
        ArrayList<Integer> buyersGoodsInBusketList;
        buyersGoodsInBusketList = new ArrayList<>();
        buyersGoodsInBusketList.add(10);
        buyersGoodsInBusketList.add(2);
        buyersGoodsInBusketList.add(3);
        buyersGoodsInBusketList.add(3);

        Market market = new Market(cashierTimeForOneGood, cashiersQuantity, buyersGoodsInBusketList);
        market.start();

        try {
            market.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(10L, market.totalWorkingTime());
    }

    @Test
    public void checkTotalWorkingTime3() {
        int cashierTimeForOneGood = 1;
        int cashiersQuantity = 2;
        ArrayList<Integer> buyersGoodsInBusketList;
        buyersGoodsInBusketList = new ArrayList<>();
        buyersGoodsInBusketList.add(2);
        buyersGoodsInBusketList.add(3);
        buyersGoodsInBusketList.add(10);

        Market market = new Market(cashierTimeForOneGood, cashiersQuantity, buyersGoodsInBusketList);
        market.start();

        try {
            market.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(12L, market.totalWorkingTime());
    }

}