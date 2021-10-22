package com.HobooProject.demo.Spring.dao;

import com.HobooProject.demo.Spring.model.Feedback;

import java.util.List;

public interface FeedbackDAO {
    void saveFeedback(Feedback feedback);

    List<Feedback> getAllFeedbacksByHotelId(long id);
}
