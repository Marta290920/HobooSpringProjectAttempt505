package com.HobooProject.demo.Spring.DTO;

public class HotelDTO {
    private long id;
    private String hotelName;
    private int starAmount;
    private String cityName;
    private String street;
    private int numberOfBuilding;
    private String phoneNumber;
    private String photo;
    private String about;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(final String hotelName) {
        this.hotelName = hotelName;
    }

    public int getStarAmount() {
        return starAmount;
    }

    public void setStarAmount(final int starAmount) {
        this.starAmount = starAmount;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(final String cityName) {
        this.cityName = cityName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public int getNumberOfBuilding() {
        return numberOfBuilding;
    }

    public void setNumberOfBuilding(final int numberOfBuilding) {
        this.numberOfBuilding = numberOfBuilding;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(final String photo) {
        this.photo = photo;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(final String about) {
        this.about = about;
    }
}
