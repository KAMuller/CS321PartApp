package com.gmu.kam.cs321partapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        final Button saveButton = findViewById(R.id.button7);
    }

    public void saveButton(View view){
        boolean checked = ((RadioButton)view).isChecked();
        //Which radio button was checked?
        switch (view.getId()){
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
            default:
                //please select a current car
                break;
        }//end of switch
        //update the text views
        updateCar1();
        updateCar2();
        updateCar3();
        updateCar4();
    }

    public void updateCar1(){
        EditText yearInp = findViewById(R.id.editText2);
        String yearText = yearInp.getText().toString();
        EditText makeInp = findViewById(R.id.editText3);
        String makeText = makeInp.getText().toString();
        EditText modelInp = findViewById(R.id.editText4);
        String modelText = modelInp.getText().toString();
        String updateCar1 = "Year: " + yearText + " " + "Make " + makeText + " " + "Model: " + modelText;
        TextView car1 = findViewById(R.id.textView);
        car1.setText(updateCar1);
    }

    public void updateCar2(){
        EditText yearInp = findViewById(R.id.editText5);
        String yearText = yearInp.getText().toString();
        EditText makeInp = findViewById(R.id.editText6);
        String makeText = makeInp.getText().toString();
        EditText modelInp = findViewById(R.id.editText7);
        String modelText = modelInp.getText().toString();
        String updateCar2 = "Year: " + yearText + " " + "Make: " + makeText + " " + "Model: " + modelText;
        TextView car2 = findViewById(R.id.textViewCar3);
        car2.setText(updateCar2);
    }

    public void updateCar3(){
        EditText yearInp = findViewById(R.id.editText8);
        String yearText = yearInp.getText().toString();
        EditText makeInp = findViewById(R.id.editText10);
        String makeText = makeInp.getText().toString();
        EditText modelInp = findViewById(R.id.editText11);
        String modelText = modelInp.getText().toString();
        String updateCar3 = "Year: " + yearText + " " + "Make: " + makeText + " " + "Model: " + modelText;
        TextView car3 = findViewById(R.id.textViewCar4);
        car3.setText(updateCar3);
    }

    public void updateCar4(){
        EditText yearInp = findViewById(R.id.editText9);
        String yearText = yearInp.getText().toString();
        EditText makeInp = findViewById(R.id.editText12);
        String makeText = makeInp.getText().toString();
        EditText modelInp = findViewById(R.id.editText13);
        String modelText = modelInp.getText().toString();
        String updateCar4 = "Year: " + yearText + " " + "Make: " + makeText + " " + "Model: " + modelText;
        TextView car4 = findViewById(R.id.textViewCar2);
        car4.setText(updateCar4);
    }
    //Button for saving the data
    //This button will save the data in the fields and update the static variables with the
    //selected car
    //public void Save(){

    //}
}
