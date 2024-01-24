package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    MaterialButton btn0 , btn1 , btn2 , btn3 , btn4 , btn5 , btn6 , btn7, btn8 , btn9 , DEL , OFF , ON , AC , add , multiply , substract, divide,dot,iseqaulto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = findViewById(R.id.num1);
        btn2  = findViewById(R.id.num2);
        btn3  = findViewById(R.id.num3);
        btn4  = findViewById(R.id.num4);
        btn5  = findViewById(R.id.num5);
        btn6  = findViewById(R.id.num6);
        btn7  = findViewById(R.id.num7);
        btn8  = findViewById(R.id.num8);
        btn9  = findViewById(R.id.num9);





    }
}