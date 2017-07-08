package com.akhil.calculator.converter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.akhil.calculator.R;

public class UnitConverter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_unit_coverter);

    }

    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.area:
                i = new Intent(this, UnitArea.class);
                startActivity(i);
                break;
            case R.id.length:
                i = new Intent(this, UnitLength.class);
                startActivity(i);
                break;
            case R.id.weight:
                i = new Intent(this, UnitWeight.class);
                startActivity(i);
                break;
            case R.id.tempearture:
                i = new Intent(this, UnitTemperature.class);
                startActivity(i);
                break;
        }
    }

}