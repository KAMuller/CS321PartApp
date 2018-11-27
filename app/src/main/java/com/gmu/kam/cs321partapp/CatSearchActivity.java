package com.gmu.kam.cs321partapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * @author Kalman Muller
 */
public class CatSearchActivity extends AppCompatActivity {
// onCreate method for button. opens a new activity
    public void openFilter(View v){
        startActivity(new Intent(CatSearchActivity.this, FilterActivity.class));
    }
    // onCreate method for button. opens a new activity
    public void openFluid(View v){
        startActivity(new Intent(CatSearchActivity.this, FluidActivity.class));
    }
    // onCreate method for button. opens a new activity
    public void openSensor(View v){
        startActivity(new Intent(CatSearchActivity.this, SensorActivity.class));
    }
    // onCreate method for button. opens a new activity
    public void openElectric(View v){
        startActivity(new Intent(CatSearchActivity.this, ElectricActivity.class));
    }
    // onCreate method for button. opens a new activity
    public void openPart(View v){
        startActivity(new Intent(CatSearchActivity.this, PartActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_search);
        setTitle(getResources().getString(R.string.AppTitle));
    }
}
