package com.HobooProject.demo.Spring.service;

import com.HobooProject.demo.Spring.DTO.BookingDTO;
import com.HobooProject.demo.Spring.model.Booking;
import com.HobooProject.demo.Spring.model.City;
import com.HobooProject.demo.Spring.model.PaymentType;

import java.util.List;

public interface CityService {
    List<City> getAllCities();

    //Long getCityIdbyName(String name);
}
