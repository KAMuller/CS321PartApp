package com.gmu.kam.cs321partapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BaseMenu extends AppCompatActivity {



        public void openKeySearch(View v){
            startActivity(new Intent(BaseMenu.this, KeySearchActivity.class));
        }
        public void openCatSearch(View v){
            startActivity(new Intent(BaseMenu.this, CatSearchActivity.class));
        }
        public void openCarSetting(View v){
            startActivity(new Intent(BaseMenu.this, CarSettingActivity.class));
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_menu);

    }
}
