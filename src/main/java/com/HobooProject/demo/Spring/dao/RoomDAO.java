package com.HobooProject.demo.Spring.dao;

import com.HobooProject.demo.Spring.model.Category;
import com.HobooProject.demo.Spring.model.Room;

import java.util.List;

public interface RoomDAO {
    List<Room> getRoomListByHotelId(long id);
    public void addRoom(final Room room);
    public Category getCategoryByName(String name);

}
