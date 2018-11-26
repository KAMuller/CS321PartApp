package com.gmu.kam.cs321partapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class Results extends AppCompatActivity {

    //crawler input is searchTerm String in OnResume method"

    private ArrayList<Crawl.Product> results;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
    }

    @Override
    public void onResume(){
        super.onResume();

        Intent in = getIntent();
        String keyword = in.getStringExtra("KEYWORD");
        String searchTerm = CarSettingActivity.year + " " + CarSettingActivity.make + " " + CarSettingActivity.model + " " + keyword;
        //Kiran: put your code here to implement your script and output to the Arraylist below


        ArrayList<String> urls;
        Crawl crawler = new Crawl(urls);
        ArrayList<Crawl.Product> results = crawler.getProducts();
        


    }
}
