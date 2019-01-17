package com.kasiyanov.week4.task1.strategy;

import com.kasiyanov.week4.task1.model.Node;

import java.util.LinkedList;
import java.util.Queue;

public class IteratorBFS<T extends Comparable<T>> implements IteratorStrategy<T> {

    private Queue<Node<T>> nodes = new LinkedList<>();

    public IteratorBFS(Node<T> node) {
        createNodeList(node);
    }

    private void createNodeList(Node<T> node) {
        if (node != null) {
            nodes.add(node);
        }
    }

    @Override
    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    @Override
    public T next() {
        Node<T> node = nodes.remove();
        if (node.getLeftNode() != null) {
            nodes.add(node.getLeftNode());
        }
        if (node.getRightNode() != null) {
            nodes.add(node.getRightNode());
        }
        return node.getValue();
    }
}
