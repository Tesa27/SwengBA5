package com.github.Tesa27.bootcamp.sweng_week2;

import android.location.Address;

public interface GeocodingService {
    public Location addressToLocation(Address address);

    public Address locationToAddress(Location place);
}
