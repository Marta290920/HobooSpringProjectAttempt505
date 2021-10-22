package com.HobooProject.demo.Spring.DTO;

public class HotelForObjectCreationDTO {
    private String hotelName;
    private Integer starAmount;
    private Long cityId;
    private String street;
    private Integer numberOfBuilding;
    private String phoneNumber;
    private String photo;
    private String about;
    private Integer costsingle;
    private Integer costlux;
    private Integer costdouble;
    private Integer costpresident;
    private Integer costtwins;
    private Long hotelId;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(final String hotelName) {
        this.hotelName = hotelName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(final Long cityId) {
        this.cityId = cityId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public Integer getNumberOfBuilding() {
        return numberOfBuilding;
    }

    public void setNumberOfBuilding(final Integer numberOfBuilding) {
        this.numberOfBuilding = numberOfBuilding;
    }

    public Integer getStarAmount() {
        return starAmount;
    }

    public void setStarAmount(final Integer starAmount) {
        this.starAmount = starAmount;
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

    public Integer getCostsingle() {
        return costsingle;
    }

    public void setCostsingle(final Integer costsingle) {
        this.costsingle = costsingle;
    }

    public Integer getCostlux() {
        return costlux;
    }

    public void setCostlux(final Integer costlux) {
        this.costlux = costlux;
    }

    public Integer getCostdouble() {
        return costdouble;
    }

    public void setCostdouble(final Integer costdouble) {
        this.costdouble = costdouble;
    }

    public Integer getCostpresident() {
        return costpresident;
    }

    public void setCostpresident(final Integer costpresident) {
        this.costpresident = costpresident;
    }

    public Integer getCosttwins() {
        return costtwins;
    }

    public void setCosttwins(final Integer costtwins) {
        this.costtwins = costtwins;
    }

    @Override
    public String toString() {
        return "HotelForObjectCreationDTO{" +
                "hotelName='" + hotelName + '\'' +
                ", starAmount=" + starAmount +
                ", cityId=" + cityId +
                ", street='" + street + '\'' +
                ", numberOfBuilding=" + numberOfBuilding +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", photo='" + photo + '\'' +
                ", about='" + about + '\'' +
                ", costsingle=" + costsingle +
                ", costlux=" + costlux +
                ", costdouble=" + costdouble +
                ", costpresident=" + costpresident +
                ", costtwins=" + costtwins +
                '}';
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(final Long hotelId) {
        this.hotelId = hotelId;
    }
}
