package com.kasiyanov.week4.task1.strategy;

import com.kasiyanov.week4.task1.model.Node;
import lombok.Data;

import java.util.Iterator;

@Data
public final class IterationStrategy<T extends Comparable<T>> {

    private static final IterationStrategy INSTANCE = new IterationStrategy();

    private IteratorStrategy<T> iteratorStrategy;
    private String strategyName;

    private IterationStrategy() {
    }

    public Iterator<T> createIterator(Node<T> node) {
        if (strategyName.equals("BFS")) {
            iteratorStrategy = new IteratorBFS<>(node);
        } else if (strategyName.equals("DFSPreOrder")) {
            iteratorStrategy = new IteratorDFSPreOrder<>(node);
        }
        return iteratorStrategy;
    }

    public static IterationStrategy getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
