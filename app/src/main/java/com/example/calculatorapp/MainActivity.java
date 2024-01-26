package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MaterialButton btn0 , btn1 , btn2 , btn3 , btn4 , btn5 , btn6 , btn7, btn8 , btn9 , DEL , OFF , ON , AC , add , multiply , substract, divide,dot,iseqaulto;

    double firstNum;
    String Operation;


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
        btn0 = findViewById(R.id.num0);
        DEL = findViewById(R.id.del);
        OFF = findViewById(R.id.off);
        ON = findViewById(R.id.on);
        AC = findViewById(R.id.AC);
        add = findViewById(R.id.add);
        multiply = findViewById(R.id.multiply);
        substract = findViewById(R.id.subtract);
        divide = findViewById(R.id.divide);
        dot = findViewById(R.id.numdot);
        iseqaulto = findViewById(R.id.isequalto);

        TextView screen = findViewById(R.id.screen);

        AC.setOnClickListener(view -> {
            firstNum = 0;
            screen.setText("0");
        });

        OFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
                screen.setVisibility(View.GONE);
            }
        });

        ON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
                screen.setVisibility(View.VISIBLE);
                screen.setText("0");
            }
        });


        ArrayList<Button> nums = new ArrayList<>();
        nums.add(btn0);
        nums.add(btn1);
        nums.add(btn2);
        nums.add(btn3);
        nums.add(btn4);
        nums.add(btn5);
        nums.add(btn6);
        nums.add(btn7);
        nums.add(btn8);
        nums.add(btn9);

        for(Button b : nums){
            b.setOnClickListener(view -> {
                play();
                if(!screen.getText().toString().equals("0")){
                    screen.setText(screen.getText().toString() + b.getText().toString());
                }else{
                    screen.setText(b.getText());
                }
            });
        }

        ArrayList<Button> opers = new ArrayList<>();
        opers.add(add);
        opers.add(multiply);
        opers.add(substract);
        opers.add(divide);

        for(Button b : opers){
            b.setOnClickListener(view -> {
                play();
                firstNum = Double.parseDouble(screen.getText().toString());
                Operation = b.getText().toString();
                screen.setText("0");
            });
        }

        DEL.setOnClickListener(view -> {
            play();
            String num = screen.getText().toString();
            if(num.length()>1){
                screen.setText(num.substring(0,num.length()-1));
            }else if(num.length() == 1 && !num.equals("0")){
                screen.setText("0");
            }
        });


        dot.setOnClickListener(view -> {
            play();
            if(!screen.getText().toString().contains(".")){
                screen.setText(screen.getText().toString()+".");
            }
        });

        iseqaulto.setOnClickListener(view -> {
            play();
            double secondNum = Double.parseDouble(screen.getText().toString());
            double result;
            switch(Operation){
                case "+" :
                    result = firstNum + secondNum ;
                    break;

                case "-":
                    result = firstNum - secondNum;
                    break;

                case "/":
                    result = firstNum / secondNum;
                    break;

                case "*":
                    result = firstNum * secondNum;
                    break;

                default:
                    result = firstNum + secondNum;
            }
            screen.setText(String.valueOf(result));
            firstNum = result;
        });

    }

    MediaPlayer player;

    public void play(){
        if(player==null){
            player = MediaPlayer.create(this,R.raw.click);
        }
        player.start();
    }

}