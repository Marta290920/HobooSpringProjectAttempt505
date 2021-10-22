package com.HobooProject.demo.Spring.dao;

import com.HobooProject.demo.Spring.DTO.HotelDTO;
import com.HobooProject.demo.Spring.model.Category;
import com.HobooProject.demo.Spring.model.Hotel;
import com.HobooProject.demo.Spring.model.User;

import java.util.List;

public interface HotelDAO {
    List<Hotel> getHotelListByCiteName(String name);

    Hotel findHotelbyId(long id);
    Long addOwnObject(Hotel hotel);
    List<Category> getCategoryList();
    Hotel getHotelbyName(final String name);
    List<Hotel> getAllHotels();

}
