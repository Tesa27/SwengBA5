package com.github.Tesa27.bootcamp.sweng_week2;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class WeatherServiceClass implements  WeatherService {
    @Override
    public String displayWeather(Location location) {
        double lat = location.latitude;
        double lon = location.longitude;
        String appid = "46c6aeab4f3c486ec9701bed6d8f2b43";
        String response = " ";

        String queryUrl = String.format("https://api.openweathermap.org/data/2.5/onecall?lat= %lf &lon= %lf &exclude=hourly,daily&appid={%s}", lat, lon, appid);
        URL url = null;
        try {
            url = new URL(queryUrl);
        }catch (Exception e ){
            System.out.println("Bad URL :  exit");
        }

        InputStream stream = null;
        HttpsURLConnection connection = null;
        try {
            connection = (HttpsURLConnection) url.openConnection();
            connection.setReadTimeout(3000);
            connection.setConnectTimeout(3000);
            connection.setRequestMethod("GET");
        }catch (Exception e){
            System.out.println("There was an exception when opening a channel");
        }

// Already true by default but setting just in case; needs to be true since this request
// is carrying an input (response) body.
        connection.setDoInput(true);
        try {
            int responseCode = connection.getResponseCode();
        }catch (Exception e){
            System.out.println("failed to fet response code");
        }
// Do something with responseCode
        try {
            stream = connection.getInputStream();
            response = connection.getResponseMessage();
        }catch (Exception e){
            System.out.println("Input Stream failed");
        }
// Do something with the stream
        try {
            stream.close();
        }catch (Exception e){
            System.out.println("Couldn't close stream");
        }
        connection.disconnect();
        return response;
    }
}
