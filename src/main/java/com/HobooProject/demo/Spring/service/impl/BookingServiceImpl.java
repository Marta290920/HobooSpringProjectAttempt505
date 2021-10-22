package com.HobooProject.demo.Spring.service.impl;

import com.HobooProject.demo.Spring.DTO.BookingDTO;
import com.HobooProject.demo.Spring.dao.BookingDAO;
import com.HobooProject.demo.Spring.dao.HotelDAO;
import com.HobooProject.demo.Spring.mapper.BookingMapper;
import com.HobooProject.demo.Spring.model.Booking;
import com.HobooProject.demo.Spring.model.PaymentType;
import com.HobooProject.demo.Spring.service.BookingServise;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingServise {
    private final BookingDAO bookingDAO;
    private final BookingMapper bookingMapper;
    private final HotelDAO hotelDAO;


    public BookingServiceImpl(final BookingDAO bookingDAO, final HotelDAO hotelDAO) {
        this.bookingDAO = bookingDAO;
        this.bookingMapper = new BookingMapper();
        this.hotelDAO = hotelDAO;

    }

    @Override
    @Transactional
    public List<PaymentType> paymentList() {
        return bookingDAO.paymentList();
    }


    @Override
    @Transactional
    public void saveBooking(final BookingDTO bookingDTO) {
        Booking booking = bookingMapper.map(bookingDTO);
        booking.setHotel(bookingDAO.getHotelIDbyName(bookingDTO.getHotelName()));
        booking.setPaymentType(bookingDAO.getPaymentTypeIDbyName(bookingDTO.getPaymentType()));
        booking.setRoom(bookingDAO.getRoomIDbyCategoryName(bookingDTO.getCategory(), bookingDTO.getHotelName()));
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getSession();
        String str = bookingDTO.getStart();
        String str1 = bookingDTO.getEnd();
        final Long userId = (Long) session.getAttribute("id");
        booking.setUser(bookingDAO.getUserById(userId));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(str, formatter);
        LocalDate dateTime1 = LocalDate.parse(str1, formatter);
        booking.setStart(dateTime);
        booking.setEnd(dateTime1);
        bookingDAO.saveBooking(booking);
    }

    @Override
    @Transactional
    public List<BookingDTO> getBookingListByUserId(final Long userID) {
        List<Booking> bookingList=bookingDAO.getBookingListByUserId(userID);
        List<BookingDTO> bookingDTOList=new ArrayList<>();
        for (Booking bookings:bookingList) {
            bookingDTOList.add(bookingMapper.map1(bookings));
        }
        return bookingDTOList;
    }

}
