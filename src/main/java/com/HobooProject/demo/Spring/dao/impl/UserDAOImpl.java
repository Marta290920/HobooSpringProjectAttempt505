package com.HobooProject.demo.Spring.dao.impl;

import com.HobooProject.demo.Spring.dao.UserDAO;
import com.HobooProject.demo.Spring.model.City;
import com.HobooProject.demo.Spring.model.Hotel;
import com.HobooProject.demo.Spring.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
    private final SessionFactory sessionFactory;

    public UserDAOImpl(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void regist(final User user) {

        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User login(final String login) {
        Query<User> query = sessionFactory.getCurrentSession()
                .createQuery("select u from User as u where u.login=:login ")
                .setParameter("login", login);

        List<User> userList = query.list();
        User user = null;

        if (!userList.isEmpty()) {
            user = userList.get(0);
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    @Override
    public User getUserById(Long id) {
        Session session; // = this.sessionFactory.getSessionFactory().openSession();
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session.get(User.class, id);
    }

    @Override
    public Set<Hotel> getFavoriteListByUserId(final long userID) {
        String line = "SELECT  u FROM User as u  WHERE u.id=:userID";
        Query<User> query = this.sessionFactory.getCurrentSession().createQuery(line, User.class);
        User user = query.setParameter("userID", userID).getSingleResult();

        return user.getHotel();
    }

    @Override
    public void saveFavorite(final User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
}
