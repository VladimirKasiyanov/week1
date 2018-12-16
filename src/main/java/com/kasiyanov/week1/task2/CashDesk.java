package com.kasiyanov.week1.task2;

import java.util.List;

public class CashDesk {

    Clerk clerk = new Clerk();

    public boolean ticketSale(List<Buyer> buyers) {
        boolean sold = true;
        for (Buyer buyer : buyers) {
            sold = clerk.returnChange(buyer.getBanknote());
            if (!sold) {
                break;
            }
        }
        return sold;
    }
}
