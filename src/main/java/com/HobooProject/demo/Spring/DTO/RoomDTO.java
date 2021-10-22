package com.HobooProject.demo.Spring.DTO;

public class RoomDTO {
    long id;
    private Long hotelName;

    public Long getHotelName() {
        return hotelName;
    }

    public void setHotelName(final Long hotelName) {
        this.hotelName = hotelName;
    }

    String category;
    int cost;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(final int cost) {
        this.cost = cost;
    }
}
