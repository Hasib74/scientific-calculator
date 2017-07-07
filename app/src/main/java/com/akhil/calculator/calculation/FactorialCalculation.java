package com.akhil.calculator.calculation;

class FactorialCalculation {
    private static final int MAX = 1000;

    private int resultSize;
    private int result[] = new int[MAX];

    FactorialCalculation() {
        resultSize = 1;
    }

    int getResult() {
        return resultSize;
    }

    int[] factorial(int input) {
        result[0] = 1;
        for (int number = 2; number <= input; number++)
            resultSize = multiply(number, resultSize);
        return result;
    }

    private int multiply(int firstNumber, int secondNumber) {
        int carry = 0;

        for (int index = 0; index < secondNumber; index++) {
            int product = result[index] * firstNumber + carry;
            result[index] = product % 10;
            carry = product / 10;
        }

        while (carry != 0) {
            result[secondNumber] = carry % 10;
            carry = carry / 10;
            secondNumber++;
        }
        return secondNumber;
    }
}
