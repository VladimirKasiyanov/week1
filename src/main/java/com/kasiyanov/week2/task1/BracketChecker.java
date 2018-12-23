package com.kasiyanov.week2.task1;

public class BracketChecker {

    public boolean checkBracketOrder(String line) {
        boolean result = true;
        int stackSize = line.length();
        Stack stack = new Stack(stackSize);

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);

            switch (currentChar) {
                case '(':
                case '{':
                case '[':
                    stack.push(currentChar);
                    break;
                case ')':
                case '}':
                case ']':
                    if (!stack.isEmpty()) {
                        char previousChar = stack.pop();
                        if ((currentChar == ')' && previousChar != '(') ||
                                (currentChar == '}' && previousChar != '{') ||
                                (currentChar == ']' && previousChar != '[')) {
                            result = false;
                        }
                    }
                    break;
                default:
                    break;
            }

            if (!result) {
                break;
            }
        }

        if (!stack.isEmpty()) {
            result = false;
        }

        return result;
    }
}
