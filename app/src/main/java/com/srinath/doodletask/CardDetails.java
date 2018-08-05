package com.srinath.doodletask;

public class CardDetails {
    String place_name;
    double distance;
    double rating;
    double lat;
    double lng;

    public CardDetails(String place_name, double distance, double rating, double lat, double lng) {
        this.place_name = place_name;
        this.distance = distance;
        this.rating = rating;
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }


    public String getPlace_name() {

        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
