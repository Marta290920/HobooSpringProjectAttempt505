package com.HobooProject.demo.Spring.service.impl;

import com.HobooProject.demo.Spring.DTO.HotelForObjectCreationDTO;
import com.HobooProject.demo.Spring.DTO.RoomDTO;
import com.HobooProject.demo.Spring.dao.BookingDAO;
import com.HobooProject.demo.Spring.dao.HotelDAO;
import com.HobooProject.demo.Spring.dao.RoomDAO;
import com.HobooProject.demo.Spring.mapper.RoomMapper;
import com.HobooProject.demo.Spring.model.Category;
import com.HobooProject.demo.Spring.model.Hotel;
import com.HobooProject.demo.Spring.model.Room;
import com.HobooProject.demo.Spring.service.HotelService;
import com.HobooProject.demo.Spring.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private final RoomDAO roomDAO;
    private final HotelService hotelService;
    private final RoomMapper roomMapper;
    private final BookingDAO bookingDAO;
    private final HotelDAO hotelDAO;


    public RoomServiceImpl(final RoomDAO roomDAO, final HotelService hotelService, final BookingDAO bookingDAO, final HotelDAO hotelDAO) {
        this.roomDAO = roomDAO;
        this.hotelService = hotelService;

        this.roomMapper = new RoomMapper();

        this.bookingDAO = bookingDAO;
        this.hotelDAO = hotelDAO;
    }


    @Override
    @Transactional
    public List<Room> getRoomListByHotelId(final long id) {

        return roomDAO.getRoomListByHotelId(id);
    }

    @Override
    @Transactional
    public void addRoom(final HotelForObjectCreationDTO hotel) {
        List<Category> categoryList = hotelService.getCategoryList();
        Hotel hotelbyId = hotelDAO.findHotelbyId(hotel.getHotelId());
        for (final Category category : categoryList) {
            Room room = new Room();
            room.setCategory(category);
            room.setHotel(hotelbyId);
            Integer cost = getCostForCategory(hotel, category);
            if (cost == null) {
                continue;
            }
            room.setCost(cost);
            roomDAO.addRoom(room);
        }
    }

    private Integer getCostForCategory(final HotelForObjectCreationDTO hotel, final Category category) {
        Integer result = null;
        switch (category.getName()) {
            case ("single"):
                result = hotel.getCostsingle();
                break;
            case ("lux"):
                result = hotel.getCostlux();
                break;
            case ("double"):
                result = hotel.getCostdouble();
                break;
            case ("president"):
                result = hotel.getCostpresident();
                break;
            case ("twins"):
                result = hotel.getCosttwins();
                break;
        }

        return result;
    }
}
