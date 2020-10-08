package com.github.Tesa27.bootcamp.sweng_week2;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.LocationManager;
import android.location.LocationProvider;

import androidx.core.app.ActivityCompat;

public class LocationServiceClass implements LocationService {

    LocationManager locationManager;
    LocationProvider locationProvider;
    Criteria locatioCriteria;

    public LocationServiceClass(LocationManager locationManager, LocationProvider locationProvider, Criteria locationCriteria){
        this.locationManager = locationManager;
        this.locationProvider = locationProvider;
        this.locatioCriteria = locationCriteria;
    }
    @Override
    public Location getCurrentLocation() {
        try {
            android.location.Location l = locationManager.getLastKnownLocation(locationManager.getBestProvider(this.locatioCriteria, true));
            Location loc = new Location(l.getLatitude(), l.getLongitude());
            return loc;
        }catch (SecurityException e) {
            System.out.println("location manager did not succeed");
            throw e;
        }
    }
}
