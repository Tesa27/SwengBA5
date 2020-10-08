package com.github.Tesa27.bootcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class activity_greeting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
	System.out.println("this is to illustrate git conflict when dealing with multiple repos");
    }
}