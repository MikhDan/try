package com.example.mad_many;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText _txt1;
    Button _btn12, _btn13;
    static private int code =0;
    static String s="hello";
    Intent _intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _btn12 = (Button) findViewById(R.id.btn12);
        _btn13 = (Button) findViewById(R.id.btn13);
        _txt1 = (EditText) findViewById(R.id.txt1);

        _btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code=0;
                _intent= new Intent(getApplication(), Two.class);
                _intent.putExtra("edit12", _txt1.getText().toString());
                startActivityForResult(_intent, code);
            }
        });

        _btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code=1;
                _intent= new Intent(getApplication(), Radio.class);
                startActivityForResult(_intent, code);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0)
            if(resultCode==RESULT_OK)
            {
                s=data.getStringExtra("edit21");
            }
            else s= "error 2222222";
        _txt1.setText(s);
        if(requestCode==1)
            if(resultCode==RESULT_OK)
            {
                s=data.getStringExtra("edit31");
            }
            else
                s= "error 3333333";
        _txt1.setText(s);


    }
}