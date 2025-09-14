package com.example.gui.stage2.Restaurants;

public abstract class  Restaurant {

    private String name;
    private String address;
    private String contactInfo;
    private double rating;

    public Restaurant(){}
    public Restaurant(String name,String address,String contactInfo,double rating) {

        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
        this.rating = rating;

    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public double getRating() {
        return rating;
    }
}
