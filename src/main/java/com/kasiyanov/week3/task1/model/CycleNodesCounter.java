package com.kasiyanov.week3.task1.model;

import java.util.Stack;

public class CycleNodesCounter {

    public int countNodes(BinarySearchTree binarySearchTree) {
        Node node = binarySearchTree.getRoot();
        Stack<Node> nodeStack = new Stack<>();
        int count = 0;
        do {
            count++;
            Node leftNode = node.getLeftNode();
            Node rightNode = node.getRightNode();
            if (leftNode != null) {
                node = leftNode;
                if (rightNode != null) {
                    nodeStack.push(rightNode);
                }
            } else if (rightNode != null) {
                node = rightNode;
            } else {
                node = nodeStack.empty() ? null : nodeStack.pop();
            }
        } while (node != null);
        return count;
    }
}
