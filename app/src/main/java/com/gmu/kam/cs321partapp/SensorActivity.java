package com.gmu.kam.cs321partapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
/**
 * @author Kalman Muller
 */
public class SensorActivity extends AppCompatActivity {
    // onClick method for the button. gets the text from the @string xml resource file, adds the string to the intent and starts Results
    public void O2SenSearch(View v){

        Intent openResults = new Intent(SensorActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.o2sen));
        startActivity(openResults);
    }
    // onClick method for the button. gets the text from the @string xml resource file, adds the string to the intent and starts Results
    public void MafSenSearch(View v){

        Intent openResults = new Intent(SensorActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.mafSen));
        startActivity(openResults);
    }
    // onClick method for the button. gets the text from the @string xml resource file, adds the string to the intent and starts Results
    public void TempSenSearch(View v){

        Intent openResults = new Intent(SensorActivity.this, Results.class);
        openResults.putExtra("KEYWORD", getResources().getString(R.string.tempSen));
        startActivity(openResults);
    }
    // the onClick method for the Edit Car Settings button. starts the CarSettingActivity
    public void openCarSetting(View v){
        startActivity(new Intent(SensorActivity.this, CarSettingActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        setTitle(getResources().getString(R.string.AppTitle));
    }

    @Override
    public void onResume(){
        super.onResume();
//creates the textview object that displays the current car information
        TextView currCar = findViewById(R.id.textView15);
        String carText;
//if there is no car information it sets the message below
        if(CarSettingActivity.year.equals("none") || CarSettingActivity.make.equals("none") || CarSettingActivity.model.equals("none")){
            carText = "No Car Selected: Click Edit Car Settings to Add or Pick a Car";
            currCar.setTextColor(Color.RED);
        }
        //if there is car information is sets the concatenated string below
        else{
            carText = "Year: " + CarSettingActivity.year + "  " + "Make: " + CarSettingActivity.make + "  " + "Model: " + CarSettingActivity.model;
            currCar.setTextColor(Color.BLACK);
        }


        currCar.setText(carText);
    }
}
