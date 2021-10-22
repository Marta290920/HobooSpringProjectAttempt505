package com.HobooProject.demo.Spring.mapper;

import com.HobooProject.demo.Spring.DTO.BookingDTO;
import com.HobooProject.demo.Spring.model.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingMapper {
    public Booking map(BookingDTO bookingDTO){
        final Booking result=new Booking();
        result.setId(bookingDTO.getId());

        return  result;
    }
    public BookingDTO map1(Booking booking){
        final BookingDTO result=new BookingDTO();

        result.setId(booking.getId());
        result.setHotelName(booking.getHotel().getName());
        result.setCategory(booking.getRoom().getCategory().getName());
        result.setPaymentType(booking.getPaymentType().getName());
        result.setCost(booking.getRoom().getCost());
        result.setStart(booking.getStart().toString());
        result.setEnd(booking.getEnd().toString());

        return result;

    }

}
