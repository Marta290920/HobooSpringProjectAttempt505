package com.HobooProject.demo.Spring.dao.impl;

import com.HobooProject.demo.Spring.dao.RoomDAO;
import com.HobooProject.demo.Spring.model.Category;
import com.HobooProject.demo.Spring.model.Room;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public class RoomDAOImpl implements RoomDAO {
    @Autowired
    private final SessionFactory sessionFactory;

    public RoomDAOImpl(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Room> getRoomListByHotelId(final long id) {
        final String line ="select r from Room as r join Hotel as h on h.id=r.hotel.id " +
                "join Category as c on c.id=r.category.id where h.id=:id";
        Query query = this.sessionFactory.getCurrentSession().createQuery(line);
        List roomList = query.setParameter("id", id).list();
        return roomList;
    }

    @Override
    public void addRoom(final Room room) {
        sessionFactory.getCurrentSession().save(room);
    }

    @Override
    public Category getCategoryByName(final String name) {
        final String line ="select  c from Category as c where c.name=:name";
        Query <Category> query = this.sessionFactory.getCurrentSession().createQuery(line,Category.class);
        query.setParameter("name",name);
        return query.getSingleResult();
    }
}
