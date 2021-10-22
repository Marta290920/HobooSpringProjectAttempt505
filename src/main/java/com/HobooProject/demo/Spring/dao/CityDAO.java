package com.HobooProject.demo.Spring.dao;

import com.HobooProject.demo.Spring.model.City;
import com.HobooProject.demo.Spring.model.PaymentType;

import java.sql.SQLException;
import java.util.List;

public interface CityDAO {
    List<City> getAllCities() ;

   // Long getCityIdbyName(String name) ;
    City getCityById(long id);

}
