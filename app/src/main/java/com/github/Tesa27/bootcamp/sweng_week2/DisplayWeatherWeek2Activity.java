package com.github.Tesa27.bootcamp.sweng_week2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.github.Tesa27.bootcamp.R;

public class DisplayWeatherWeek2Activity extends AppCompatActivity {

    TextView textView;
    CheckBox checkBox;
    Location current;
    main_week2 w2 = new main_week2();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_weather_week2);
        textView = findViewById(R.id.text_result_week2);
        checkBox = findViewById(R.id.checkBox_week2);
        if(w2.checkBox != null)
            System.out.println("reached this points at least");

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    textView.setText("You shall wait until this part is implemented");

                }else{
                    LocationServiceClass location = new LocationServiceClass();
                    current = location.getCurrentLocation();
                    WeatherService weatherService = new WeatherServiceClass();
                    textView.setText(weatherService.displayWeather(current));
                }
            }
        });
    }
}