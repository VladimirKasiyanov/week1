package com.kasiyanov.week4.task1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node<T extends Comparable<T>> {

    private T value;
    private Node<T> leftNode;
    private Node<T> rightNode;

    public Node(T value) {
        this.value = value;
    }
}