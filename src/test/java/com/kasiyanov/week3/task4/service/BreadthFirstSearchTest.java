package com.kasiyanov.week3.task4.service;

import com.kasiyanov.week3.task1.model.BinarySearchTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BreadthFirstSearchTest {

    @Test
    public void checkBinarySearchTreePreOrderDFS() {
        Integer[] nodesValues = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        for (Integer nodesValue : nodesValues) {
            binarySearchTree.add(nodesValue);
        }
        assertEquals("831016144713", breadthFirstSearch.binarySearchTreeBFS(binarySearchTree));
    }

}