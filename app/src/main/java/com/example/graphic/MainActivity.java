package com.example.graphic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout main;
    private final ConstraintLayout[] fingersField = new ConstraintLayout[5];

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("RRRRR", "onCreate()");
        setContentView(R.layout.activity_main);
        main = findViewById(R.id.main);
        fingersField[0] = findViewById(R.id.finger1cr);
        fingersField[1] = findViewById(R.id.finger2cr);
        fingersField[2] = findViewById(R.id.finger3cr);
        fingersField[3] = findViewById(R.id.finger4cr);
        fingersField[4] = findViewById(R.id.finger5cr);

        main.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_POINTER_DOWN:
                        fingersField[event.getPointerId(event.getActionIndex())].setBackgroundColor(Color.YELLOW);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_POINTER_UP:
                        fingersField[event.getPointerId(event.getActionIndex())].setBackgroundColor(Color.WHITE);
                        break;
                }
                return true;
            }
        });
    }
}