package com.akhil.calculator.util;

/**
 * Created by akhil on 7/7/2017.
 */

public enum Calculator {
    STANDARD_CALCULATOR("Standard Calculator"),
    SCIENTIFIC_CALCULATOR("Scientific Calculator");

    private String value;

    Calculator(String value) {

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
