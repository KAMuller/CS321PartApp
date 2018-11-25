package com.gmu.kam.cs321partapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class CarSettingActivity extends AppCompatActivity {
    static String Year = null;
    static String make = null;
    static String model = null;
    

    //method for adding cars
    public void AddCar(){
    }

    public void RemoveCar(Car car){

    }
    //

    public void SaveData(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_setting);
    }
}
