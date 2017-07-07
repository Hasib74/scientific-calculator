package com.akhil.calculator.calculation;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.Function;
import com.fathzer.soft.javaluator.Parameters;

import java.math.BigInteger;
import java.util.Iterator;

class ExtendedDoubleEvaluation extends DoubleEvaluator {
    private static final Function SQRT = new Function("sqrt", 1);
    private static final Function CUBE_ROOT = new Function("cbrt", 1);
    private static final Function SIN_D = new Function("asind", 1);
    private static final Function COS_D = new Function("acosd", 1);
    private static final Function TAN_D = new Function("atand", 1);
    private static final Function COMBINATION = new Function("combination", 2);
    private static final Parameters PARAMS;
    private static final Function PERMUTATION = new Function("permutation", 2);

    static {
        PARAMS = DoubleEvaluator.getDefaultParameters();
        PARAMS.add(SQRT);
        PARAMS.add(CUBE_ROOT);
        PARAMS.add(SIN_D);
        PARAMS.add(COS_D);
        PARAMS.add(TAN_D);
        PARAMS.add(COMBINATION);
        PARAMS.add(PERMUTATION);
    }

    ExtendedDoubleEvaluation() {
        super(PARAMS);
    }

    @Override
    public Double evaluate(Function function, Iterator<Double> arguments, Object evaluationContext) {
        if (function == SQRT) {
            return Math.sqrt(arguments.next());
        } else if (function == CUBE_ROOT) {
            return Math.cbrt(arguments.next());
        } else if (function == SIN_D) {
            return Math.toDegrees(Math.asin(arguments.next()));
        } else if (function == COS_D) {
            return Math.toDegrees(Math.acos(arguments.next()));
        } else if (function == TAN_D) {
            return Math.toDegrees(Math.atan(arguments.next()));
        } else if (function == PERMUTATION) {
            return permutation(arguments.next().intValue(), arguments.next().intValue());
        } else if (function == COMBINATION) {
            return combination(arguments.next().intValue(), arguments.next().intValue());
        } else {
            return super.evaluate(function, arguments, evaluationContext);
        }
    }

    private double permutation(int firstInput, int secondInput) {
        BigInteger result = BigInteger.ONE;
        for (int k = 0; k < firstInput - secondInput; k++) {
            result = result.multiply(BigInteger.valueOf(firstInput - k));
        }
        return result.doubleValue();
    }

    private double combination(int firstInput, int secondInput) {
        BigInteger result = BigInteger.ONE;
        secondInput = Math.min(secondInput, firstInput - secondInput);
        for (int k = 0; k < secondInput; k++) {
            result = result.multiply(BigInteger.valueOf(firstInput - k))
                    .divide(BigInteger.valueOf(k + 1));
        }
        return result.doubleValue();
    }
}
