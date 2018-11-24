package com.gmu.kam.cs321partapp;

public class Car {
    //strings for holding the information
    String Year;
    String Make;
    String Model;
    //Empty Constructor
    public void Car(){

    }
    //Full constructor
    public void Car(String year, String make, String model){
        this.Year = year;
        this.Make = make;
        this.Model = model;
    }

    //Getters and Setters
    public String getYear() {
        return Year;
    }

    public String getModel() {
        return Model;
    }

    public String getMake() {
        return Make;
    }

    public void setYear(String year) {
        Year = year;
    }

    public void setModel(String model) {
        Model = model;
    }

    public void setMake(String make) {
        Make = make;
    }
}
