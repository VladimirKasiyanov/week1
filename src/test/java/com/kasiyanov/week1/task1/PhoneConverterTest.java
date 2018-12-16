package com.kasiyanov.week1.task1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PhoneConverterTest {

    @Test
    public void checkStringBufferConverter() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        PhoneConverter phoneConverter = new PhoneConverter();
        String result = phoneConverter.stringBufferConverter(list);
        Assert.assertEquals("(123) 456-7890", result);
    }

    @Test
    public void checkRegexgBufferConverter() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        PhoneConverter phoneConverter = new PhoneConverter();
        String result = phoneConverter.regexConverter(list);
        Assert.assertEquals("(123) 456-7890", result);
    }

}