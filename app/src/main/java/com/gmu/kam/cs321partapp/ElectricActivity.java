package com.gmu.kam.cs321partapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ElectricActivity extends AppCompatActivity {

    public void BatSearch(View v){

        Intent openResults = new Intent(ElectricActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.bat));
        startActivity(openResults);
    }

    public void AlterSearch(View v){

        Intent openResults = new Intent(ElectricActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.alter));
        startActivity(openResults);
    }

    public void PlugSearch(View v){

        Intent openResults = new Intent(ElectricActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.plug));
        startActivity(openResults);
    }

    public void StartMotSearch(View v){

        Intent openResults = new Intent(ElectricActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.startMot));
        startActivity(openResults);
    }

    public void PlugWireSearch(View v){

        Intent openResults = new Intent(ElectricActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.plugWire));
        startActivity(openResults);
    }

    public void FBulbSearch(View v){

        Intent openResults = new Intent(ElectricActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.fBulb));
        startActivity(openResults);
    }

    public void RBulbSearch(View v){

        Intent openResults = new Intent(ElectricActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.rBulb));
        startActivity(openResults);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric);
    }

    @Override
    public void onResume(){
        super.onResume();

        TextView currCar = findViewById(R.id.textView16);
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
