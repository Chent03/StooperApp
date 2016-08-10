package com.cs6392016.gbergy.stooperapp;

/**
 * Created by Tony on 8/10/16.
 */
public class location {
    String item;
    String address;
    double latitude;
    double longitude;

    public location(){}

    public location(String item, String address, double latitude, double longitude){
        this.item = item;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
