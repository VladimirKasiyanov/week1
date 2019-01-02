package com.kasiyanov.week3.task1.model;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

@Data
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public void add(T value) {
        if (isEmpty()) {
            root = new Node<>(value);
        } else {
            add(root, value);
        }
    }

    private void add(Node<T> node, T value) {
        if (value.compareTo(node.getValue()) < 0) {
            if (node.getLeftNode() == null) {
                node.setLeftNode(new Node<>(value));
            } else {
                add(node.getLeftNode(), value);
            }
        } else {
            if (node.getRightNode() == null) {
                node.setRightNode(new Node<>(value));
            } else {
                add(node.getRightNode(), value);
            }
        }
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node node) {
        if (node == null) {
            return 0;
        } else {
            int count = 1;
            count += countNodes(node.getLeftNode());
            count += countNodes(node.getRightNode());
            return count;
        }
    }

    public int depth() {
        return depth(root);
    }

    private int depth(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(node.getLeftNode()), depth(node.getRightNode()));
        }
    }

    public StringBuilder preorderDepthFirstSearch(StringBuilder stringBuilder) {
        preorderDepthFirstSearch(root, stringBuilder);
        return stringBuilder;
    }

    private void preorderDepthFirstSearch(Node node, StringBuilder stringBuilder) {
        if (node != null) {
            stringBuilder.append(node.getValue());
            preorderDepthFirstSearch(node.getLeftNode(), stringBuilder);
            preorderDepthFirstSearch(node.getRightNode(), stringBuilder);
        }
    }

    public StringBuilder inorderDepthFirstSearch(StringBuilder stringBuilder) {
        inorderDepthFirstSearch(root, stringBuilder);
        return stringBuilder;
    }

    private void inorderDepthFirstSearch(Node node, StringBuilder stringBuilder) {
        if (node != null) {
            inorderDepthFirstSearch(node.getLeftNode(), stringBuilder);
            stringBuilder.append(node.getValue());
            inorderDepthFirstSearch(node.getRightNode(), stringBuilder);
        }
    }

    public StringBuilder postorderDepthFirstSearch(StringBuilder stringBuilder) {
        postorderDepthFirstSearch(root, stringBuilder);
        return stringBuilder;
    }

    private void postorderDepthFirstSearch(Node node, StringBuilder stringBuilder) {
        if (node != null) {
            postorderDepthFirstSearch(node.getLeftNode(), stringBuilder);
            postorderDepthFirstSearch(node.getRightNode(), stringBuilder);
            stringBuilder.append(node.getValue());
        }
    }

    public StringBuilder levelOrderBFS(StringBuilder stringBuilder) {
        levelOrderBFS(root, stringBuilder);
        return stringBuilder;
    }

    public void levelOrderBFS(Node node, StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(node);

        while (!nodes.isEmpty()) {
            node = nodes.remove();
            stringBuilder.append(node.getValue());
            if (node.getLeftNode() != null) {
                nodes.add(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                nodes.add(node.getRightNode());
            }
        }
    }

    private boolean isEmpty() {
        return root == null;
    }
}
