package com.akhil.calculator.util;

/**
 * Created by akhil on 7/7/2017.
 */

public enum UnitConversion {
    UNIT_CONVERTER("Unit Converter"),
    AREA_CONVERTER("Area Converter"),
    LENGTH_CONVERTER("Length Converter"),
    TEMPERATURE_CONVERTER("Temperature Converter"),
    WEIGHT_CONVERTER("Weight Converter");

    private String value;

    UnitConversion(String value) {

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
