package com.example.akhil.calculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.text.Html.fromHtml;

public class ScientificCalculator extends AppCompatActivity implements View.OnClickListener {
    private static String PREFS_NAME = "memory";
    private EditText outputResult;
    private TextView shiftDisplay;
    private TextView degreeRad;
    private boolean isDegree = false;
    private boolean isInverse = false;
    private String lastResultObtain = "";
    private String currentDisplayedInput = "";
    private String inputToBeParsed = "";
    private CalculatorOperation mCalculatorOperation;
    private Button button0, button1, button2, button3, button4, button5, button6, button7,
            button8, button9, buttonClear, buttonDivide, buttonMultiply, buttonSubtract,
            buttonAdd, buttonPercentage, buttonEqual, buttonDecimal, closeParenthesis, openParenthesis, buttonAnswer,
            buttonSingleDelete, buttonExp, buttonSin, buttonLn, buttonCos, buttonLog, buttonTan, buttonSquareRoot, buttonXSquare, buttonYPowerX,
            buttonRnd, buttonShift, buttonRad, buttonAbs, buttonMr, buttonMs, buttonMPlus;

    private TextView labelFactorial, labelCombination, labelPermutation, labelPi, labelE, labelComma, labelCubeRoot, labelCube,
            labelInverseX, labelInverseSin, labelInverseCos, labelInverseTan, labelExponential, labelTenPowerX, labelRCL,
            labelSTO, labelMMinus, labelFloat, labelDeg;

    static public boolean setPreference(Context c, float value) {
        SharedPreferences settings;
        settings = c.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat("key", value);
        return editor.commit();
    }

    static public float getPreference(Context c) {
        SharedPreferences settings;
        settings = c.getSharedPreferences(PREFS_NAME, 0);
        float value = settings.getFloat("key", 0);
        return value;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        createLayout(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mCalculatorOperation = new CalculatorOperation();

        initializeViewBasedOnID();

        initializeTextFromHTML();

        initializeActionListener();
    }

    private void createLayout(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific_calculator);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    private void initializeActionListener() {
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonPercentage.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonDecimal.setOnClickListener(this);
        closeParenthesis.setOnClickListener(this);
        openParenthesis.setOnClickListener(this);
        buttonSingleDelete.setOnClickListener(this);
        buttonExp.setOnClickListener(this);
        buttonSquareRoot.setOnClickListener(this);
        buttonXSquare.setOnClickListener(this);
        buttonYPowerX.setOnClickListener(this);
        buttonSin.setOnClickListener(this);
        buttonCos.setOnClickListener(this);
        buttonTan.setOnClickListener(this);
        buttonLn.setOnClickListener(this);
        buttonLog.setOnClickListener(this);
        buttonRnd.setOnClickListener(this);
        buttonShift.setOnClickListener(this);
        buttonRad.setOnClickListener(this);
        buttonAbs.setOnClickListener(this);
        buttonMr.setOnClickListener(this);
        buttonMs.setOnClickListener(this);
        buttonMPlus.setOnClickListener(this);
    }

    private void initializeTextFromHTML() {
        buttonDivide.setText(fromHtml(HTML_CONSTANTS.DIVISION.getValue()));
        buttonSquareRoot.setText(fromHtml(HTML_CONSTANTS.SQUARE_ROOT.getValue()));
        buttonXSquare.setText(fromHtml(HTML_CONSTANTS.X_SQUARE.getValue()));
        buttonYPowerX.setText(fromHtml(HTML_CONSTANTS.Y_POWER_X.getValue()));
        labelInverseSin.setText(fromHtml(HTML_CONSTANTS.INVERSE_SIN.getValue()));
        labelInverseCos.setText(fromHtml(HTML_CONSTANTS.INVERSE_COS.getValue()));
        labelInverseTan.setText(fromHtml(HTML_CONSTANTS.INVERSE_TAN.getValue()));
        labelExponential.setText(fromHtml(HTML_CONSTANTS.EXPONENTIAL.getValue()));
        labelTenPowerX.setText(fromHtml(HTML_CONSTANTS.TEN_POWER_X.getValue()));
        labelCubeRoot.setText(fromHtml(HTML_CONSTANTS.CUBE_SQUARE.getValue()));
        labelCube.setText(fromHtml(HTML_CONSTANTS.CUBE_ROOT.getValue()));
        labelPi.setText(fromHtml(HTML_CONSTANTS.PI.getValue()));
    }

    private void initializeViewBasedOnID() {
        outputResult = (EditText) findViewById(R.id.display);
        outputResult.setSelection(outputResult.getText().length());
        shiftDisplay = (TextView) findViewById(R.id.shift_display);
        degreeRad = (TextView) findViewById(R.id.degree);
        button0 = (Button) findViewById(R.id.zero_button);
        button1 = (Button) findViewById(R.id.one_button);
        button2 = (Button) findViewById(R.id.two_button);
        button3 = (Button) findViewById(R.id.three_button);
        button4 = (Button) findViewById(R.id.four_button);
        button5 = (Button) findViewById(R.id.five_button);
        button6 = (Button) findViewById(R.id.six_button);
        button7 = (Button) findViewById(R.id.seven_button);
        button8 = (Button) findViewById(R.id.eight_button);
        button9 = (Button) findViewById(R.id.nine_button);
        buttonDivide = (Button) findViewById(R.id.division);
        buttonMultiply = (Button) findViewById(R.id.multiplication);
        buttonSubtract = (Button) findViewById(R.id.subtraction);
        buttonAdd = (Button) findViewById(R.id.addition);
        buttonPercentage = (Button) findViewById(R.id.percent);
        buttonDecimal = (Button) findViewById(R.id.dot);
        closeParenthesis = (Button) findViewById(R.id.close_bracket);
        openParenthesis = (Button) findViewById(R.id.open_bracket);
        buttonExp = (Button) findViewById(R.id.exp);
        buttonSquareRoot = (Button) findViewById(R.id.square_root);
        buttonXSquare = (Button) findViewById(R.id.x_square);
        buttonYPowerX = (Button) findViewById(R.id.x_power_y);
        buttonSin = (Button) findViewById(R.id.sin_sign);
        buttonCos = (Button) findViewById(R.id.cos_sign);
        buttonTan = (Button) findViewById(R.id.tan_sign);
        buttonLn = (Button) findViewById(R.id.natural_log);
        buttonLog = (Button) findViewById(R.id.log);
        buttonRnd = (Button) findViewById(R.id.hys);
        buttonShift = (Button) findViewById(R.id.shift);
        buttonRad = (Button) findViewById(R.id.rad);
        buttonAbs = (Button) findViewById(R.id.abs);
        buttonMr = (Button) findViewById(R.id.mr);
        buttonMs = (Button) findViewById(R.id.ms);
        buttonMPlus = (Button) findViewById(R.id.m_plus);
        buttonClear = (Button) findViewById(R.id.clear);
        buttonSingleDelete = (Button) findViewById(R.id.single_delete);
        buttonEqual = (Button) findViewById(R.id.equal_sign);
        buttonAnswer = (Button) findViewById(R.id.ans);
        labelFactorial = (TextView) findViewById(R.id.factorial);
        labelCombination = (TextView) findViewById(R.id.combination);
        labelPermutation = (TextView) findViewById(R.id.permutation);
        labelPi = (TextView) findViewById(R.id.pi);
        labelE = (TextView) findViewById(R.id.e);
        labelComma = (TextView) findViewById(R.id.comma);
        labelCubeRoot = (TextView) findViewById(R.id.cube_root);
        labelCube = (TextView) findViewById(R.id.cube);
        labelInverseX = (TextView) findViewById(R.id.one_over_x);
        labelInverseSin = (TextView) findViewById(R.id.inverse_sin);
        labelInverseCos = (TextView) findViewById(R.id.inverse_cos);
        labelInverseTan = (TextView) findViewById(R.id.inverse_tan);
        labelExponential = (TextView) findViewById(R.id.expo);
        labelTenPowerX = (TextView) findViewById(R.id.ten_power_x);
        labelRCL = (TextView) findViewById(R.id.rcl);
        labelSTO = (TextView) findViewById(R.id.sto);
        labelMMinus = (TextView) findViewById(R.id.m_minus);
        labelFloat = (TextView) findViewById(R.id.float_number);
        labelDeg = (TextView) findViewById(R.id.degree);
    }

    private void obtainInputValues(String input) {
        switch (input) {
            case "0":
                currentDisplayedInput += "0";
                inputToBeParsed += "0";
                break;
            case "1":
                if (isInverse) {
                    currentDisplayedInput += "π";
                    inputToBeParsed += "pi";
                } else {
                    currentDisplayedInput += "1";
                    inputToBeParsed += "1";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case "2":
                if (isInverse) {
                    currentDisplayedInput += "e";
                    inputToBeParsed += "e";
                } else {
                    currentDisplayedInput += "2";
                    inputToBeParsed += "2";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case "3":
                if (isInverse) {
                    currentDisplayedInput += ",";
                    inputToBeParsed += ",";
                } else {
                    currentDisplayedInput += "3";
                    inputToBeParsed += "3";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case "4":
                if (isInverse) {
                    currentDisplayedInput += "!(";
                    inputToBeParsed += "!(";
                } else {
                    currentDisplayedInput += "4";
                    inputToBeParsed += "4";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case "5":
                if (isInverse) {
                    currentDisplayedInput += "combination(";
                    inputToBeParsed += "combination(";
                } else {
                    currentDisplayedInput += "5";
                    inputToBeParsed += "5";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case "6":
                if (isInverse) {
                    currentDisplayedInput += "permutation(";
                    inputToBeParsed += "permutation(";
                } else {
                    currentDisplayedInput += "6";
                    inputToBeParsed += "6";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case "7":
                currentDisplayedInput += "7";
                inputToBeParsed += "7";
                break;
            case "8":
                currentDisplayedInput += "8";
                inputToBeParsed += "8";
                break;
            case "9":
                currentDisplayedInput += "9";
                inputToBeParsed += "9";
                break;
            case ".":
                currentDisplayedInput += ".";
                inputToBeParsed += ".";
                break;
            case "+":
                currentDisplayedInput += "+";
                inputToBeParsed += "+";
                break;
            case "-":
                currentDisplayedInput += "-";
                inputToBeParsed += "-";
                break;
            case "÷":
                currentDisplayedInput += "÷";
                inputToBeParsed += "/";
                break;
            case "x":
                currentDisplayedInput += "*";
                inputToBeParsed += "*";
                break;
            case "(":
                currentDisplayedInput += "(";
                inputToBeParsed += "(";
                break;
            case ")":
                currentDisplayedInput += ")";
                inputToBeParsed += ")";
                break;
            case "%":
                if (isInverse) {
                    currentDisplayedInput += "1÷";
                    inputToBeParsed += "1÷";
                } else {
                    currentDisplayedInput += "%";
                    inputToBeParsed += "%";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case "ln":
                if (isInverse) {
                    currentDisplayedInput += "e^";
                    inputToBeParsed += "e^";
                } else {
                    currentDisplayedInput += "ln(";
                    inputToBeParsed += "ln(";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case "log":
                if (isInverse) {
                    currentDisplayedInput += "10^";
                    inputToBeParsed += "10^";
                } else {
                    currentDisplayedInput += "log(";
                    inputToBeParsed += "log(";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case "√":
                if (isInverse) {
                    currentDisplayedInput += "3√(";
                    inputToBeParsed += "crt(";
                } else {
                    currentDisplayedInput += "√(";
                    inputToBeParsed += "sqrt(";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case "Yx":
                currentDisplayedInput += "^";
                inputToBeParsed += "^";
                break;
            case "sin":
                if (isInverse) {
                    currentDisplayedInput += "asin(";
                    inputToBeParsed += "asin(";
                } else {
                    currentDisplayedInput += "sin(";
                    inputToBeParsed += "sin(";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case "cos":
                if (isInverse) {
                    currentDisplayedInput += "acos(";
                    inputToBeParsed += "acos(";
                } else {
                    currentDisplayedInput += "cos(";
                    inputToBeParsed += "cos(";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case "tan":
                if (isInverse) {
                    currentDisplayedInput += "atan(";
                    inputToBeParsed += "atan(";
                } else {
                    currentDisplayedInput += "tan(";
                    inputToBeParsed += "tan(";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case "exp":
                currentDisplayedInput += "E0";
                inputToBeParsed += "E";
                break;
            case "x2":
                if (isInverse) {
                    currentDisplayedInput += "^3";
                    inputToBeParsed += "^3";
                } else {
                    currentDisplayedInput += "^2";
                    inputToBeParsed += "^2";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case "rnd":
                double ran = Math.random();
                currentDisplayedInput += String.valueOf(ran);
                inputToBeParsed += String.valueOf(ran);
                break;
            case "ABS":
                currentDisplayedInput += "abs(";
                inputToBeParsed += "abs(";
                break;
            case "MR":
                String mValue = getStoredPreferenceValue(ScientificCalculator.this);
                String result = removeTrailingZero(mValue);
                if (!result.equals("0")) {
                    currentDisplayedInput += result;
                    inputToBeParsed += result;
                }
                break;
            case "MS":
                clearMemoryStorage(ScientificCalculator.this);
                break;
            case "M+":
                if (isInverse) {
                    double inputValueMinus = isANumber(outputResult.getText().toString());
                    if (!Double.isNaN(inputValueMinus)) {
                        subtractMemoryStorage(ScientificCalculator.this, inputValueMinus);
                    }
                } else {
                    double inputValue = isANumber(outputResult.getText().toString());
                    if (!Double.isNaN(inputValue)) {
                        addToMemoryStorage(ScientificCalculator.this, inputValue);
                    }
                }
                toggleInverse();
                toggleShiftButton();
                break;
        }

        outputResult.setText(currentDisplayedInput);
        outputResult.setSelection(outputResult.getText().length());
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        if (data.equals("AC")) {
            outputResult.setText("");
            currentDisplayedInput = "";
            inputToBeParsed = "";
        } else if (data.equals("del")) {
            String enteredInput = outputResult.getText().toString();
            if (enteredInput.length() > 0) {
                enteredInput = enteredInput.substring(0, enteredInput.length() - 1);
                currentDisplayedInput = enteredInput;
                inputToBeParsed = enteredInput;
                outputResult.setText(currentDisplayedInput);
            }
        } else if (data.equals("=")) {
            if (!currentDisplayedInput.contains(")")) {
                currentDisplayedInput = currentDisplayedInput.concat(")");
                outputResult.setText(currentDisplayedInput);
            }
            String resultObject = mCalculatorOperation.getResult(inputToBeParsed);
            outputResult.setText(removeTrailingZero(resultObject));
            outputResult.setSelection(outputResult.getText().length());
        } else if (data.equals("Ans")) {
            String enteredInput = outputResult.getText().toString();
            enteredInput += lastResultObtain;
            outputResult.setText(enteredInput);
            outputResult.setSelection(outputResult.getText().length());
        } else if (data.equals("SHIFT")) {
            if (!isInverse) {
                isInverse = true;
            } else {
                isInverse = false;
            }
            toggleShiftButton();
        } else if (data.equals("RAD")) {
            buttonRad.setText("DEG");
            degreeRad.setText("RAD");
        } else if (data.equals("DEG")) {
            buttonRad.setText("RAD");
            degreeRad.setText("DEG");
        } else {
            obtainInputValues(data);
        }
    }

    private String removeTrailingZero(String formattingInput) {
        if (!formattingInput.contains(".")) {
            return formattingInput;
        }
        int dotPosition = formattingInput.indexOf(".");
        String newValue = formattingInput.substring(dotPosition, formattingInput.length());
        if (newValue.equals(".0")) {
            return formattingInput.substring(0, dotPosition);
        }
        return formattingInput;
    }

    private void toggleInverse() {
        if (isInverse) {
            isInverse = false;
        }
    }

    private void toggleShiftButton() {
        if (isInverse) {
            shiftDisplay.setText("SHIFT");
        } else {
            shiftDisplay.setText("");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scientific_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    private double isANumber(String numberInput) {
        double result = Double.NaN;
        try {
            result = Double.parseDouble(numberInput);
        } catch (NumberFormatException nfe) {
        }
        return result;
    }

    private void addToMemoryStorage(Context context, double inputToStore) {
        float returnPrefValue = getPreference(context);
        float newValue = returnPrefValue + (float) inputToStore;
        setPreference(context, newValue);
    }

    private void subtractMemoryStorage(Context context, double inputToStore) {
        float returnPrefValue = getPreference(context);
        float newValue = returnPrefValue - (float) inputToStore;
        setPreference(context, newValue);
    }

    private void clearMemoryStorage(Context context) {
        setPreference(context, 0);
    }

    private String getStoredPreferenceValue(Context context) {
        float returnedValue = getPreference(context);
        return String.valueOf(returnedValue);
    }

}