package com.HobooProject.demo.Spring.service;

import com.HobooProject.demo.Spring.DTO.BookingDTO;
import com.HobooProject.demo.Spring.model.Booking;
import com.HobooProject.demo.Spring.model.PaymentType;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface BookingServise {
    List<PaymentType> paymentList();
    public void saveBooking(final BookingDTO bookingDTO);
    List<BookingDTO> getBookingListByUserId(Long userID);
}
