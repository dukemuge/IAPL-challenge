package com.example.demo.models;

import javax.persistence.*;

@Embeddable
public class Location {

    private double longitude;

    private double latitude;

    public Location() {
    }

    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Location longitude(double longitude) {
        setLongitude(longitude);
        return this;
    }

    public Location latitude(double latitude) {
        setLatitude(latitude);
        return this;
    }

    @Override
    public String toString() {
        return "{" + " longitude='" + getLongitude() + "'" + ", latitude='" + getLatitude() + "'" + "}";
    }

}
