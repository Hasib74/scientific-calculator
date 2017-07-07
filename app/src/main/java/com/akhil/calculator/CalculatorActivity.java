package com.akhil.calculator;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.akhil.calculator.calculation.ScientificCalculation;
import com.akhil.calculator.calculation.StandardCalculation;
import com.akhil.calculator.converter.UnitConverter;

public class CalculatorActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        drawerLayout.closeDrawer(GravityCompat.START);

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        drawerLayout.closeDrawer(GravityCompat.START);
        Intent nextActivity;
        if (id == R.id.drawer_standard_calculator) {
            nextActivity = new Intent(getApplicationContext(), StandardCalculation.class);
            startActivity(nextActivity);
        } else if (id == R.id.drawer_scientific_calculator) {
            nextActivity = new Intent(getApplicationContext(), ScientificCalculation.class);
            startActivity(nextActivity);
        } else if (id == R.id.drawer_unit_converter) {
            nextActivity = new Intent(getApplicationContext(), UnitConverter.class);
            startActivity(nextActivity);
        }
        return true;
    }
}
