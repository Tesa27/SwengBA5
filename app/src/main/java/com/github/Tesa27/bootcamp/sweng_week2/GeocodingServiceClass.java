package com.github.Tesa27.bootcamp.sweng_week2;

import android.app.Application;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeocodingServiceClass implements  GeocodingService {

    public Location location;
    public GeocodingServiceClass(Location l){
        location= l;
    }
    @Override
    public Location addressToLocation(Address address){
        return new Location(address.getLatitude(), address.getLongitude());
    }

    @Override
    public Address locationToAddress(Location place) {
        Application app = new Application();
        Geocoder geocoder = new Geocoder(app.getApplicationContext());
        List<Address> addressList = new ArrayList<>();
        try{
            addressList = geocoder.getFromLocation(place.longitude, place.latitude, 100);
        }catch (IOException i){
            System.out.println("IO exception found when trying to get Geolocation");
        }
        if(!addressList.isEmpty())
            return addressList.get(0);
        System.out.println("The given address list was empty");
        return null;
    }
}
