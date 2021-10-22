package com.HobooProject.demo.Spring.service.impl;

import com.HobooProject.demo.Spring.dao.CityDAO;
import com.HobooProject.demo.Spring.model.City;
import com.HobooProject.demo.Spring.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private  final CityDAO cityDAO;

    public CityServiceImpl(final CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<City> getAllCities() {
//        List<City>cityList=cityDAO.getAllCities();
//        return cityList;
        return cityDAO.getAllCities();

    }

//    @Override
//    public Long getCityIdbyName(final String name) {
//
//        return cityDAO.getCityIdbyName(name);
//    }
}
