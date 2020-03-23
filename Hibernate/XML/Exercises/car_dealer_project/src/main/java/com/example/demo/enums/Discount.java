package com.example.demo.enums;

import java.util.Random;

public class Discount {
    private static final double[] DISCOUNTS =
            new double[]{1.0, 0.95, 0.90, 0.85, 0.80, 0.70, 0.60, 0.50};

    public static double getRandomDiscount() {
        Random random = new Random();
        int index = random.nextInt(DISCOUNTS.length);
        return DISCOUNTS[index];
    }
}
