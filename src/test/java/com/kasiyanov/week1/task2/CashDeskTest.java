package com.kasiyanov.week1.task2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CashDeskTest {

    @Test
    public void checkPossibilityOfSale() {
        List<Buyer> firstBuyersList = new ArrayList<>();
        firstBuyersList.add(new Buyer(Banknote.TWENTYFIVE));
        firstBuyersList.add(new Buyer(Banknote.TWENTYFIVE));
        firstBuyersList.add(new Buyer(Banknote.FIFTY));

        CashDesk cashDesk = new CashDesk();
        boolean sold = cashDesk.ticketSale(firstBuyersList);
        Assert.assertTrue(sold);

        List<Buyer> secondBuyersList = new ArrayList<>();
        secondBuyersList.add(new Buyer(Banknote.TWENTYFIVE));
        secondBuyersList.add(new Buyer(Banknote.ONEHUNDRED));

        boolean sold2 = cashDesk.ticketSale(secondBuyersList);
        Assert.assertFalse(sold2);
    }
}