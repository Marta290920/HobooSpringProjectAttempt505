package com.HobooProject.demo.Spring.DTO;

public class FeedbackDTO {
   private long id;
   private String feedback;
   private int starAmount;
   private  long hotelId;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(final String feedback) {
        this.feedback = feedback;
    }

    public int getStarAmount() {
        return starAmount;
    }

    public void setStarAmount(final int starAmount) {
        this.starAmount = starAmount;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(final long hotelId) {
        this.hotelId = hotelId;
    }
}
