package com.gmu.kam.cs321partapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

public abstract class CarSettingActivity extends AppCompatActivity {
    //ArrayList for holding the car objects
    ArrayList CarList = new ArrayList(4);
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
        
        //adding the new car
        CarList.add(car);
    }

    public boolean removeCar(Car car){
        CarList.remove(car);
        return false;
    }

    public void EditCar(){

    }

    public void SaveData(){

    }

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_setting);
    }
}
