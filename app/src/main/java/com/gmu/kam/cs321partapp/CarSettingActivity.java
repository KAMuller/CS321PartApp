package com.gmu.kam.cs321partapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

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
        final Button saveButton = findViewById(R.id.button7);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //is the button checked?
                boolean checked = ((RadioButton) v).isChecked();
                //Which radio button was checked?
                switch (v.getId()){
                    case R.id.radioCar1:
                        if(checked){
                            //set the static variables with the values in the fields
                            EditText yearInp = findViewById(R.id.editText2);
                            year = yearInp.getText().toString();

                            EditText makeInp = findViewById(R.id.editText3);
                            make = makeInp.getText().toString();

                            EditText modelInp = findViewById(R.id.editText4);
                            model = modelInp.getText().toString();
                        }
                        break;
                    case R.id.radioCar2:
                        if(checked){
                            //set the static variables with the values in the fields
                            EditText yearInp = findViewById(R.id.editText5);
                            year = yearInp.getText().toString();

                            EditText makeInp = findViewById(R.id.editText6);
                            make = makeInp.getText().toString();

                            EditText modelInp = findViewById(R.id.editText7);
                            model = modelInp.getText().toString();
                        }
                        break;
                    case R.id.radioCar3:
                        if(checked){
                            //set the static variables with the values in the fields
                            EditText yearInp = findViewById(R.id.editText8);
                            year = yearInp.getText().toString();

                            EditText makeInp = findViewById(R.id.editText10);
                            make = makeInp.getText().toString();

                            EditText modelInp = findViewById(R.id.editText11);
                            model = modelInp.getText().toString();
                        }
                        break;
                    case R.id.radioCar4:
                        if(checked){
                            //set the static variables with the values in the fields
                            EditText yearInp = findViewById(R.id.editText9);
                            year = yearInp.getText().toString();

                            EditText makeInp = findViewById(R.id.editText12);
                            make = makeInp.getText().toString();

                            EditText modelInp = findViewById(R.id.editText13);
                            model = modelInp.getText().toString();
                        }
                        break;
                }//end of switch

                // save the car info.
            }
        });

    }

    //Button for saving the data
    //This button will save the data in the fields and update the static variables with the
    //selected car
    //public void Save(View v){

    //}
}
