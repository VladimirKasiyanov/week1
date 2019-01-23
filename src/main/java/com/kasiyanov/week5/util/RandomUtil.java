package com.kasiyanov.week5.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RandomUtil {

    private static final Random RANDOM = new Random();

    public static int generate(int max) {
        return RANDOM.nextInt(max);
    }

}
