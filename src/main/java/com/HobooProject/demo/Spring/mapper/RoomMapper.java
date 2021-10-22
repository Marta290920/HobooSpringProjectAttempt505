package com.HobooProject.demo.Spring.mapper;

import com.HobooProject.demo.Spring.DTO.RoomDTO;
import com.HobooProject.demo.Spring.model.Room;

public class RoomMapper {
    public Room map(RoomDTO roomDTO){
        final Room result=new Room();
        result.setId(roomDTO.getId());
        result.setCost(roomDTO.getCost());
        return result;
    }
}
