package com.gmu.kam.cs321partapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FluidActivity extends AppCompatActivity {

    public void EOilSearch(View v){

        Intent openResults = new Intent(FluidActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.engOil));
        startActivity(openResults);
    }

    public void TransFSearch(View v){

        Intent openResults = new Intent(FluidActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.transFluid));
        startActivity(openResults);
    }

    public void BrFSearch(View v){

        Intent openResults = new Intent(FluidActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.brFld));
        startActivity(openResults);
    }

    public void CoolFSearch(View v){

        Intent openResults = new Intent(FluidActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.coolFld));
        startActivity(openResults);
    }

    public void PwrFSearch(View v){

        Intent openResults = new Intent(FluidActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.pwrFluid));
        startActivity(openResults);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fluid);
        setTitle(getResources().getString(R.string.AppTitle));
    }

    @Override
    public void onResume(){
        super.onResume();

        TextView currCar = findViewById(R.id.textView14);
        String carText;

        //CarSettingActivity.year = "1986";
        //CarSettingActivity.make = "BMW";
        //CarSettingActivity.model = "325es";

        if(CarSettingActivity.year != null && CarSettingActivity.make != null && CarSettingActivity.model != null){
            carText = "Year: " + CarSettingActivity.year + "  " + "Make: " + CarSettingActivity.make + "  " + "Model: " + CarSettingActivity.model;
            currCar.setTextColor(Color.BLACK);
        }
        else{
            carText = "No Car Selected: Click Edit Car Settings to Add or Pick a Car";
            currCar.setTextColor(Color.RED);
        }


        currCar.setText(carText);
    }
}
