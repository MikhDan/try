package com.example.mad_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

Button _btn2, _btn1;
ImageButton _imgBtn;
AnimationDrawable _animBtn, _animImgBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _btn2  = (Button) findViewById(R.id.btn2);
        _btn2.setBackgroundResource(R.drawable.anim1);
        _animBtn = (AnimationDrawable) _btn2.getBackground();
        _animBtn.setOneShot(false);
        _btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _animBtn.stop();
                _animBtn.start();
            }
        });

        _imgBtn = (ImageButton) findViewById(R.id.imgBtn);
        _imgBtn.setBackgroundResource(R.drawable.anim2);
        _imgBtn.setImageDrawable(null);
        _animImgBtn = (AnimationDrawable) _imgBtn.getBackground();
        _animImgBtn.setOneShot(true);
        _imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _animImgBtn.stop();
                _animImgBtn.start();
                _animBtn.stop();
            }
        });

    }
}