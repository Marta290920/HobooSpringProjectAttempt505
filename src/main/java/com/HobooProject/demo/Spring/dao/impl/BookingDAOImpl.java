package com.HobooProject.demo.Spring.dao.impl;

import com.HobooProject.demo.Spring.DTO.BookingDTO;
import com.HobooProject.demo.Spring.dao.BookingDAO;
import com.HobooProject.demo.Spring.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BookingDAOImpl implements BookingDAO {
    public static final String REGEX_FOR_ALL_ALPHABETIC_SYMBOLS = "[^a-zA-Z]";
    public static final String BLANK_STRING = "";
    @Autowired
    private final SessionFactory sessionFactory;

    public BookingDAOImpl(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PaymentType> paymentList() {
        String line="select p from PaymentType as p";
        List paymentList = this.sessionFactory.getCurrentSession().createQuery(line).list();
        return paymentList;
    }

    @Override
    public BookingDTO getBookingByHotelId(final long id) {
        return null;

    }

    @Override
    public void saveBooking(final Booking booking) {
        sessionFactory.getCurrentSession().save(booking);
    }


    @Override
    public Hotel getHotelIDbyName(final String name) {
        String line = "from Hotel  where name = :name";
        Query <Hotel>query = this.sessionFactory.getCurrentSession().createQuery(line,Hotel.class);
        query.setParameter("name", name);
//        Long hotelId=(Long) query.list().get(0);
//
//        return hotelId;
        return query.getSingleResult();
    }

    public User getUserById(Long id){
//        String line = "select u from User as u where id = :id";
//    Query <User> query = this.sessionFactory.getCurrentSession().createQuery(line,User.class);
//    query.setParameter("id", id);
//    return query.getSingleResult();
        Query<User> query = sessionFactory.getCurrentSession()
                .createQuery("select u from User as u where u.id=:id ")
                .setParameter("id", id);

        List<User> userList = query.list();
        User user = null;

        if (!userList.isEmpty()) {
            user = userList.get(0);
        }
        return user;
}


    @Override
    public Room getRoomById(final Long id) {
        String line = "select r from Room as r where id = :id";
        Query <Room> query = this.sessionFactory.getCurrentSession().createQuery(line,Room.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Room getRoomIDbyCategoryName(String categoryName, String hotelName) {
        String line = "select r from Room as r join Category as c on c.id=r.category.id join Hotel as h on h.id=r.hotel.id\n" +
                "where c.name=:categoryName and h.name=:hotelName";
        Query<Room> query = this.sessionFactory.getCurrentSession().createQuery(line,Room.class);
        categoryName = categoryName.replaceAll(REGEX_FOR_ALL_ALPHABETIC_SYMBOLS, BLANK_STRING).toLowerCase();
               query.setParameter("categoryName", categoryName);
               query.setParameter("hotelName",hotelName);
        return query.getSingleResult();
    }

    @Override
    public PaymentType getPaymentTypeIDbyName(final String name) {
        String line = "select p from PaymentType as p  where p.name = :name";
        Query <PaymentType> query = this.sessionFactory.getCurrentSession().createQuery(line,PaymentType.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
    @Override
    public PaymentType getPaymentTypeById(final Long id) {
        String line = "select p from PaymentType as p  where p.id=:id";
        Query <PaymentType> query = this.sessionFactory.getCurrentSession().createQuery(line,PaymentType.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Booking> getBookingListByUserId(final Long userID) {
        String line = "select b from Booking as b where b.user.id=:userID";
        Query <Booking> query = this.sessionFactory.getCurrentSession().createQuery(line,Booking.class);
        List bookingList = query.setParameter("userID", userID).list();
        return bookingList;
    }
}
