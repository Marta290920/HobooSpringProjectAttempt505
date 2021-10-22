package com.HobooProject.demo.Spring.dao.impl;

import com.HobooProject.demo.Spring.dao.FeedbackDAO;
import com.HobooProject.demo.Spring.model.Feedback;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FeedbackDAOImpl implements FeedbackDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public FeedbackDAOImpl(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveFeedback(final Feedback feedback) {
        sessionFactory.getCurrentSession().save(feedback);
//                .createNativeQuery("insert into feedback(feedback,star_amount,hotel_id) VALUES(?,?,?)")
//                .setParameter(1, feedback.getFeedback())
//                .setParameter(2, feedback.getStarAmount())
//                .setParameter(3, feedback.getHotel()).executeUpdate();
    }

    @Override
    public List<Feedback> getAllFeedbacksByHotelId(final long id) {
        String line="select f from Feedback as f where hotel.id=:id";
        Query query = this.sessionFactory.getCurrentSession().createQuery(line);
        List feedbackList = query.setParameter("id", id).list();
        return feedbackList;
    }
}
