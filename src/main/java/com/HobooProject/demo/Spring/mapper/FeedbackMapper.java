package com.HobooProject.demo.Spring.mapper;

import com.HobooProject.demo.Spring.DTO.FeedbackDTO;
import com.HobooProject.demo.Spring.model.Feedback;

public class FeedbackMapper {
    public Feedback map(final FeedbackDTO feedbackDTO){
        final Feedback result=new Feedback();
        result.setFeedback(feedbackDTO.getFeedback());
        result.setStarAmount(feedbackDTO.getStarAmount());
        return result;
    }
}
