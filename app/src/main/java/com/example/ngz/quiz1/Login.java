package com.example.ngz.quiz1;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    NumberPicker nb1,nb2,nb3;
    Button btn1;
    int number_P1,number_P2,number_P3;
    String Number1,Number2,Number3,sum;

    private Process Process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Process = new Process(this);

        btn1 = (Button)findViewById(R.id.button5);
        nb1 = (NumberPicker)findViewById(R.id.numberPicker1);
        nb2 = (NumberPicker)findViewById(R.id.numberPicker2);
        nb3 = (NumberPicker)findViewById(R.id.numberPicker3);

        nb1.setMaxValue(9);
        nb1.setMinValue(0);
        nb1.setWrapSelectorWheel(true);

        nb2.setMaxValue(9);
        nb2.setMinValue(0);
        nb2.setWrapSelectorWheel(true);

        nb3.setMaxValue(9);
        nb3.setMinValue(0);
        nb3.setWrapSelectorWheel(true);

        nb1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                number_P1 = nb1.getValue();
            }
        });
        nb2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                number_P2 = nb2.getValue();
            }
        });
        nb3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                number_P3 = nb3.getValue();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Number1 = Integer.toString(number_P1);
                Number2 = Integer.toString(number_P2);
                Number3 = Integer.toString(number_P3);
                sum = Number1+Number2+Number3;

                boolean Success =  Process.CheckLogin(sum);

                if (Success){
                    Toast t1= Toast.makeText(getApplicationContext(),"โหดสัสอะครับ", Toast.LENGTH_LONG);
                    t1.show();

                    Intent i1 = new Intent(getApplicationContext(),Money.class);
                    startActivity(i1);
                }
                else {
                    Toast t2= Toast.makeText(getApplicationContext(),"กากสัสอะครับ", Toast.LENGTH_LONG);
                    t2.show();

                    Intent i2 = new Intent(getApplicationContext(),Prison.class);
                    startActivity(i2);
                }
            }
        });

    }
}
