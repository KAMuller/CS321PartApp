package com.gmu.kam.cs321partapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PartActivity extends AppCompatActivity {

    public void BPadSearch(View v){

        Intent openResults = new Intent(PartActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.bPad));
        startActivity(openResults);
    }

    public void BDiskSearch(View v){

        Intent openResults = new Intent(PartActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.bDisk));
        startActivity(openResults);
    }

    public void ThermStatSearch(View v){

        Intent openResults = new Intent(PartActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.thermstat));
        startActivity(openResults);
    }

    public void RadSearch(View v){

        Intent openResults = new Intent(PartActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.radiator));
        startActivity(openResults);
    }

    public void RadHoseSearch(View v){

        Intent openResults = new Intent(PartActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.radHose));
        startActivity(openResults);
    }

    public void FPumpSearch(View v){

        Intent openResults = new Intent(PartActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.fPump));
        startActivity(openResults);
    }

    public void WBladesSearch(View v){

        Intent openResults = new Intent(PartActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.wBlades));
        startActivity(openResults);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part);
    }

    @Override
    public void onResume(){
        super.onResume();

        TextView currCar = findViewById(R.id.textView17);
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
