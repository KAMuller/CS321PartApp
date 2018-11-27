package com.gmu.kam.cs321partapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/**
 * @author Kalman Muller
 */
public class KeySearchActivity extends AppCompatActivity {


// onClick method for the search button. gets the text from the editText view adds the string to the intent and starts Results
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
        setTitle(getResources().getString(R.string.AppTitle));
    }

    @Override
    public void onResume(){
        super.onResume();
//creates the textview object that displays the current car information
        TextView currCar = findViewById(R.id.textView3);
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
