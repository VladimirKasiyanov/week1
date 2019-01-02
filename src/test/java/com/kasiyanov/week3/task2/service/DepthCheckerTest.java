package com.kasiyanov.week3.task2.service;

import com.kasiyanov.week3.task1.model.BinarySearchTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepthCheckerTest {

    @Test
    public void checkBinarySearchTreeDepth() {
        Integer[] nodesValues = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        DepthChecker depthChecker = new DepthChecker();
        for (Integer nodesValue : nodesValues) {
            binarySearchTree.add(nodesValue);
        }
        assertEquals(4, depthChecker.binarySearchTreeDepth(binarySearchTree));
    }

}