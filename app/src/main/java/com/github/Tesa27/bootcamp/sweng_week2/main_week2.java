package com.github.Tesa27.bootcamp.sweng_week2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.github.Tesa27.bootcamp.R;

public class main_week2 extends AppCompatActivity {
    Button b;
    public  CheckBox checkBox;
    Location current;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_week2);
        b = findViewById(R.id.button_weather_week2);
        checkBox = findViewById(R.id.checkBox_week2);
        textView = findViewById(R.id.textView_week2);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // displayWeather();
                if(checkBox.isChecked()){
                    textView.setText("waiting to be implemented");
                }else {
                    LocationServiceClass location = new LocationServiceClass();
                    current = location.getCurrentLocation();
                    WeatherService weatherService = new WeatherServiceClass();
                    textView.setText(weatherService.displayWeather(current));
                }
            }
        });
    }
    public void displayWeather(){
        Intent intent = new Intent(this, DisplayWeatherWeek2Activity.class);
        startActivity(intent);
    }
}