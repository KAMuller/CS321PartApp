package com.gmu.kam.cs321partapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CarSettingActivity extends AppCompatActivity {
    //Array for holding the car objects
    private Object carList[] =  new Object[4];
    //Array counter
    private int count = 0;

    //method for adding cars
    public void newCar(){

        //need to input the information here
        String year = "";
        String make = "";
        String model = "";
        //
        Car car = new Car();
        car.setYear(year);
        car.setMake(make);
        car.setModel(model);
        
        //adding the new car to the list
        carList[count] = car;
        count++;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_setting);
    }
}
