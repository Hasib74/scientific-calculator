package com.example.akhil.calculator;

/**
 * Created by akhil on 12/18/2016.
 */

public enum HTML_CONSTANTS {
    DIVISION("&divide;"),
    INVERSE_SIN("sin<sup>-1</sup>"),
    INVERSE_COS("cos<sup>-1</sup>"),
    INVERSE_TAN("tan<sup>-1</sup>"),
    EXPONENTIAL("e<sup>x</sup>"),
    TEN_POWER_X("10<sup>x</sup>"),
    CUBE_SQUARE("3&radic;"),
    CUBE_ROOT("x<sup>3</sup>"),
    Y_POWER_X("Y<sup>x</sup>"),
    SQUARE_ROOT("&radic;"),
    X_SQUARE("x<sup>2</sup>"),
    PI("&pi;");

    private String value;

    HTML_CONSTANTS(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
