package com.HobooProject.demo.Spring.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToMany(mappedBy = "hotel",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<User> user = new HashSet<>();
    @Column(name = "name")
    private String name;
    @Column(name = "star_amount")
    private int starAmount;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private City city;
    @Column(name = "street")
    private String street;
    @Column(name = "number_of_building")
    private int numberOfBuilding;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "photo")
    private String photo;
    @Column(name = "about")
    private String about;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getStarAmount() {
        return starAmount;
    }

    public void setStarAmount(final int starAmount) {
        this.starAmount = starAmount;
    }

    public City getCity() {
        return city;
    }

    public void setCity(final City city) {
        this.city = city;
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

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", starAmount=" + starAmount +
                ", cityId=" + city +
                ", street='" + street + '\'' +
                ", numberOfBuilding=" + numberOfBuilding +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", photo='" + photo + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
