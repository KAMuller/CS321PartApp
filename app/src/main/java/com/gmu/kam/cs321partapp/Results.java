package com.gmu.kam.cs321partapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Results extends AppCompatActivity {

    //crawler input format String "Year Make Model Keyword"




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
    }
}
