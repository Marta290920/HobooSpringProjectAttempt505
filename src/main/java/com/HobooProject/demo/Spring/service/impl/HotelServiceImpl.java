package com.HobooProject.demo.Spring.service.impl;

import com.HobooProject.demo.Spring.DTO.HotelDTO;
import com.HobooProject.demo.Spring.DTO.HotelForObjectCreationDTO;
import com.HobooProject.demo.Spring.dao.CityDAO;
import com.HobooProject.demo.Spring.dao.HotelDAO;
import com.HobooProject.demo.Spring.dao.UserDAO;
import com.HobooProject.demo.Spring.mapper.HotelMapper;
import com.HobooProject.demo.Spring.model.Category;
import com.HobooProject.demo.Spring.model.Hotel;
import com.HobooProject.demo.Spring.model.User;
import com.HobooProject.demo.Spring.service.HotelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelDAO hotelDAO;
    private final HotelMapper hotelMapper;
    private final UserDAO userDAO;
    private final CityDAO cityDAO;

    public HotelServiceImpl(final HotelDAO hotelDAO, final UserDAO userDAO, final CityDAO cityDAO) {
        this.userDAO = userDAO;
        this.cityDAO = cityDAO;
        hotelMapper = new HotelMapper();
        this.hotelDAO = hotelDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Hotel> getHotelListByCiteName(final String name) {
        return hotelDAO.getHotelListByCiteName(name);
    }

    @Transactional
    @Override
    public HotelDTO findHotelbyId(final long id) {
        return hotelMapper.map(hotelDAO.findHotelbyId(id));
    }
    @Transactional
    @Override
    public List<HotelDTO> getFavoriteListByUserId(final long userID) {
        Set<Hotel> favoriteList1 = userDAO.getFavoriteListByUserId(userID);
        List<HotelDTO> favoriteList = new ArrayList<>();
        for (Hotel hotels : favoriteList1) {
            favoriteList.add(hotelMapper.map(hotels));
        }
        return favoriteList;
    }
    @Transactional
    @Override
    public void saveFavorite(long userId , long hotelId) {
        User userById = userDAO.getUserById(userId);
        Set<Hotel> hotel = userById.getHotel();
        hotel.add(hotelDAO.findHotelbyId(hotelId));
        userDAO.saveFavorite(userById);
    }

    @Transactional
    @Override
    public List<Category> getCategoryList() {
        return hotelDAO.getCategoryList();
    }
    @Transactional
    @Override
    public Hotel getHotelbyName(final String name) {
       return hotelDAO.getHotelbyName(name);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelDAO.getAllHotels();
    }

    @Transactional
    @Override
    public Long addOwnObject(HotelForObjectCreationDTO hotelDTO1){
        Hotel hotel=hotelMapper.map1(hotelDTO1);
        hotel.setCity(cityDAO.getCityById(hotelDTO1.getCityId()));
        return hotelDAO.addOwnObject(hotel);
    }
}
