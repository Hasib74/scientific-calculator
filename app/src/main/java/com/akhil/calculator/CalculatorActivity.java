package com.akhil.calculator;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.akhil.calculator.adapter.CustomExpandableListAdapter;
import com.akhil.calculator.calculation.ScientificCalculation;
import com.akhil.calculator.calculation.StandardCalculation;
import com.akhil.calculator.converter.UnitArea;
import com.akhil.calculator.converter.UnitLength;
import com.akhil.calculator.converter.UnitTemperature;
import com.akhil.calculator.converter.UnitWeight;
import com.akhil.calculator.navigation.ExpandableListDataSource;
import com.akhil.calculator.util.Calculator;
import com.akhil.calculator.util.UnitConversion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CalculatorActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    private ExpandableListView mExpandableListView;
    private List<String> mExpandableListTitle;
    private Map<String, List<String>> mExpandableListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mExpandableListView = (ExpandableListView) findViewById(R.id.navList);
        mExpandableListData = ExpandableListDataSource.getData(this);
        mExpandableListTitle = new ArrayList<>(mExpandableListData.keySet());
        addDrawerItems();
        setupDrawer();
        if (savedInstanceState == null) {
            selectFirstItemAsDefault();
        }
        toggle.syncState();
        drawerLayout.closeDrawer(GravityCompat.START);
        final ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeButtonEnabled(true);
        }
    }

    private void selectFirstItemAsDefault() {
        Intent nextActivity = new Intent(getApplicationContext(), StandardCalculation.class);
        startActivity(nextActivity);
    }

    private void setupDrawer() {
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
        };

        toggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(toggle);
    }

    private void addDrawerItems() {
        ExpandableListAdapter mExpandableListAdapter = new CustomExpandableListAdapter(this, mExpandableListTitle, mExpandableListData);
        mExpandableListView.setAdapter(mExpandableListAdapter);
        mExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                final ActionBar supportActionBar = getSupportActionBar();
                if (supportActionBar != null)
                    supportActionBar.setTitle(mExpandableListTitle.get(groupPosition));
            }
        });

        mExpandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                final ActionBar supportActionBar = getSupportActionBar();
                if (supportActionBar != null)
                    supportActionBar.setTitle(R.string.app_name);
            }
        });

        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                String selectedItem = ((List) (mExpandableListData.get(mExpandableListTitle.get(groupPosition))))
                        .get(childPosition).toString();
                final ActionBar supportActionBar = getSupportActionBar();
                Intent nextActivity;
                if (supportActionBar != null)
                    supportActionBar.setTitle(selectedItem);

                if (selectedItem.equalsIgnoreCase(Calculator.STANDARD_CALCULATOR.getValue())) {
                    nextActivity = new Intent(getApplicationContext(), StandardCalculation.class);
                    startActivity(nextActivity);
                } else if (selectedItem.equalsIgnoreCase(Calculator.SCIENTIFIC_CALCULATOR.getValue())) {
                    nextActivity = new Intent(getApplicationContext(), ScientificCalculation.class);
                    startActivity(nextActivity);
                } else if (selectedItem.equalsIgnoreCase(UnitConversion.AREA_CONVERTER.getValue())) {
                    nextActivity = new Intent(getApplicationContext(), UnitArea.class);
                    startActivity(nextActivity);
                } else if (selectedItem.equalsIgnoreCase(UnitConversion.LENGTH_CONVERTER.getValue())) {
                    nextActivity = new Intent(getApplicationContext(), UnitLength.class);
                    startActivity(nextActivity);
                } else if (selectedItem.equalsIgnoreCase(UnitConversion.TEMPERATURE_CONVERTER.getValue())) {
                    nextActivity = new Intent(getApplicationContext(), UnitTemperature.class);
                    startActivity(nextActivity);
                } else if (selectedItem.equalsIgnoreCase(UnitConversion.WEIGHT_CONVERTER.getValue())) {
                    nextActivity = new Intent(getApplicationContext(), UnitWeight.class);
                    startActivity(nextActivity);
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_calculator_drawer, menu);
        return true;
    }
}
