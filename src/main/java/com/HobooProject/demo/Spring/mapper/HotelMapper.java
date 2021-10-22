package com.HobooProject.demo.Spring.mapper;

import com.HobooProject.demo.Spring.DTO.HotelDTO;
import com.HobooProject.demo.Spring.DTO.HotelForObjectCreationDTO;
import com.HobooProject.demo.Spring.model.Hotel;

public class HotelMapper {

    public HotelDTO map(final Hotel hotel) {
        final HotelDTO result = new HotelDTO();
        result.setId(hotel.getId());
        result.setAbout(hotel.getAbout());
        result.setHotelName(hotel.getName());
        result.setCityName(hotel.getCity().getName());
        result.setPhoto(hotel.getPhoto());
        result.setPhoneNumber(hotel.getPhoneNumber());
        result.setStreet(hotel.getStreet());
        result.setNumberOfBuilding(hotel.getNumberOfBuilding());
        result.setStarAmount(hotel.getStarAmount());
        return result;
    }
    public Hotel map1(final HotelForObjectCreationDTO hotelDTO1){
        final Hotel result=new Hotel();
        result.setName(hotelDTO1.getHotelName());
        result.setAbout(hotelDTO1.getAbout());
        result.setPhoneNumber(hotelDTO1.getPhoneNumber());
        result.setNumberOfBuilding(hotelDTO1.getNumberOfBuilding());
        result.setStarAmount(hotelDTO1.getStarAmount());
        result.setStreet(hotelDTO1.getStreet());
        return result;

    }

}
