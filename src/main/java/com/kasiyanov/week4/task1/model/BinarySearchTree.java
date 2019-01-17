package com.kasiyanov.week4.task1.model;

import com.kasiyanov.week4.task1.strategy.IterationStrategy;
import lombok.Data;

import java.util.Iterator;

@Data
public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> root;
    private String strategyName;
    private IterationStrategy<T> iterationStrategy = IterationStrategy.getInstance();

    public void add(T value) {
        if (isEmpty()) {
            root = new Node<>(value);
        } else {
            add(root, value);
        }
    }

    private void add(Node<T> node, T value) {
        if (value.compareTo(node.getValue()) < 0) {
            if (node.getLeftNode() == null) {
                node.setLeftNode(new Node<>(value));
            } else {
                add(node.getLeftNode(), value);
            }
        } else {
            if (node.getRightNode() == null) {
                node.setRightNode(new Node<>(value));
            } else {
                add(node.getRightNode(), value);
            }
        }
    }

    private boolean isEmpty() {
        return root == null;
    }

    @Override
    public Iterator<T> iterator() {
        iterationStrategy.setStrategyName(strategyName);
        return iterationStrategy.createIterator(root);
    }


}
