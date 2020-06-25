package com.example.myapplication.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class TestTouchActivity extends AppCompatActivity {

    private Button button;
    private TextView textview;
    private ImageView imageview;
    private MyLayout linearlayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_touch);

        button = (Button) findViewById(R.id.button);
        textview = (TextView) findViewById(R.id.textview);
        imageview = (ImageView) findViewById(R.id.imageview);
        linearlayout = (MyLayout) findViewById(R.id.linearlayout);

        linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "linearlayout onClick execute");
            }
        });

        linearlayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("TAG", "linearlayout onTouch execute, action " + event.getAction());
                return true;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "button onClick execute");
            }
        });

//        button.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.d("TAG", "button onTouch execute, action " + event.getAction());
//                return true;
//            }
//        });

        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "onClick execute");
            }
        });

        textview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("TAG", "onTouch execute, action " + event.getAction());
                return false;
            }
        });

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "onClick execute");
            }
        });

        imageview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("TAG", "onTouch execute, action " + event.getAction());
                return false;
            }
        });

    }
}
