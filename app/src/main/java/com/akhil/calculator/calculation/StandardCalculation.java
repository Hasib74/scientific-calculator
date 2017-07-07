package com.akhil.calculator.calculation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.akhil.calculator.R;
import com.akhil.calculator.util.ApplicationConstant;

public class StandardCalculation extends AppCompatActivity {

    private static final String INVALID_EXPRESSION = "Invalid Expression";
    private static final String POWER = "^";
    private static final String SQRT = "sqrt(";
    private static final String SQUARE = ")^2";
    private static final String ZERO = "0.0";
    private static final String STANDARD = "STANDARD";
    private static final String EQUALS = " = ";
    private EditText firstEditText, secondEditText;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_standard_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firstEditText = (EditText) findViewById(R.id.first_edit_text);
        secondEditText = (EditText) findViewById(R.id.second_edit_text);

        secondEditText.setText(getResources().getString(R.string.no_text).trim());
    }

    public void onClick(View v) {
        if (secondEditText.getText().toString().equals(INVALID_EXPRESSION))
            secondEditText.setText(getResources().getString(R.string.no_text).trim());
        switch (v.getId()) {
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

            case R.id.dot:
                if (count == 0 && secondEditText.length() != 0) {
                    secondEditText.setText(secondEditText.getText().toString().concat(getResources().getString(R.string.dot)));
                    count++;
                }
                break;

            case R.id.clear:
                firstEditText.setText(getResources().getString(R.string.no_text).trim());
                secondEditText.setText(getResources().getString(R.string.no_text).trim());
                count = 0;
                String expression = getResources().getString(R.string.no_text).trim();
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
                        for (int index = a.length - 2; index >= 0; index--) {
                            if (a[index] == getResources().getString(R.string.close_bracket).charAt(0)) {
                                counter++;
                            } else if (a[index] == getResources().getString(R.string.open_bracket).charAt(0)) {
                                counter--;
                            } else if (a[index] == getResources().getString(R.string.dot).charAt(0)) {
                                count = 0;
                            }
                            if (counter == 0) {
                                pos = index;
                                break;
                            }
                        }
                        newText = text.substring(0, pos);
                    }
                    if (newText.equals(getResources().getString(R.string.minus)) || newText.endsWith(getResources().getString(R.string.sqrt))) {
                        newText = getResources().getString(R.string.no_text).trim();
                    } else if (newText.endsWith(POWER))
                        newText = newText.substring(0, newText.length() - 1);

                    secondEditText.setText(newText);
                }
                break;

            case R.id.plus:
                operationClicked(getResources().getString(R.string.plus));
                break;

            case R.id.minus:
                operationClicked(getResources().getString(R.string.minus));
                break;

            case R.id.divide:
                operationClicked(getResources().getString(R.string.division));
                break;

            case R.id.multiply:
                operationClicked(getResources().getString(R.string.asterisk));
                break;

            case R.id.sqrt:
                if (secondEditText.length() != 0) {
                    text = secondEditText.getText().toString();
                    secondEditText.setText(SQRT + text + getResources().getString(R.string.close_bracket));
                }
                break;

            case R.id.square:
                if (secondEditText.length() != 0) {
                    text = secondEditText.getText().toString();
                    secondEditText.setText(getResources().getString(R.string.open_bracket) + text + SQUARE);
                }
                break;

            case R.id.positive_negative:
                if (secondEditText.length() != 0) {
                    String s = secondEditText.getText().toString();
                    char arr[] = s.toCharArray();
                    if (arr[0] == getResources().getString(R.string.minus).charAt(0))
                        secondEditText.setText(s.substring(1, s.length()));
                    else
                        secondEditText.setText(getResources().getString(R.string.minus).concat(s));
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
                    expression = ZERO;
                try {
                    Double result = new ExtendedDoubleEvaluation().evaluate(expression);
                    secondEditText.setText(String.valueOf(result));
                } catch (Exception e) {
                    secondEditText.setText(INVALID_EXPRESSION);
                    firstEditText.setText(getResources().getString(R.string.no_text).trim());
                    expression = getResources().getString(R.string.no_text).trim();
                }
                break;

            case R.id.openBracket:
                firstEditText.setText(firstEditText.getText().append(getResources().getString(R.string.open_bracket)));
                break;

            case R.id.closeBracket:
                firstEditText.setText(firstEditText.getText().append(secondEditText.getText()).append(getResources().getString(R.string.close_bracket)));
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
