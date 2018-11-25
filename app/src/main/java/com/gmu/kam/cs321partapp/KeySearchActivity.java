package com.gmu.kam.cs321partapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class KeySearchActivity extends AppCompatActivity {



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
    }
}
