package com.akhil.calculator.converter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.akhil.calculator.R;
import com.akhil.calculator.util.ApplicationConstant;

public class UnitTemperature extends AppCompatActivity {

    private EditText firstEditText, secondEditText;
    private Spinner firstSpinner, secondSpinner;
    private int count = 0;
    private ConvertingUnits.Temperature convertingUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_unit_temperature);

        firstEditText = (EditText) findViewById(R.id.item1);
        secondEditText = (EditText) findViewById(R.id.item2);
        firstSpinner = (Spinner) findViewById(R.id.spinner1);
        secondSpinner = (Spinner) findViewById(R.id.spinner2);

        convertingUnit = new ConvertingUnits.Temperature();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.number_0:
                firstEditText.setText(firstEditText.getText().toString().concat(String.valueOf(ApplicationConstant.ZERO.getValue())));
                break;

            case R.id.number_1:
                firstEditText.setText(firstEditText.getText().toString().concat(String.valueOf(ApplicationConstant.ONE.getValue())));
                break;

            case R.id.number_2:
                firstEditText.setText(firstEditText.getText().toString().concat(String.valueOf(ApplicationConstant.TWO.getValue())));
                break;

            case R.id.number_3:
                firstEditText.setText(firstEditText.getText().toString().concat(String.valueOf(ApplicationConstant.THREE.getValue())));
                break;

            case R.id.number_4:
                firstEditText.setText(firstEditText.getText().toString().concat(String.valueOf(ApplicationConstant.FOUR.getValue())));
                break;

            case R.id.number_5:
                firstEditText.setText(firstEditText.getText().toString().concat(String.valueOf(ApplicationConstant.FIVE.getValue())));
                break;

            case R.id.number_6:
                firstEditText.setText(firstEditText.getText().toString().concat(String.valueOf(ApplicationConstant.SIX.getValue())));
                break;

            case R.id.number_7:
                firstEditText.setText(firstEditText.getText().toString().concat(String.valueOf(ApplicationConstant.SEVEN.getValue())));
                break;

            case R.id.number_8:
                firstEditText.setText(firstEditText.getText().toString().concat(String.valueOf(ApplicationConstant.EIGHT.getValue())));
                break;

            case R.id.number_9:
                firstEditText.setText(firstEditText.getText().toString().concat(String.valueOf(ApplicationConstant.NINE.getValue())));
                break;

            case R.id.dot:
                if (count == 0) {
                    firstEditText.setText(firstEditText.getText().toString().concat(getResources().getString(R.string.dot)));
                    count++;
                }
                break;

            case R.id.clear:
                firstEditText.setText(getResources().getString(R.string.no_text).trim());
                secondEditText.setText(getResources().getString(R.string.no_text).trim());
                count = 0;
                break;

            case R.id.backSpace:
                if (firstEditText.length() != 0) {
                    String text = firstEditText.getText().toString();
                    if (text.endsWith(getResources().getString(R.string.dot).trim()))
                        count = 0;
                    String newText = text.substring(0, text.length() - 1);
                    firstEditText.setText(newText);
                }
                break;

            case R.id.equal:
                int item1 = firstSpinner.getSelectedItemPosition();
                int item2 = secondSpinner.getSelectedItemPosition();
                double value1 = Double.parseDouble(firstEditText.getText().toString());
                double result = evaluate(item1, item2, value1);
                secondEditText.setText(String.valueOf(result));
                break;
        }
    }

    public double evaluate(int firstSpinner, int secondSpinner, double value) {
        double calculatedValue = 0.0;
        if (firstSpinner == secondSpinner)
            return value;
        else {
            switch (firstSpinner) {
                case 0:
                    calculatedValue = convertingUnit.celsiusToKelvin(value);
                    break;
                case 1:
                    calculatedValue = convertingUnit.fahrenheitToKelvin(value);
                    break;
                case 2:
                    calculatedValue = value;
                    break;
            }

            switch (secondSpinner) {
                case 0:
                    calculatedValue = convertingUnit.kelvinToCelsius(calculatedValue);
                    break;
                case 1:
                    calculatedValue = convertingUnit.kelvinToFahrenheit(calculatedValue);
                    break;
            }
            return calculatedValue;
        }
    }
}
