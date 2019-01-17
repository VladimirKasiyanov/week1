package com.kasiyanov.week4.task1.strategy;

import com.kasiyanov.week4.task1.model.BinarySearchTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinarySearchTreeTest {

    private Integer[] nodesValues = {8, 3, 10, 1, 6, 14, 4, 7, 13};
    private BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

    @Test
    public void checkIterationStrategyDFSPreOrder() {
        createBinarySearchTreeTest();
        List<Integer> actualList = new ArrayList<>();
        List<Integer> expectedListDFSPreOrder = Arrays.asList(8, 3, 1, 6, 4, 7, 10, 14, 13);
        binarySearchTree.setStrategyName("DFSPreOrder");
        Iterator<Integer> iterator = binarySearchTree.iterator();
        while (iterator.hasNext()) {
            actualList.add(iterator.next());
        }
        assertEquals(expectedListDFSPreOrder, actualList);
    }

    @Test
    public void checkIterationStrategyBFS() {
        createBinarySearchTreeTest();
        List<Integer> actualList = new ArrayList<>();
        List<Integer> expectedListBFS = Arrays.asList(8, 3, 10, 1, 6, 14, 4, 7, 13);
        binarySearchTree.setStrategyName("BFS");
        Iterator<Integer> iterator = binarySearchTree.iterator();
        while (iterator.hasNext()) {
            actualList.add(iterator.next());
        }
        assertEquals(expectedListBFS, actualList);
    }

    private void createBinarySearchTreeTest() {
        Arrays.asList(nodesValues).forEach(nodesValue -> binarySearchTree.add(nodesValue));
    }
}