package com.HobooProject.demo.Spring.service.impl;

import com.HobooProject.demo.Spring.DTO.FeedbackDTO;
import com.HobooProject.demo.Spring.dao.FeedbackDAO;
import com.HobooProject.demo.Spring.dao.HotelDAO;
import com.HobooProject.demo.Spring.mapper.FeedbackMapper;
import com.HobooProject.demo.Spring.model.Feedback;
import com.HobooProject.demo.Spring.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackDAO feedbackDAO;
    private final FeedbackMapper feedbackMapper;
    private final HotelDAO hotelDAO;

    public FeedbackServiceImpl(final FeedbackDAO feedbackDAO, final HotelDAO hotelDAO) {
        this.feedbackDAO = feedbackDAO;
        this.feedbackMapper = new FeedbackMapper();
        this.hotelDAO = hotelDAO;
    }
    @Transactional
    @Override
    public void saveFeedback(final FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackMapper.map(feedbackDTO);
        feedback.setHotel(hotelDAO.findHotelbyId(feedbackDTO.getHotelId()));
        feedbackDAO.saveFeedback(feedback);
    }
    @Transactional
    @Override
    public List<Feedback> getAllFeedbacksByHotelId(final long id) {
        return feedbackDAO.getAllFeedbacksByHotelId(id);
    }
}
