package com.akhil.calculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;

import com.akhil.calculator.adapter.CustomExpandableListAdapter;
import com.akhil.calculator.calculation.ScientificCalculation;
import com.akhil.calculator.calculation.StandardCalculation;
import com.akhil.calculator.converter.UnitArea;
import com.akhil.calculator.converter.UnitLength;
import com.akhil.calculator.converter.UnitTemperature;
import com.akhil.calculator.converter.UnitWeight;
import com.akhil.calculator.datasource.ExpandableListDataSource;
import com.akhil.calculator.util.Calculator;
import com.akhil.calculator.util.UnitConversion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    private ExpandableListView mExpandableListView;
    private List<String> mExpandableListTitle;
    private Map<String, List<String>> mExpandableListData;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
        FrameLayout activityContainer = (FrameLayout) drawerLayout.findViewById(R.id.container);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        super.setContentView(drawerLayout);
        mExpandableListView = (ExpandableListView) findViewById(R.id.navList);
        mExpandableListData = ExpandableListDataSource.getData(this);
        mExpandableListTitle = new ArrayList<>(mExpandableListData.keySet());
        addDrawerItems();
        setupDrawer();
        toggle.syncState();
        drawerLayout.closeDrawer(GravityCompat.START);
        final ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeButtonEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        assert drawer != null;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
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
}
