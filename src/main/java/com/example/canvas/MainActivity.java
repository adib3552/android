package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CustomView custom;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        custom=(CustomView)findViewById(R.id.view);
    }

    public void btnClick(View view) {
        custom.swapColor();
    }
}