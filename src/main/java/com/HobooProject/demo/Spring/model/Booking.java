package com.HobooProject.demo.Spring.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Entity;
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private Room room;
    @ManyToOne
    private User user;
    @ManyToOne
    private PaymentType paymentType;
    @Column(name="start")
    private LocalDate start;
    @Column(name="end")
    private LocalDate end;

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

    public Room getRoom() {
        return room;
    }

    public void setRoom(final Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(final PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(final LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(final LocalDate end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", hotelId=" + hotel +
                ", roomId=" + room +
                ", userId=" + user +
                ", paymentTypeId=" + paymentType +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
