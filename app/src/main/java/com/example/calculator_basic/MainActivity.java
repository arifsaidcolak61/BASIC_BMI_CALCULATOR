package com.example.calculator_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText heightEt, weightEt;
    RadioGroup genderRg;
    Button btn;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightEt = findViewById(R.id.height_et);
        weightEt = findViewById(R.id.weight_et);
        genderRg = findViewById(R.id.gender_rg);
        btn = findViewById(R.id.bmi_btn);

        genderRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.female_rb){
                    gender = "female";
                }
                else{
                    gender = "male";
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightVal = heightEt.getText().toString().trim();
                String weightVal = weightEt.getText().toString().trim();

                float height = Float.parseFloat(heightVal);
                float weight = Float.parseFloat(weightVal);
                float bmi = calBMI(height, weight);

                Intent intent = new Intent(MainActivity.this, ResultPage.class);
                intent.putExtra("bmi", bmi);
                intent.putExtra("gender",gender);
                startActivity(intent);


            }

            public float calBMI(float h, float w){

                float bmi =0;
                float h_meter = h/100;
                bmi = w/(h_meter * h_meter);

                return bmi;
            }
        });
    }
}