package com.kasiyanov.week3.task3.service;

import com.kasiyanov.week3.task1.model.BinarySearchTree;

public class DepthFirstSearch {

    public String binarySearchTreePreOrderDFS(BinarySearchTree binarySearchTree) {
        StringBuilder stringBuilder = new StringBuilder();
        return binarySearchTree.preorderDepthFirstSearch(stringBuilder).toString();
    }

    public String binarySearchTreeInOrderDFS(BinarySearchTree binarySearchTree) {
        StringBuilder stringBuilder = new StringBuilder();
        return binarySearchTree.inorderDepthFirstSearch(stringBuilder).toString();
    }

    public String binarySearchTreePostOrderDFS(BinarySearchTree binarySearchTree) {
        StringBuilder stringBuilder = new StringBuilder();
        return binarySearchTree.postorderDepthFirstSearch(stringBuilder).toString();
    }
}
