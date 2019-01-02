package com.kasiyanov.week3.task3.service;

import com.kasiyanov.week3.task1.model.BinarySearchTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DepthFirstSearchTest {

    @Test
    public void checkBinarySearchTreePreOrderDFS() {
        Integer[] nodesValues = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        for (Integer nodesValue : nodesValues) {
            binarySearchTree.add(nodesValue);
        }
        assertEquals("831647101413", depthFirstSearch.binarySearchTreePreOrderDFS(binarySearchTree));
    }

    @Test
    public void checkBinarySearchTreeInOrderDFS() {
        Integer[] nodesValues = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        for (Integer nodesValue : nodesValues) {
            binarySearchTree.add(nodesValue);
        }
        assertEquals("134678101314", depthFirstSearch.binarySearchTreeInOrderDFS(binarySearchTree));
    }

    @Test
    public void checkBinarySearchTreePostOrderDFS() {
        Integer[] nodesValues = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        for (Integer nodesValue : nodesValues) {
            binarySearchTree.add(nodesValue);
        }
        assertEquals("147631314108", depthFirstSearch.binarySearchTreePostOrderDFS(binarySearchTree));
    }

}