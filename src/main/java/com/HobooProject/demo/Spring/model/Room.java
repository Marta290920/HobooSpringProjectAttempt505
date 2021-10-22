package com.HobooProject.demo.Spring.model;

import javax.persistence.*;
import javax.persistence.Entity;
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private Category category;
    @Column(name="cost")
    private int cost;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(final Hotel hotel) {
        this.hotel = hotel;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(final int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", hotelId=" + hotel +
                ", categoryId=" + category +
                ", cost=" + cost +
                '}';
    }
}
