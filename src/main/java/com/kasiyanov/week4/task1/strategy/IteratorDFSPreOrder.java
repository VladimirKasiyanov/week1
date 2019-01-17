package com.kasiyanov.week4.task1.strategy;

import com.kasiyanov.week4.task1.model.Node;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class IteratorDFSPreOrder<T extends Comparable<T>> implements IteratorStrategy<T> {

    private Queue<Node<T>> nodes = new LinkedList<>();
    private Deque<Node<T>> rightNodes = new ArrayDeque<>();

    public IteratorDFSPreOrder(Node<T> node) {
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
        if (node.getRightNode() != null) {
            rightNodes.add(node.getRightNode());
        }
        if (node.getLeftNode() != null) {
            nodes.add(node.getLeftNode());
        } else if (!rightNodes.isEmpty()) {
            nodes.add(rightNodes.pollLast());
        }
        return node.getValue();
    }
}
