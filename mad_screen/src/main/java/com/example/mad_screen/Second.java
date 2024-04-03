package com.example.mad_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Second extends AppCompatActivity {
TextView _lbl1;

Button _btn1, _btn2;
Random rnd=new Random();
int n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        _lbl1=(TextView) findViewById(R.id.lbl1);
        _btn1=(Button) findViewById(R.id.btn1);
        _btn2=(Button) findViewById(R.id.btn2);

        _btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                _btn1.setBackgroundColor(Color.GREEN);
                _lbl1.setText("Нажали кнопку 1");
                n++;
                _lbl1.setText(_lbl1.getText() + " = " + String.valueOf(n));

            }
        });


        View.OnClickListener click_btn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r = rnd.nextInt(251);
                int g = rnd.nextInt(15);
                int b = rnd.nextInt(150);
                v.setBackgroundColor(Color.rgb(r,g,b));
                _lbl1.setText("Нажали кнопку 2");
                n++;
                _lbl1.setText(_lbl1.getText() + " = " + String.valueOf(n));


            }
        };
        _btn2.setOnClickListener(click_btn);
    }
}