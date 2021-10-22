package com.HobooProject.demo.Spring.dao.impl;

import com.HobooProject.demo.Spring.DTO.HotelDTO;
import com.HobooProject.demo.Spring.dao.HotelDAO;
import com.HobooProject.demo.Spring.model.Category;
import com.HobooProject.demo.Spring.model.City;
import com.HobooProject.demo.Spring.model.Hotel;
import com.HobooProject.demo.Spring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Transactional
@Repository
public class HotelDAOImpl implements HotelDAO {

    @Autowired
    private final SessionFactory sessionFactory;

    public HotelDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Hotel> getHotelListByCiteName(final String name) {
        City city = new City();
        final String line = "select h from Hotel as h " +
                "join City as c on c.id=h.city.id " +
                "where c.name=:name";
        Query query = this.sessionFactory.getCurrentSession().createQuery(line);
        //   query.setParameter("name", name);
        List hotelList = query.setParameter("name", name).list();
        return hotelList;
    }

    @Override
    public Hotel findHotelbyId(final long id) {
        final String line = "select h from Hotel as h join City as c on c.id=h.city.id where h.id=:id";
        Query<Hotel> query = this.sessionFactory.getCurrentSession().createQuery(line, Hotel.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Long addOwnObject(final Hotel hotel) {

   return (Long) sessionFactory.getCurrentSession().save(hotel);

    }

    @Override
    public List<Category> getCategoryList() {
        String line = "select c from Category as c ";
        List categotyList = this.sessionFactory.getCurrentSession().createQuery(line).list();
        return categotyList;
    }

    @Override
    public Hotel getHotelbyName(final String name) {
        final String line ="select  h from Hotel as h where h.name=:name";
        Query <Hotel> query = this.sessionFactory.getCurrentSession().createQuery(line,Hotel.class);
        query.setParameter("name",name);
        return query.getSingleResult();
    }

    @Override
    public List<Hotel> getAllHotels() {
        String line = "select h from Hotel as h ";
        List hotelsList = this.sessionFactory.getCurrentSession().createQuery(line).list();
        return hotelsList;
    }
}
