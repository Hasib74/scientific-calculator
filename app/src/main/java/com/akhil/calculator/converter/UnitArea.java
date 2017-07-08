package com.akhil.calculator.converter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.akhil.calculator.R;
import com.akhil.calculator.util.ApplicationConstant;

public class UnitArea extends AppCompatActivity {

    private EditText firstInput, secondInput;
    private Spinner spinnerOne, spinnerTwo;
    private int count = 0;
    private ConvertingUnits.Area convertingUnits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_unit_area);

        firstInput = (EditText) findViewById(R.id.item1);
        secondInput = (EditText) findViewById(R.id.item2);
        spinnerOne = (Spinner) findViewById(R.id.spinner1);
        spinnerTwo = (Spinner) findViewById(R.id.spinner2);

        convertingUnits = new ConvertingUnits.Area();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.number_0:
                firstInput.setText(firstInput.getText().append(String.valueOf(ApplicationConstant.ZERO.getValue())));
                break;

            case R.id.number_1:
                firstInput.setText(firstInput.getText().append(String.valueOf(ApplicationConstant.ONE.getValue())));
                break;

            case R.id.number_2:
                firstInput.setText(firstInput.getText().append(String.valueOf(ApplicationConstant.TWO.getValue())));
                break;

            case R.id.number_3:
                firstInput.setText(firstInput.getText().append(String.valueOf(ApplicationConstant.THREE.getValue())));
                break;

            case R.id.number_4:
                firstInput.setText(firstInput.getText().append(String.valueOf(ApplicationConstant.FOUR.getValue())));
                break;

            case R.id.number_5:
                firstInput.setText(firstInput.getText().append(String.valueOf(ApplicationConstant.FIVE.getValue())));
                break;

            case R.id.number_6:
                firstInput.setText(firstInput.getText().append(String.valueOf(ApplicationConstant.SIX.getValue())));
                break;

            case R.id.number_7:
                firstInput.setText(firstInput.getText().append(String.valueOf(ApplicationConstant.SEVEN.getValue())));
                break;

            case R.id.number_8:
                firstInput.setText(firstInput.getText().append(String.valueOf(ApplicationConstant.EIGHT.getValue())));
                break;

            case R.id.number_9:
                firstInput.setText(firstInput.getText().append(String.valueOf(ApplicationConstant.NINE.getValue())));
                break;

            case R.id.dot:
                if (count == 0) {
                    firstInput.setText(firstInput.getText().append(getResources().getString(R.string.dot).trim()));
                    count++;
                }
                break;

            case R.id.clear:
                firstInput.setText(getResources().getString(R.string.no_text).trim());
                secondInput.setText(getResources().getString(R.string.no_text).trim());
                count = 0;
                break;

            case R.id.backSpace:
                if (firstInput.length() != 0) {
                    String text = firstInput.getText().toString();
                    if (text.endsWith(getResources().getString(R.string.dot).trim()))
                        count = 0;
                    String newText = text.substring(0, text.length() - 1);
                    firstInput.setText(newText);
                }
                break;

            case R.id.equal:
                int item1 = spinnerOne.getSelectedItemPosition();
                int item2 = spinnerTwo.getSelectedItemPosition();
                double value1 = Double.parseDouble(firstInput.getText().toString());
                double result = evaluate(item1, item2, value1);
                secondInput.setText(String.valueOf(result));
                break;
        }
    }

    public double evaluate(int item1, int item2, double value) {
        double temp = 0.0;
        if (item1 == item2)
            return value;
        else {
            switch (item1) {
                case 0:
                    temp = convertingUnits.squareMillimeterToMeter(value);
                    break;
                case 1:
                    temp = convertingUnits.squareCentimeterToMeter(value);
                    break;
                case 2:
                    temp = value;
                    break;
                case 3:
                    temp = convertingUnits.squareKilometerToMeter(value);
                    break;
                case 4:
                    temp = convertingUnits.acreToMeter(value);
                    break;
                case 5:
                    temp = convertingUnits.hectareToMeter(value);
                    break;
            }

            switch (item2) {
                case 0:
                    temp = convertingUnits.squareMeterToMillimeter(temp);
                    break;
                case 1:
                    temp = convertingUnits.squareMeterToCentimeter(temp);
                    break;
                case 3:
                    temp = convertingUnits.squareMeterToKilometer(temp);
                    break;
                case 4:
                    temp = convertingUnits.squareMeterToAcre(temp);
                    break;
                case 5:
                    temp = convertingUnits.squareMeterToHectare(temp);
                    break;
            }
            return temp;
        }
    }
}
