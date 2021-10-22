package com.HobooProject.demo.Spring.service;

import com.HobooProject.demo.Spring.DTO.FeedbackDTO;
import com.HobooProject.demo.Spring.model.Feedback;

import java.util.List;

public interface FeedbackService {
    void saveFeedback(FeedbackDTO feedbackDTO);

    List<Feedback> getAllFeedbacksByHotelId(long id);
}
