package com.kasiyanov.week1.task3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Buyer extends Thread {

    @Getter
    private int goodsInBusket;
}
