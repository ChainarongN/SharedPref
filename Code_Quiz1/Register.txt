package com.example.ngz.quiz1;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends AppCompatActivity{

    Button btn1;
    EditText edt1;
    private Process Process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        btn1 = (Button)findViewById(R.id.button3);
        edt1 = (EditText) findViewById(R.id.editText);

        Process = new Process(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edt1.getText().toString().isEmpty()){

                    Toast t = Toast.makeText(getApplicationContext(),"Please input number", Toast.LENGTH_LONG);
                    edt1.requestFocus();
                    t.show();
                }

                else{
                    boolean S = Process.Register(edt1.getText().toString());

                        Toast t3= Toast.makeText(getApplicationContext(),"Save = " + edt1.getText(), Toast.LENGTH_LONG);
                        t3.show();
                        finish();

                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);

                }
            }
        });

    }
}
