package com.gmu.kam.cs321partapp;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class KeySearchActivity extends AppCompatActivity {



    public void search(View v){

        TextInputLayout keyInp = findViewById(R.id.textInputLayout);
        String keyString = keyInp.getEditText().getText().toString();

        Intent openResults = new Intent(KeySearchActivity.this, Results.class);
        openResults.putExtra("KEYWORD", keyString);
        startActivity(openResults);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_search);
    }
}
