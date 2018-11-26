package com.gmu.kam.cs321partapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CatSearchActivity extends AppCompatActivity {

    public void openFilter(View v){
        startActivity(new Intent(CatSearchActivity.this, FilterActivity.class));
    }

    public void openFluid(View v){
        startActivity(new Intent(CatSearchActivity.this, FluidActivity.class));
    }

    public void openSensor(View v){
        startActivity(new Intent(CatSearchActivity.this, SensorActivity.class));
    }

    public void openElectric(View v){
        startActivity(new Intent(CatSearchActivity.this, ElectricActivity.class));
    }

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
