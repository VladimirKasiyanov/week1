package com.kasiyanov.week1.task2;

public class Clerk {

    private int quantityOfTwentyFifeBanknotes;
    private int quantityOfFiftyBanknotes;

    public boolean returnChange(Banknote banknote) {
        boolean hasChange = false;
        switch (banknote) {
            case TWENTYFIVE:
                quantityOfTwentyFifeBanknotes++;
                hasChange = true;
                break;
            case FIFTY:
                if (quantityOfTwentyFifeBanknotes > 0) {
                    quantityOfTwentyFifeBanknotes--;
                    hasChange = true;
                }
                break;
            case ONEHUNDRED:
                if (quantityOfFiftyBanknotes > 0 && quantityOfTwentyFifeBanknotes > 0) {
                    quantityOfTwentyFifeBanknotes--;
                    quantityOfFiftyBanknotes--;
                    hasChange = true;
                } else if (quantityOfTwentyFifeBanknotes >= 3) {
                    quantityOfTwentyFifeBanknotes = quantityOfTwentyFifeBanknotes - 3;
                    hasChange = true;
                }
                break;
        }
        return hasChange;
    }
}
