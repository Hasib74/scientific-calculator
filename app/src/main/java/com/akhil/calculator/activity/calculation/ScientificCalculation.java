package com.akhil.calculator.activity.calculation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.akhil.calculator.BaseActivity;
import com.akhil.calculator.R;
import com.akhil.calculator.util.ApplicationConstant;
import com.akhil.calculator.util.Calculator;

public class ScientificCalculation extends BaseActivity implements View.OnClickListener {
    private static final String RESULT_TOO_BIG = "Result too big!";
    private static final String INVALID = "Invalid!!";
    private static final String HYPHEN = "-";
    private static final String INFINITY = "infinity";
    private static final String INVALID_EXPRESSION = "Invalid Expression";
    private static final String ASIN = "asin";
    private static final String ASIND = "asind";
    private static final String SINH = "sinh";
    private static final String COS = "cos";
    private static final String ACOS = "acos";
    private static final String ACOSD = "acosd";
    private static final String COSH = "cosh";
    private static final String TAN = "tan";
    private static final String ATAN = "atan";
    private static final String ATAND = "atand";
    private static final String TANH = "tanh";
    private static final String CBRT = "cbrt";
    private static final String POWER = "^";
    private static final String EXPONENTIAL_POWER = "e^";
    private static final String SQRT = "sqrt(";
    private static final String CUBE_ROOT = "cbrt(";
    private static final String INVERSE = "1/(";
    private static final String POWER_THREE = ")^3";
    private static final String POWER_TWO = ")^2";
    private static final String B_POWER = ")^";
    private static final String TEN_RAISED_TO_THE_POWER_B = "10^(";
    private static final String EXPONENT_RAISED_TO_THE_POWER_B = "e^(";
    private static final String NATURAL_LOG_B = "ln(";
    private static final String LOG_B = "log(";
    private static final String MOD = ")%";
    private static final String EXPONENT = "E";
    private static final String ASIND_B = "asind(";
    private static final String SIN_B = "sin(";
    private static final String ASIN_B = "asin(";
    private static final String SINH_B = "sinh(";
    private static final String COS_B = "cos(";
    private static final String ACOSD_B = "acosd(";
    private static final String COSH_B = "cosh(";
    private static final String ACOS_B = "acos(";
    private static final String TAN_B = "tan(";
    private static final String ATAND_B = "atand(";
    private static final String TANH_B = "tanh(";
    private static final String ATAN_B = "atan(";
    private static final String ZERO_DECIMAL = "0.0";
    private EditText firstEditText, secondEditText;
    private int count = 0;
    private String expression = "";
    private Button mode, toggle, square, xpowy, log, sin, cos, tan, sqrt, fact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(Calculator.SCIENTIFIC_CALCULATOR.getValue());
        setContentView(R.layout.content_scientific_calculator);

        firstEditText = (EditText) findViewById(R.id.first_edit_text);
        secondEditText = (EditText) findViewById(R.id.second_edit_text);
        mode = (Button) findViewById(R.id.mode);
        toggle = (Button) findViewById(R.id.toggle);
        square = (Button) findViewById(R.id.square);
        xpowy = (Button) findViewById(R.id.x_power_y);
        log = (Button) findViewById(R.id.log);
        sin = (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        tan = (Button) findViewById(R.id.tan);
        sqrt = (Button) findViewById(R.id.sqrt);
        fact = (Button) findViewById(R.id.factorial);

        secondEditText.setText(getResources().getString(R.string.no_text).trim());
        mode.setTag(1);
        toggle.setTag(1);
    }

    public void onClick(View v) {
        int toggleMode = (int) toggle.getTag();
        int angleMode = ((int) mode.getTag());
        if (secondEditText.getText().toString().equals(INVALID_EXPRESSION)
                || secondEditText.getText().toString().equals(RESULT_TOO_BIG)
                || secondEditText.getText().toString().equalsIgnoreCase(INFINITY))
            secondEditText.setText(getResources().getString(R.string.no_text).trim());
        switch (v.getId()) {

            case R.id.toggle:
                if (toggleMode == 1) {
                    toggle.setTag(2);
                    square.setText(R.string.cube);
                    xpowy.setText(R.string.tenpow);
                    log.setText(R.string.naturalLog);
                    sin.setText(R.string.sininv);
                    cos.setText(R.string.cosinv);
                    tan.setText(R.string.taninv);
                    sqrt.setText(R.string.cuberoot);
                    fact.setText(R.string.Mod);
                } else if (toggleMode == 2) {
                    toggle.setTag(3);
                    square.setText(R.string.square);
                    xpowy.setText(R.string.epown);
                    log.setText(R.string.log);
                    sin.setText(R.string.hyperbolicSine);
                    cos.setText(R.string.hyperbolicCosine);
                    tan.setText(R.string.hyperbolicTan);
                    sqrt.setText(R.string.inverse);
                    fact.setText(R.string.factorial);
                } else if (toggleMode == 3) {
                    toggle.setTag(1);
                    sin.setText(R.string.sin);
                    cos.setText(R.string.cos);
                    tan.setText(R.string.tan);
                    sqrt.setText(R.string.sqrt);
                    xpowy.setText(R.string.xpown);
                }
                break;

            case R.id.mode:
                if (angleMode == 1) {
                    mode.setTag(2);
                    mode.setText(R.string.mode2);
                } else {
                    mode.setTag(1);
                    mode.setText(R.string.mode1);
                }
                break;

            case R.id.number_0:
                secondEditText.setText(secondEditText.getText().append(String.valueOf(ApplicationConstant.ZERO.getValue())));
                break;

            case R.id.number_1:
                secondEditText.setText(secondEditText.getText().append(String.valueOf(ApplicationConstant.ONE.getValue())));
                break;

            case R.id.number_2:
                secondEditText.setText(secondEditText.getText().append(String.valueOf(ApplicationConstant.TWO.getValue())));
                break;

            case R.id.number_3:
                secondEditText.setText(secondEditText.getText().append(String.valueOf(ApplicationConstant.THREE.getValue())));
                break;


            case R.id.number_4:
                secondEditText.setText(secondEditText.getText().append(String.valueOf(ApplicationConstant.FOUR.getValue())));
                break;

            case R.id.number_5:
                secondEditText.setText(secondEditText.getText().append(String.valueOf(ApplicationConstant.FIVE.getValue())));
                break;

            case R.id.number_6:
                secondEditText.setText(secondEditText.getText().append(String.valueOf(ApplicationConstant.SIX.getValue())));
                break;

            case R.id.number_7:
                secondEditText.setText(secondEditText.getText().append(String.valueOf(ApplicationConstant.SEVEN.getValue())));
                break;

            case R.id.number_8:
                secondEditText.setText(secondEditText.getText().append(String.valueOf(ApplicationConstant.EIGHT.getValue())));
                break;

            case R.id.number_9:
                secondEditText.setText(secondEditText.getText().append(String.valueOf(ApplicationConstant.NINE.getValue())));
                break;

            case R.id.pi:
                secondEditText.setText(secondEditText.getText().append(getResources().getString(R.string.pi)));
                break;

            case R.id.dot:
                if (count == 0 && secondEditText.length() != 0) {
                    secondEditText.setText(secondEditText.getText().append(getResources().getString(R.string.dot)));
                    count++;
                }
                break;

            case R.id.clear:
                firstEditText.setText(getResources().getString(R.string.no_text).trim());
                secondEditText.setText(getResources().getString(R.string.no_text).trim());
                count = 0;
                expression = getResources().getString(R.string.no_text).trim();
                break;

            case R.id.backSpace:
                String text = secondEditText.getText().toString();
                if (text.length() > 0) {
                    if (text.endsWith(getResources().getString(R.string.dot))) {
                        count = 0;
                    }
                    String newText = text.substring(0, text.length() - 1);
                    if (text.endsWith(getResources().getString(R.string.close_bracket))) {
                        char[] a = text.toCharArray();
                        int pos = a.length - 2;
                        int counter = 1;
                        for (int i = a.length - 2; i >= 0; i--) {
                            if (a[i] == getResources().getString(R.string.close_bracket).charAt(0)) {
                                counter++;
                            } else if (a[i] == getResources().getString(R.string.open_bracket).charAt(0)) {
                                counter--;
                            } else if (a[i] == getResources().getString(R.string.dot).charAt(0)) {
                                count = 0;
                            }
                            if (counter == 0) {
                                pos = i;
                                break;
                            }
                        }
                        newText = text.substring(0, pos);
                    }
                    if (newText.equals(getResources().getString(R.string.minus))
                            || newText.endsWith(getResources().getString(R.string.sqrt))
                            || newText.endsWith(getResources().getString(R.string.log))
                            || newText.endsWith(getResources().getString(R.string.natural_log))
                            || newText.endsWith(getResources().getString(R.string.sin))
                            || newText.endsWith(ASIN)
                            || newText.endsWith(ASIND)
                            || newText.endsWith(SINH)
                            || newText.endsWith(COS)
                            || newText.endsWith(ACOS)
                            || newText.endsWith(ACOSD)
                            || newText.endsWith(COSH)
                            || newText.endsWith(TAN)
                            || newText.endsWith(ATAN)
                            || newText.endsWith(ATAND)
                            || newText.endsWith(TANH)
                            || newText.endsWith(CBRT)) {
                        newText = getResources().getString(R.string.no_text).trim();
                    } else if (newText.endsWith(POWER) || newText.endsWith(getResources().getString(R.string.division).trim()))
                        newText = newText.substring(0, newText.length() - 1);
                    else if (newText.endsWith(getResources().getString(R.string.pi).trim()) || newText.endsWith(EXPONENTIAL_POWER))
                        newText = newText.substring(0, newText.length() - 2);
                    secondEditText.setText(newText);
                }
                break;

            case R.id.plus:
                operationClicked(getResources().getString(R.string.plus).trim());
                break;

            case R.id.minus:
                operationClicked(getResources().getString(R.string.subtraction).trim());
                break;

            case R.id.divide:
                operationClicked(getResources().getString(R.string.division).trim());
                break;

            case R.id.multiply:
                operationClicked(getResources().getString(R.string.asterisk).trim());
                break;

            case R.id.sqrt:
                if (secondEditText.length() != 0) {
                    text = secondEditText.getText().toString();
                    toggleMode = (int) toggle.getTag();
                    if (toggleMode == 1)
                        secondEditText.setText(SQRT + text + getResources().getString(R.string.close_bracket).trim());
                    else if (toggleMode == 2)
                        secondEditText.setText(CUBE_ROOT + text + getResources().getString(R.string.close_bracket).trim());
                    else
                        secondEditText.setText(INVERSE + text + getResources().getString(R.string.close_bracket).trim());
                }
                break;

            case R.id.square:
                if (secondEditText.length() != 0) {
                    text = secondEditText.getText().toString();
                    if (toggleMode == 2)
                        secondEditText.setText(getResources().getString(R.string.open_bracket).trim() + text + POWER_THREE);
                    else
                        secondEditText.setText(getResources().getString(R.string.open_bracket).trim() + text + POWER_TWO);
                }
                break;

            case R.id.x_power_y:
                if (secondEditText.length() != 0) {
                    text = secondEditText.getText().toString();
                    if (toggleMode == 1)
                        secondEditText.setText(getResources().getString(R.string.open_bracket).trim() + text + B_POWER);
                    else if (toggleMode == 2)
                        secondEditText.setText(TEN_RAISED_TO_THE_POWER_B + text + getResources().getString(R.string.close_bracket).trim());
                    else
                        secondEditText.setText(EXPONENT_RAISED_TO_THE_POWER_B + text + getResources().getString(R.string.close_bracket).trim());
                }
                break;

            case R.id.log:
                if (secondEditText.length() != 0) {
                    text = secondEditText.getText().toString();
                    if (toggleMode == 2)
                        secondEditText.setText(NATURAL_LOG_B + text + getResources().getString(R.string.close_bracket).trim());
                    else
                        secondEditText.setText(LOG_B + text + getResources().getString(R.string.close_bracket).trim());
                }
                break;

            case R.id.factorial:
                if (secondEditText.length() != 0) {
                    text = secondEditText.getText().toString();
                    if (toggleMode == 2) {
                        firstEditText.setText(getResources().getString(R.string.open_bracket).trim() + text + MOD);
                        secondEditText.setText(getResources().getString(R.string.no_text).trim());
                    } else {
                        String res = getResources().getString(R.string.no_text).trim();
                        try {
                            FactorialCalculation cf = new FactorialCalculation();
                            int[] arr = cf.factorial((int) Double.parseDouble(String.valueOf(new ExtendedDoubleEvaluation().evaluate(text))));
                            int res_size = cf.getResult();
                            if (res_size > 20) {
                                for (int i = res_size - 1; i >= res_size - 20; i--) {
                                    if (i == res_size - 2)
                                        res += getResources().getString(R.string.dot).trim();
                                    res += arr[i];
                                }
                                res += EXPONENT + (res_size - 1);
                            } else {
                                for (int i = res_size - 1; i >= 0; i--) {
                                    res += arr[i];
                                }
                            }
                            secondEditText.setText(res);
                        } catch (Exception e) {
                            if (e.toString().contains(ArrayIndexOutOfBoundsException.class.getSimpleName())) {
                                secondEditText.setText(RESULT_TOO_BIG);
                            } else
                                secondEditText.setText(INVALID);
                            e.printStackTrace();
                        }
                    }
                }
                break;

            case R.id.sin:
                if (secondEditText.length() != 0) {
                    text = secondEditText.getText().toString();
                    if (angleMode == 1) {
                        double angle = Math.toRadians(new ExtendedDoubleEvaluation().evaluate(text));
                        if (toggleMode == 1)
                            secondEditText.setText(SIN_B + angle + getResources().getString(R.string.close_bracket).trim());
                        else if (toggleMode == 2)
                            secondEditText.setText(ASIND_B + text + getResources().getString(R.string.close_bracket).trim());
                        else
                            secondEditText.setText(SINH_B + text + getResources().getString(R.string.close_bracket).trim());
                    } else {
                        if (toggleMode == 1)
                            secondEditText.setText(SIN_B + text + getResources().getString(R.string.close_bracket).trim());
                        else if (toggleMode == 2)
                            secondEditText.setText(ASIN_B + text + getResources().getString(R.string.close_bracket).trim());
                        else
                            secondEditText.setText(SINH_B + text + getResources().getString(R.string.close_bracket).trim());
                    }
                }
                break;

            case R.id.cos:
                if (secondEditText.length() != 0) {
                    text = secondEditText.getText().toString();
                    if (angleMode == 1) {
                        double angle = Math.toRadians(new ExtendedDoubleEvaluation().evaluate(text));
                        if (toggleMode == 1)
                            secondEditText.setText(COS_B + angle + getResources().getString(R.string.close_bracket).trim());
                        else if (toggleMode == 2)
                            secondEditText.setText(ACOSD_B + text + getResources().getString(R.string.close_bracket).trim());
                        else
                            secondEditText.setText(COSH_B + text + getResources().getString(R.string.close_bracket).trim());
                    } else {
                        if (toggleMode == 1)
                            secondEditText.setText(COS_B + text + getResources().getString(R.string.close_bracket).trim());
                        else if (toggleMode == 2)
                            secondEditText.setText(ACOS_B + text + getResources().getString(R.string.close_bracket).trim());
                        else
                            secondEditText.setText(COSH_B + text + getResources().getString(R.string.close_bracket).trim());
                    }
                }
                break;

            case R.id.tan:
                if (secondEditText.length() != 0) {
                    text = secondEditText.getText().toString();
                    if (angleMode == 1) {
                        double angle = Math.toRadians(new ExtendedDoubleEvaluation().evaluate(text));
                        if (toggleMode == 1)
                            secondEditText.setText(TAN_B + angle + getResources().getString(R.string.close_bracket).trim());
                        else if (toggleMode == 2)
                            secondEditText.setText(ATAND_B + text + getResources().getString(R.string.close_bracket).trim());
                        else
                            secondEditText.setText(TANH_B + text + getResources().getString(R.string.close_bracket).trim());
                    } else {
                        if (toggleMode == 1)
                            secondEditText.setText(TAN_B + text + getResources().getString(R.string.close_bracket).trim());
                        else if (toggleMode == 2)
                            secondEditText.setText(ATAN_B + text + getResources().getString(R.string.close_bracket).trim());
                        else
                            secondEditText.setText(TANH_B + text + getResources().getString(R.string.close_bracket).trim());
                    }
                }
                break;

            case R.id.positive_negative:
                if (secondEditText.length() != 0) {
                    String s = secondEditText.getText().toString();
                    char arr[] = s.toCharArray();
                    if (arr[0] == '-')
                        secondEditText.setText(s.substring(1, s.length()));
                    else
                        secondEditText.setText(HYPHEN.concat(s));
                }
                break;

            case R.id.equal:
                text = getResources().getString(R.string.no_text).trim();
                if (secondEditText.length() != 0) {
                    text = secondEditText.getText().toString();
                }
                expression = firstEditText.getText().toString() + text;
                firstEditText.setText(getResources().getString(R.string.no_text).trim());
                if (expression.length() == 0)
                    expression = ZERO_DECIMAL;
                try {
                    Double result = new ExtendedDoubleEvaluation().evaluate(expression);
                    if (String.valueOf(result).equals("6.123233995736766E-17")) {
                        result = 0.0;
                        secondEditText.setText(String.valueOf(result));
                    } else if (String.valueOf(result).equals("1.633123935319537E16"))
                        secondEditText.setText(INFINITY);
                    else
                        secondEditText.setText(String.valueOf(result));
                } catch (Exception e) {
                    secondEditText.setText(INVALID_EXPRESSION);
                    firstEditText.setText(getResources().getString(R.string.no_text).trim());
                    expression = getResources().getString(R.string.no_text).trim();
                    e.printStackTrace();
                }
                break;

            case R.id.openBracket:
                firstEditText.setText(firstEditText.getText().toString().concat(getResources().getString(R.string.open_bracket).trim()));
                break;

            case R.id.closeBracket:
                if (secondEditText.length() != 0)
                    firstEditText.setText(firstEditText.getText() + secondEditText.getText().toString() + getResources().getString(R.string.close_bracket).trim());
                else
                    firstEditText.setText(firstEditText.getText().toString().concat(getResources().getString(R.string.close_bracket).trim()));
                secondEditText.setText(getResources().getString(R.string.no_text).trim());
                break;
        }
    }

    private void operationClicked(String operation) {
        if (secondEditText.length() != 0) {
            String text = secondEditText.getText().toString();
            firstEditText.setText(firstEditText.getText() + text + operation);
            secondEditText.setText(getResources().getString(R.string.no_text).trim());
            count = 0;
        } else {
            String text = firstEditText.getText().toString();
            if (text.length() > 0) {
                String newText = text.substring(0, text.length()) + operation;
                firstEditText.setText(newText);
            }
        }
    }

}
