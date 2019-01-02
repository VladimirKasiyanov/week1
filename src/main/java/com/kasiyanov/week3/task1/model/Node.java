package com.kasiyanov.week3.task1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node<T extends Comparable<T>> {

    private T value;
    private Node leftNode;
    private Node rightNode;

    public Node(T value) {
        this.value = value;
    }
}
