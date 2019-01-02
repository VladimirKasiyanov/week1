package com.kasiyanov.week3.task4.service;

import com.kasiyanov.week3.task1.model.BinarySearchTree;

public class BreadthFirstSearch {

    public String binarySearchTreeBFS(BinarySearchTree binarySearchTree) {
        StringBuilder stringBuilder = new StringBuilder();
        return binarySearchTree.levelOrderBFS(stringBuilder).toString();
    }
}
