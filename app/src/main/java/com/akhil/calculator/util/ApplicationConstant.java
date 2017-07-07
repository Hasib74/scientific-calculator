package com.akhil.calculator.util;

/**
 * Created by akhil on 7/6/2017.
 */

public enum ApplicationConstant {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    ZERO(0);

    private int value;

    ApplicationConstant(int value) {

        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
