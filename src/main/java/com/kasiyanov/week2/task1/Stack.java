package com.kasiyanov.week2.task1;

public class Stack {

    private int stackSize;
    private int top;
    private char[] stackArray;

    public Stack(int stackSize) {
        this.stackSize = stackSize;
        stackArray = new char[stackSize];
        top = -1;
    }

    public void push(char currentChar) {
        stackArray[++top] = currentChar;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

}
