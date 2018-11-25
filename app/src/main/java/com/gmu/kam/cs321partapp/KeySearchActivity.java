package com.gmu.kam.cs321partapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class KeySearchActivity extends AppCompatActivity {



    public void search(View v){

        EditText keyInp = findViewById(R.id.editText);
        String keyString = keyInp.getText().toString();

        Intent openResults = new Intent(KeySearchActivity.this, Results.class);
        openResults.putExtra("KEYWORD", keyString);
        startActivity(openResults);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_search);
    }

    @Override
    public void onResume(){
        super.onResume();

        TextView currCar = findViewById(R.id.textView3);
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
