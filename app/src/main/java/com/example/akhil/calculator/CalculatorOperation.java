package com.example.akhil.calculator;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.Function;
import com.fathzer.soft.javaluator.Parameters;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by akhil on 12/18/2016.
 */

public class CalculatorOperation {

    final Function sqrt = new Function("sqrt", 1);
    final Function factorial = new Function("!", 1);
    final Function cubeRoot = new Function("crt", 1);
    final Function combination = new Function("combination", 2);
    final Function permutation = new Function("permutation", 2);
    Parameters params;
    DoubleEvaluator evaluator;
    private double currentSum = 0;
    private boolean isRadians = false;

    public CalculatorOperation() {
        addFunctions();
        evaluator = new DoubleEvaluator(params) {
            @Override
            protected Double evaluate(Function function, Iterator arguments, Object evaluationContext) {
                if (function == sqrt)
                    return Math.sqrt((Double) arguments.next());
                else if (function == cubeRoot) {
                    return Math.cbrt((Double) arguments.next());
                } else if (function == combination) {
                    List<Double> saveValue = new ArrayList<>();
                    while (arguments.hasNext()) {
                        saveValue.add((double)arguments.next());
                    }
                    int firstArgument = saveValue.get(0).intValue();
                    int secondArgument = saveValue.get(1).intValue();
                    return combination(firstArgument, secondArgument).doubleValue();
                } else if (function == permutation) {
                    List<Double> saveValue = new ArrayList<>();
                    while (arguments.hasNext()) {
                        saveValue.add((double)arguments.next());
                    }
                    int firstArgument = saveValue.get(0).intValue();
                    int secondArgument = saveValue.get(1).intValue();
                    return permutation(firstArgument, secondArgument).doubleValue();
                } else if (function == factorial) {
                    double result = 1;
                    double num = (Double) arguments.next();
                    for (int number = 2; number <= num; number++) {
                        result = result * number;
                    }
                    return result;
                } else
                    return super.evaluate(function, arguments, evaluationContext);
            }
        };
    }

    public void addFunctions() {
        params = DoubleEvaluator.getDefaultParameters();
        params.add(sqrt);
        params.add(factorial);
        params.add(cubeRoot);
        params.add(combination);
        params.add(permutation);
    }

    private BigInteger permutation(int firstInput, int secondInput) {
        BigInteger result = BigInteger.ONE;
        for (int k = 0; k < firstInput - secondInput; k++) {
            result = result.multiply(BigInteger.valueOf(firstInput - k));
        }
        return result;
    }

    BigInteger combination(int firstInput, int secondInput) {
        BigInteger result = BigInteger.ONE;
        secondInput = Math.min(secondInput, firstInput - secondInput);
        for (int k = 0; k < secondInput; k++) {
            result = result.multiply(BigInteger.valueOf(firstInput - k))
                    .divide(BigInteger.valueOf(k + 1));
        }
        return result;
    }


    public String getResult(String expressionUsedForParsing) {
        String currentDisplay;
        try {
            System.out.println("Displayed Output " + expressionUsedForParsing);
            currentSum = evaluator.evaluate(fixExpression(expressionUsedForParsing));
            currentSum = convertToRadians(currentSum);
            currentDisplay = String.valueOf(currentSum);
        } catch (Exception e) {
            currentDisplay = "Error";
        }
        return currentDisplay;
    }

    public double convertToRadians(double sum) {
        double newSum = sum;
        if (isRadians == true)
            newSum = Math.toRadians(sum);
        return newSum;
    }

    public String fixExpression(String expression) {
        int openParenthesis = 0;
        int closeParenthesis = 0;
        char openParenthesisSymbol = '(';
        char closeParenthesisSymbol = ')';
        String parsedExpression = expression;
        for (int index = 0; index < expression.length(); index++) {
            if (expression.charAt(index) == openParenthesisSymbol)
                openParenthesis++;
            else if (expression.charAt(index) == closeParenthesisSymbol)
                closeParenthesis++;
        }
        while (openParenthesis > 0) {
            parsedExpression += closeParenthesisSymbol;
            openParenthesis--;
        }
        while (closeParenthesis > 0) {
            parsedExpression = openParenthesisSymbol + parsedExpression;
            closeParenthesis--;
        }
        parsedExpression = parenthesisMultiplication(parsedExpression);
        return parsedExpression;
    }

    public String parenthesisMultiplication(String input) {
        String fixed = "";
        for (int position = 0; position < input.length(); position++) {
            fixed += input.charAt(position);
            if (position == input.length() - 1)
                continue;
            if (input.charAt(position) == ')' && input.charAt(position + 1) == '(')
                fixed += '*';
            if (input.charAt(position) == '(' && input.charAt(position + 1) == ')')
                fixed += '1';
        }
        return fixed;
    }
}
