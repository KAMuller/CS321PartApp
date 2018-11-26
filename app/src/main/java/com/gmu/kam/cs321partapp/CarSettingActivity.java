package com.gmu.kam.cs321partapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


/*
    Created by Jonathan on 11/12/18
 */
public class CarSettingActivity extends AppCompatActivity {
    static String year = null;
    static String make = null;
    static String model = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_setting);
        //load from preferences
    }

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
                    getInfo(info1);
                }
                if(car2.isChecked()){
                    //set the static variables with the values in the fields
                    TextView info2 = findViewById(R.id.textViewCar3);
                    getInfo(info2);
                }
                if(car3.isChecked()) {
                    //set the static variables with the values in the fields
                    TextView info3 = findViewById(R.id.textViewCar4);
                    getInfo(info3);
                }
                if(car4.isChecked()) {
                    //set the static variables with the values in the fields
                    TextView info4 = findViewById(R.id.textViewCar2);
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
        year = values[0];
        make = values[1];
        model = values[2];
    }
    public void updateCar1(){
        EditText yearInp = findViewById(R.id.editText2);
        String yearText = yearInp.getText().toString();
        EditText makeInp = findViewById(R.id.editText3);
        String makeText = makeInp.getText().toString();
        EditText modelInp = findViewById(R.id.editText4);
        String modelText = modelInp.getText().toString();
        if(!yearText.isEmpty() || !makeText.isEmpty() || !modelText.isEmpty()) {
            String updateCar1 = "Year: " + yearText + " " + "Make: " + makeText + " " + "Model: " + modelText;
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
            String updateCar2 = "Year: " + yearText + " " + "Make: " + makeText + " " + "Model: " + modelText;
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
            String updateCar3 = "Year: " + yearText + " " + "Make: " + makeText + " " + "Model: " + modelText;
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
            String updateCar4 = "Year: " + yearText + " " + "Make: " + makeText + " " + "Model: " + modelText;
            TextView car4 = findViewById(R.id.textViewCar2);
            car4.setText(updateCar4);
        }

    }


    //Button for saving the data
    //This button will save the data in the fields and update the static variables with the
    //selected car
    public void saveData(){

    }


}
