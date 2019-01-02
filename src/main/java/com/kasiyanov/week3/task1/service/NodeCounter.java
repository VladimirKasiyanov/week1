package com.kasiyanov.week3.task1.service;

import com.kasiyanov.week3.task1.model.BinarySearchTree;
import com.kasiyanov.week3.task1.model.CycleNodesCounter;

public class NodeCounter {

    public int countBinarySearchTreeNodes(BinarySearchTree binarySearchTree) {
        return binarySearchTree.countNodes();
    }

    public int cycleCountBinarySearchTreeNodes(BinarySearchTree binarySearchTree) {
        CycleNodesCounter counter = new CycleNodesCounter();
        return counter.countNodes(binarySearchTree);
    }
}