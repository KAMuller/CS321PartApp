package com.gmu.kam.cs321partapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import java.io.File;
import android.content.Context;

import net.bytebuddy.implementation.Implementation;


/*
    Created by Jonathan on 11/12/18
 */
public class CarSettingActivity extends AppCompatActivity {
    static String year = null;
    static String make = null;
    static String model = null;
    private int currentCarNum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_setting);
        //load from preferences
        loadCarInfo();
    }

    //This method will load a file and only set the static variables.
    public void getCurrentCar(){
    SharedPreferences carTextInfo = PreferenceManager.getDefaultSharedPreferences(CarSettingActivity.this);
    
    }

    //This method will load a file from the device storage and set the appropriate values.
    public void loadCarInfo(){
        SharedPreferences carTextInfo = PreferenceManager.getDefaultSharedPreferences(CarSettingActivity.this);
        String yr = carTextInfo.getString("YEAR1","none");
        String mak = carTextInfo.getString("MAKE1","none");
        String mod = carTextInfo.getString("MODEL1","none");
        Boolean cc = carTextInfo.getBoolean("1CURRENTCAR?", false);
        if(cc == true) {
            year = yr;
            make = mak;
            model = mod;
            currentCarNum = 1;
        }
            String updateCar1 = "Year:" + yr + " " + "Make:" + mak + " " + "Model:" + mod;
            TextView car1 = findViewById(R.id.textViewCar);
            car1.setText(updateCar1);

        String yr2 = carTextInfo.getString("YEAR2","none");
        String mak2 = carTextInfo.getString("MAKE2","none");
        String mod2 = carTextInfo.getString("MODEL2","none");
        Boolean cc2 = carTextInfo.getBoolean("2CURRENTCAR?", false);
        if(cc2 == true) {
            year = yr2;
            make = mak2;
            model = mod2;
            currentCarNum = 2;
        }
            String updateCar2 = "Year:" + yr2 + " " + "Make:" + mak2 + " " + "Model:" + mod2;
            TextView car2 = findViewById(R.id.textViewCar3);
            car2.setText(updateCar2);

        String yr3 = carTextInfo.getString("YEAR3","none");
        String mak3 = carTextInfo.getString("MAKE3","none");
        String mod3 = carTextInfo.getString("MODEL3","none");
        Boolean cc3 = carTextInfo.getBoolean("3CURRENTCAR?", false);
        if(cc3 == true) {
            year = yr3;
            make = mak3;
            model = mod3;
            currentCarNum = 3;
        }
            String updateCar3 = "Year:" + yr3 + " " + "Make:" + mak3 + " " + "Model:" + mod3;
            TextView car3 = findViewById(R.id.textViewCar4);
            car3.setText(updateCar3);

        String yr4 = carTextInfo.getString("YEAR4","none");
        String mak4 = carTextInfo.getString("MAKE4","none");
        String mod4 = carTextInfo.getString("MODEL4","none");
        Boolean cc4 = carTextInfo.getBoolean("4CURRENTCAR?", false);
        if(cc4 == true) {
            year = yr4;
            make = mak4;
            model = mod4;
            currentCarNum = 4;
        }

            String updateCar4 = "Year:" + yr4 + " " + "Make:" + mak4 + " " + "Model:" + mod4;
            TextView car4 = findViewById(R.id.textViewCar2);
            car4.setText(updateCar4);                                                        
        
    }
    //Defines what happens when the "Save" button is clicked in the activity.
    //First, it will update any text views that need to be updated
    //Then it will check to see which radio button has been pressed. It will then set the static
    //values to the selected values.
    //Lastly, it will save the data to be reloaded later.
    public void saveButton(View v){
        //update the text views
        updateCar1();
        updateCar2();
        updateCar3();
        updateCar4();

        RadioButton car1 = findViewById(R.id.radioCar1);
        RadioButton car2 = findViewById(R.id.radioCar2);
        RadioButton car3 = findViewById(R.id.radioCar3);
        RadioButton car4 = findViewById(R.id.radioCar4);
        //Which radio button was checked?

                if(car1.isChecked()) {
                    //set the static variables with the values in the fields
                    TextView info1 = findViewById(R.id.textViewCar);
                    currentCarNum = 1;
                    getInfo(info1);
                }
                if(car2.isChecked()){
                    //set the static variables with the values in the fields
                    TextView info2 = findViewById(R.id.textViewCar3);
                    currentCarNum = 2;
                    getInfo(info2);
                }
                if(car3.isChecked()) {
                    //set the static variables with the values in the fields
                    TextView info3 = findViewById(R.id.textViewCar4);
                    currentCarNum = 3;
                    getInfo(info3);
                }
                if(car4.isChecked()) {
                    //set the static variables with the values in the fields
                    TextView info4 = findViewById(R.id.textViewCar2);
                    currentCarNum = 4;
                    getInfo(info4);
                }

        //save the data
        saveData();
    }
    public void getInfo(TextView info) {
        String info1 = info.getText().toString();
        info1 = info1.replace("Year:", "!");
        info1 = info1.replace("Make:", "!");
        info1 = info1.replace("Model:", "!");
        String[] values = info1.split("!");
        year = values[1];
        make = values[2];
        model = values[3];
    }
    public void updateCar1(){
        EditText yearInp = findViewById(R.id.editText2);
        String yearText = yearInp.getText().toString();
        EditText makeInp = findViewById(R.id.editText3);
        String makeText = makeInp.getText().toString();
        EditText modelInp = findViewById(R.id.editText4);
        String modelText = modelInp.getText().toString();
        if(!yearText.isEmpty() || !makeText.isEmpty() || !modelText.isEmpty()) {
            String updateCar1 = "Year:" + yearText + " " + "Make:" + makeText + " " + "Model:" + modelText;
            TextView car1 = findViewById(R.id.textViewCar);
            car1.setText(updateCar1);
        }
    }

    public void updateCar2(){
        EditText yearInp = findViewById(R.id.editText5);
        String yearText = yearInp.getText().toString();
        EditText makeInp = findViewById(R.id.editText6);
        String makeText = makeInp.getText().toString();
        EditText modelInp = findViewById(R.id.editText7);
        String modelText = modelInp.getText().toString();
        if(!yearText.isEmpty() || !makeText.isEmpty() || !modelText.isEmpty()){
            String updateCar2 = "Year:" + yearText + " " + "Make:" + makeText + " " + "Model:" + modelText;
            TextView car2 = findViewById(R.id.textViewCar3);
            car2.setText(updateCar2);
        }

    }

    public void updateCar3(){
        EditText yearInp = findViewById(R.id.editText8);
        String yearText = yearInp.getText().toString();
        EditText makeInp = findViewById(R.id.editText10);
        String makeText = makeInp.getText().toString();
        EditText modelInp = findViewById(R.id.editText11);
        String modelText = modelInp.getText().toString();
        if(!yearText.isEmpty() || !makeText.isEmpty() || !modelText.isEmpty()) {
            String updateCar3 = "Year:" + yearText + " " + "Make:" + makeText + " " + "Model:" + modelText;
            TextView car3 = findViewById(R.id.textViewCar4);
            car3.setText(updateCar3);
        }
    }

    public void updateCar4(){
        EditText yearInp = findViewById(R.id.editText9);
        String yearText = yearInp.getText().toString();
        EditText makeInp = findViewById(R.id.editText12);
        String makeText = makeInp.getText().toString();
        EditText modelInp = findViewById(R.id.editText13);
        String modelText = modelInp.getText().toString();
        if(!yearText.isEmpty()|| !makeText.isEmpty() || !modelText.isEmpty()){
            String updateCar4 = "Year:" + yearText + " " + "Make:" + makeText + " " + "Model:" + modelText;
            TextView car4 = findViewById(R.id.textViewCar2);
            car4.setText(updateCar4);
        }

    }
    private String[] getCarInfo(TextView info) {
        String[] results = {"none", "none", "none"};
        String inf = info.getText().toString();
        inf = inf.replace("Year:", "!");
        inf = inf.replace("Make:", "!");
        inf = inf.replace("Model:", "!");
        String[] val = inf.split("!");
        results[0] = val[1];
        results[1] = val[2];
        results[2] = val[3];
        return results;
    }

    //BuString[] values = info1.split("!"); tton for saving the data
    //This button will save the data in the fields to the device storage.
    public void saveData(){
        SharedPreferences carTextInfo = PreferenceManager.getDefaultSharedPreferences(CarSettingActivity.this);
        SharedPreferences.Editor edit = carTextInfo.edit();

        String[] results;
        TextView info1 = findViewById(R.id.textViewCar);
        results = getCarInfo(info1);
        edit.putString("YEAR1", results[0]);
        edit.putString("MAKE1", results[1]);
        edit.putString("MODEL1", results[2]);
        if(currentCarNum == 1){
            edit.putBoolean("1CURRENTCAR?", true);
        }
        else{
            edit.putBoolean("1CURRENTCAR?", false);
        }

        TextView info2 = findViewById(R.id.textViewCar3);
        results = getCarInfo(info2);
        edit.putString("YEAR2", results[0]);
        edit.putString("MAKE2", results[1]);
        edit.putString("MODEL2", results[2]);
        if(currentCarNum == 2){
            edit.putBoolean("2CURRENTCAR?", true);
        }
        else{
            edit.putBoolean("2CURRENTCAR?", false);
        }

        TextView info3 = findViewById(R.id.textViewCar4);
        results = getCarInfo(info3);
        edit.putString("YEAR3", results[0]);
        edit.putString("MAKE3", results[1]);
        edit.putString("MODEL3", results[2]);
        if(currentCarNum == 3){
            edit.putBoolean("3CURRENTCAR?", true);
        }
        else{
            edit.putBoolean("3CURRENTCAR?", false);
        }

        TextView info4 = findViewById(R.id.textViewCar2);
        results = getCarInfo(info4);
        edit.putString("YEAR4", results[0]);
        edit.putString("MAKE4", results[1]);
        edit.putString("MODEL4", results[2]);
        if(currentCarNum == 3){
            edit.putBoolean("4CURRENTCAR?", true);
        }
        else{
            edit.putBoolean("4CURRENTCAR?", false);

        }
        edit.apply();
    }


}
