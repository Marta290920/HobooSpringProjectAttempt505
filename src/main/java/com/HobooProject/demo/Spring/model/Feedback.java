package com.HobooProject.demo.Spring.model;

import javax.persistence.*;
import javax.persistence.Entity;
@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name="feedback")
    private String feedback;
    @Column(name="star_amount")
    private int starAmount;
    @ManyToOne
    private Hotel hotel;

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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(final Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", feedback='" + feedback + '\'' +
                ", starAmount=" + starAmount +
                ", hotel=" + hotel +
                '}';
    }
}
