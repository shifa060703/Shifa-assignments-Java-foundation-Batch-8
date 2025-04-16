package com.hexaware.cm.task5.oops;

public class Location {
    private int locationID;
    private String locationName;
    private String address;

    // Default constructor
    public Location() {}

    // Parametrized constructor
    public Location(int locationID, String locationName, String address) {
        this.locationID = locationID;
        this.locationName = locationName;
        this.address = address;
    }

    // Getters and Setters
    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // toString method
    @Override
    public String toString() {
        return "Location [locationID=" + locationID + ", locationName=" + locationName + ", address=" + address + "]";
    }
}

