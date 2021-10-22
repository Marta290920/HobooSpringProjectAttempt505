package com.HobooProject.demo.Spring.service;

import com.HobooProject.demo.Spring.DTO.HotelDTO;
import com.HobooProject.demo.Spring.DTO.HotelForObjectCreationDTO;
import com.HobooProject.demo.Spring.model.Category;
import com.HobooProject.demo.Spring.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getHotelListByCiteName(final String name);

    HotelDTO findHotelbyId(long id);
    List<HotelDTO> getFavoriteListByUserId(long userID) ;
    Long addOwnObject(HotelForObjectCreationDTO hotelDTO1);
    void saveFavorite(long userId, long hotelId) ;
    List<Category> getCategoryList();
    Hotel getHotelbyName(String name);
    List<Hotel> getAllHotels();
}
