package com.example.calculator_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.calculator_basic.R;

public class ResultPage extends AppCompatActivity {

    String gender;
    float bmi;

    TextView messageTv, bmiTv;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        bmi = getIntent().getFloatExtra("bmi",0);
        gender = getIntent().getStringExtra("gender");


        bmiTv =findViewById(R.id.bmi_tv);
        messageTv = findViewById(R.id.message_tv);
        img = findViewById(R.id.img);
        img.setVisibility(View.VISIBLE);
        String msg;
        if(bmi<18){
            msg= " You're Under Weight";

            if(gender.equals("male")){
                img.setImageDrawable(getResources().getDrawable(R.drawable.boy_normal));
            }
            else{
                img.setImageDrawable(getResources().getDrawable(R.drawable.girl_normal));
            }
        }
        else if(bmi > 18 & bmi<24){

            msg= " You're Fit";
            if(gender.equals("male")){
                img.setImageDrawable(getResources().getDrawable(R.drawable.boy_normal));
            }
            else{
                img.setImageDrawable(getResources().getDrawable(R.drawable.girl_normal));
            }

        }
        else{

            msg= " You're Over Weight";
            if(gender.equals("male")){
                img.setImageDrawable(getResources().getDrawable(R.drawable.boy_overweight));
            }
            else{
                img.setImageDrawable(getResources().getDrawable(R.drawable.girl_overweight));
            }

        }
        messageTv.setText(msg);
        bmiTv.setText(String.format("%.2f", bmi));

    }
}