package com.akhil.calculator.activity.conversion;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.akhil.calculator.BaseActivity;
import com.akhil.calculator.R;
import com.akhil.calculator.util.ApplicationConstant;
import com.akhil.calculator.util.UnitConversion;

public class UnitLength extends BaseActivity {

    private EditText firstEditText, secondEditText;
    private Spinner firstSpinner, secondSpinner;
    private int count = 0;
    private ConvertingUnits.Length convertingUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(UnitConversion.LENGTH_CONVERTER.getValue());
        setContentView(R.layout.content_unit_length);

        firstEditText = (EditText) findViewById(R.id.item1);
        secondEditText = (EditText) findViewById(R.id.item2);
        firstSpinner = (Spinner) findViewById(R.id.spinner1);
        secondSpinner = (Spinner) findViewById(R.id.spinner2);

        convertingUnit = new ConvertingUnits.Length();
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
                int itemPosition = firstSpinner.getSelectedItemPosition();
                int selectedItemPosition = secondSpinner.getSelectedItemPosition();
                double value1 = Double.parseDouble(firstEditText.getText().toString());
                double result = evaluate(itemPosition, selectedItemPosition, value1);
                secondEditText.setText(String.valueOf(result));
                break;
        }
    }

    public double evaluate(int first_item, int second_item, double value) {
        double calculatedValue = 0.0;
        if (first_item == second_item)
            return value;
        else {
            switch (first_item) {
                case 0:
                    calculatedValue = convertingUnit.nanometerToMeter(value);
                    break;
                case 1:
                    calculatedValue = convertingUnit.millimeterToMeter(value);
                    break;
                case 2:
                    calculatedValue = convertingUnit.centimeterToMeter(value);
                    break;
                case 3:
                    calculatedValue = value;
                    break;
                case 4:
                    calculatedValue = convertingUnit.kilometerToMeter(value);
                    break;
                case 5:
                    calculatedValue = convertingUnit.inchToMeter(value);
                    break;
                case 6:
                    calculatedValue = convertingUnit.footToMeter(value);
                    break;
                case 7:
                    calculatedValue = convertingUnit.yardToMeter(value);
                    break;
                case 8:
                    calculatedValue = convertingUnit.mileToMeter(value);
                    break;
            }

            switch (second_item) {
                case 0:
                    calculatedValue = convertingUnit.meterToNanometer(calculatedValue);
                    break;
                case 1:
                    calculatedValue = convertingUnit.meterToMillimeter(calculatedValue);
                    break;
                case 2:
                    calculatedValue = convertingUnit.meterToCentimeter(calculatedValue);
                    break;
                case 4:
                    calculatedValue = convertingUnit.meterToKilometer(calculatedValue);
                    break;
                case 5:
                    calculatedValue = convertingUnit.meterToInch(calculatedValue);
                    break;
                case 6:
                    calculatedValue = convertingUnit.meterToFoot(calculatedValue);
                    break;
                case 7:
                    calculatedValue = convertingUnit.meterToYard(calculatedValue);
                    break;
                case 8:
                    calculatedValue = convertingUnit.meterToMile(calculatedValue);
                    break;
            }
            return calculatedValue;
        }
    }
}
