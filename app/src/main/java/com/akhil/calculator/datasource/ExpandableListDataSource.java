package com.akhil.calculator.datasource;

import android.content.Context;

import com.akhil.calculator.util.Calculator;
import com.akhil.calculator.util.UnitConversion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ExpandableListDataSource {

    public static Map<String, List<String>> getData(Context context) {
        Map<String, List<String>> expandableListData = new TreeMap<>();

        List<String> calculator = new ArrayList<>();
        calculator.add(Calculator.STANDARD_CALCULATOR.getValue());
        calculator.add(Calculator.SCIENTIFIC_CALCULATOR.getValue());

        List<String> unitConverter = new ArrayList<>();
        unitConverter.add(UnitConversion.AREA_CONVERTER.getValue());
        unitConverter.add(UnitConversion.LENGTH_CONVERTER.getValue());
        unitConverter.add(UnitConversion.TEMPERATURE_CONVERTER.getValue());
        unitConverter.add(UnitConversion.WEIGHT_CONVERTER.getValue());

        expandableListData.put(Calculator.class.getSimpleName(), calculator);
        expandableListData.put(UnitConversion.UNIT_CONVERSION.getValue(), unitConverter);

        return expandableListData;
    }
}
