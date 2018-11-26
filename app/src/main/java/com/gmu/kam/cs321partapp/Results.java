package com.gmu.kam.cs321partapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

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

        TextView resultView = findViewById(R.id.textView7);

        Intent in = getIntent();
        String keyword = in.getStringExtra("KEYWORD");
        String searchTerm = CarSettingActivity.year + " " + CarSettingActivity.make + " " + CarSettingActivity.model + " " + keyword;
        //Kiran: put your code here to implement your script and output to the Arraylist below

        partSearcher psearch = new partSearcher(searchTerm);
        ArrayList<String> urls = psearch.getFinalList();
        Crawl crawler = new Crawl();
        results = crawler.crawlSites(urls);
        Collections.sort(results);

        String resOutput;

        if (results != null){

            resultView.setTextColor(Color.BLACK);
            int numProducts = results.size();


            StringBuilder resBuild = new StringBuilder();
            for(int i = 0; i<numProducts; i++){
                resBuild.append(i+1);
                resBuild.append(":\n");
                resBuild.append("Name: ");
                resBuild.append(results.get(i).prodName + "\n");
                resBuild.append("Price: ");
                resBuild.append(results.get(i).prodPrice + "\n");
                resBuild.append("Link: ");
                resBuild.append(results.get(i).prodLink);
                resBuild.append("\n");

            }
            resOutput = resBuild.toString();
        }
        else{

            resultView.setTextColor(Color.RED);
            resOutput = "No Results Found" + "\n\n" + "Please verify that your Car Information and Keyword are accurate";
        }


        resultView.setText(resOutput);

    }
}
