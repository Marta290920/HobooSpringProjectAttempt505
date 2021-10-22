package com.HobooProject.demo.Spring.dao;

import com.HobooProject.demo.Spring.DTO.BookingDTO;
import com.HobooProject.demo.Spring.model.*;

import java.util.List;

public interface BookingDAO {
    List<PaymentType> paymentList();
    //void saveBooking(Booking booking);
    BookingDTO getBookingByHotelId(long id);

     PaymentType getPaymentTypeById(final Long id);
    void saveBooking(Booking booking) ;
    Hotel getHotelIDbyName(String name);

   Room getRoomIDbyCategoryName(String categoryName, String hotelName);

    PaymentType getPaymentTypeIDbyName(String name) ;
    Room getRoomById(Long id);
    User getUserById(final Long id);


    List<Booking> getBookingListByUserId(Long userID);
}
