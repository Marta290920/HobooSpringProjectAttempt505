package com.HobooProject.demo.Spring.service;

import com.HobooProject.demo.Spring.DTO.HotelForObjectCreationDTO;
import com.HobooProject.demo.Spring.DTO.RoomDTO;
import com.HobooProject.demo.Spring.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> getRoomListByHotelId(long id);
    void addRoom(final HotelForObjectCreationDTO hotel);
}
