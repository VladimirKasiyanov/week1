package com.kasiyanov.week3.task1.service;

import com.kasiyanov.week3.task1.model.BinarySearchTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeCounterTest {

    @Test
    public void checkNodesCounter() {
        Integer[] nodesValues = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        NodeCounter nodeCounter = new NodeCounter();
        for (Integer nodesValue : nodesValues) {
            binarySearchTree.add(nodesValue);
        }
        assertEquals(9, nodeCounter.countBinarySearchTreeNodes(binarySearchTree));
    }

    @Test
    public void checkCycleNodesCounter() {
        Integer[] nodesValues = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        NodeCounter nodeCounter = new NodeCounter();
        for (Integer nodesValue : nodesValues) {
            binarySearchTree.add(nodesValue);
        }
        assertEquals(9, nodeCounter.cycleCountBinarySearchTreeNodes(binarySearchTree));
    }
}