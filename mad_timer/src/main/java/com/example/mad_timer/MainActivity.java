package com.example.mad_timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

Button _btnStart, _btnStop, _btn1Start, _btn1Stop;

TextView _lblTimer, _lblVremya;

int sek=0;

Timer _timer1, _timer2;

TimerTask _task1, _task2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _btnStart  =(Button) findViewById(R.id.btnstart);
        _btnStop  =(Button) findViewById(R.id.btnstop);
        _lblTimer = (TextView) findViewById(R.id.lbltimer);
        _btn1Start  =(Button) findViewById(R.id.btnstart1);
        _btn1Stop  =(Button) findViewById(R.id.btnstop1);
        _lblVremya = (TextView) findViewById(R.id.lblvremya);

        _btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_timer1!=null) _timer1.cancel();
                _timer1 = new Timer();

                _task1 = new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                _lblTimer.setText(String.valueOf(sek));
                                sek+=1;
                            }
                        });
                    }
                };

                _timer1.schedule(_task1, 0,1000);
            }
        });

        _btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sek=0;
                if(_timer1!=null) {
                    _timer1.cancel();
                    _timer1=null;
                }
            }
        });

        _btn1Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_timer2!=null) _timer2.cancel();
                _timer2  = new Timer();

                _task2 = new MyTimerTask();
                _timer2.schedule(_task2,0,1000);

            }
        });

        _btn1Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sek=0;
                if(_timer2!=null) {
                    _timer2.cancel();
                    _timer2=null;
                }
            }
        });



    }

SimpleDateFormat simple;

class MyTimerTask extends TimerTask{
    @Override
    public void run() {
        simple = new SimpleDateFormat("dd-MMMM-yy HH:mm:ss", Locale.getDefault());
        TimeZone timeZone = TimeZone.getTimeZone("UTC+3");
        Calendar calendar = Calendar.getInstance(timeZone);
        String strData = simple.format(calendar.getTime());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                _lblVremya.setText(strData);
            }
        });
    }
}
}
























