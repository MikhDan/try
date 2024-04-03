package com.example.mad_many;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Radio extends AppCompatActivity {
    RadioButton _rb1, _rb2, _rb3;
    Intent _intent;
    String s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        _rb1 = (RadioButton) findViewById(R.id.rb1);
        _rb2 = (RadioButton) findViewById(R.id.rb2);
        _rb3 = (RadioButton) findViewById(R.id.rb3);

        _rb1.setTag(" птица"+" ves=10");
        _rb2.setTag(" речной"+" ves=1");
        _rb3.setTag(" рыба"+" ves=5");

//        _rb1.setTag(0);
//        _rb2.setTag(1);
//        _rb3.setTag(2);

        View.OnClickListener click_radio= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _intent = new Intent();

                if (v == _rb1) s=_rb1.getText().toString();
                if (v == _rb2) s=_rb2.getText().toString();
                if (v == _rb3) s=_rb3.getText().toString();

                s+=v.getTag().toString();

                _intent.putExtra("edit31",s);
                setResult(RESULT_OK,_intent);
                finish();
            }
        };

        _rb1.setOnClickListener(click_radio);
        _rb2.setOnClickListener(click_radio);
        _rb3.setOnClickListener(click_radio);
    }
}