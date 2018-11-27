package com.gmu.kam.cs321partapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * @author Kalman Muller
 */
public class BaseMenu extends AppCompatActivity {


// the onClick method for the Keyword Search button. starts the KeySearchActivity
        public void openKeySearch(View v){
            startActivity(new Intent(BaseMenu.this, KeySearchActivity.class));
        }
    // the onClick method for the Quick Search button. starts the CatSearchActivity
        public void openCatSearch(View v){
            startActivity(new Intent(BaseMenu.this, CatSearchActivity.class));
        }
    // the onClick method for the Edit Car Settings button. starts the CarSettingActivity
        public void openCarSetting(View v){
            startActivity(new Intent(BaseMenu.this, CarSettingActivity.class));
        }
//method used to initially load saved car information when the app first starts
        private void getCarPref(){
            //loads the preferences to get the saved values
            Context context = getApplicationContext();
            SharedPreferences carPref = PreferenceManager.getDefaultSharedPreferences(context);
            //finds the currently selected car from the saved information and sets the static variables to those values. else it sets them to "none"
            if(carPref.getBoolean("1CURRENTCAR?", false)){
                CarSettingActivity.year = carPref.getString("YEAR1","none");
                CarSettingActivity.make = carPref.getString("MAKE1","none");
                CarSettingActivity.model = carPref.getString("MODEL1","none");
            }
            else if(carPref.getBoolean("2CURRENTCAR?", false)){
                CarSettingActivity.year = carPref.getString("YEAR2","none");
                CarSettingActivity.make = carPref.getString("MAKE2","none");
                CarSettingActivity.model = carPref.getString("MODEL2","none");
            }
            else if(carPref.getBoolean("3CURRENTCAR?", false)){
                CarSettingActivity.year = carPref.getString("YEAR3","none");
                CarSettingActivity.make = carPref.getString("MAKE3","none");
                CarSettingActivity.model = carPref.getString("MODEL3","none");
            }
            else if(carPref.getBoolean("4CURRENTCAR?", false)){
                CarSettingActivity.year = carPref.getString("YEAR4","none");
                CarSettingActivity.make = carPref.getString("MAKE4","none");
                CarSettingActivity.model = carPref.getString("MODEL4","none");
            }
            else {
                CarSettingActivity.year = "none";
                CarSettingActivity.make = "none";
                CarSettingActivity.model ="none";
            }
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_menu);
        setTitle(getResources().getString(R.string.AppTitle));
        //loads the saved car information
        getCarPref();


    }

    @Override
    public void onResume(){
        super.onResume();
//creates the textview object that displays the current car information
        TextView currCar = findViewById(R.id.textView4);
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
