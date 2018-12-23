package com.kasiyanov.week2.task1;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BracketCheckerTest {

    @Test
    public void checkCorrectBracketOrder() {
        String lines[] = {"()", "(){}[]", "{[]}", ""};
        BracketChecker bracketChecker = new BracketChecker();
        boolean isCorrectBracketOrder;

        for (String line : lines) {
            isCorrectBracketOrder = bracketChecker.checkBracketOrder(line);
            assertTrue(isCorrectBracketOrder);
        }
    }

    @Test
    public void checkIncorrectBracketOrder() {
        String lines[] = {"(]", "([)]"};
        BracketChecker bracketChecker = new BracketChecker();
        boolean isCorrectBracetOrder;

        for (String line : lines) {
            isCorrectBracetOrder = bracketChecker.checkBracketOrder(line);
            assertFalse(isCorrectBracetOrder);
        }
    }

}