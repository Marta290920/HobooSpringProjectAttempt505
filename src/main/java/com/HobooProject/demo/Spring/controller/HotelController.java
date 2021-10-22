package com.HobooProject.demo.Spring.controller;

import com.HobooProject.demo.Spring.DTO.FeedbackDTO;
import com.HobooProject.demo.Spring.service.BookingServise;
import com.HobooProject.demo.Spring.service.FeedbackService;
import com.HobooProject.demo.Spring.service.HotelService;
import com.HobooProject.demo.Spring.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class HotelController {
    private final HotelService hotelService;
    private final RoomService roomService;
    private final BookingServise bookingServise;
    private final FeedbackService feedbackService;

    public HotelController(final HotelService hotelService, final RoomService roomService,
                           final BookingServise bookingServise, final FeedbackService feedbackService) {
        this.hotelService = hotelService;
        this.roomService = roomService;
        this.bookingServise = bookingServise;
        this.feedbackService = feedbackService;
    }

    @GetMapping(value = "/hotel")
    public String findHotelbyId(ModelMap map, @RequestParam(name = "id") long id) {
        map.addAttribute("hotelDTO", hotelService.findHotelbyId(id));
        map.addAttribute("roomList", roomService.getRoomListByHotelId(id));
        map.addAttribute("paymentList", bookingServise.paymentList());
        map.addAttribute("feedbackList", feedbackService.getAllFeedbacksByHotelId(id));
        return "hotel1";
    }

    @PostMapping(value = "/hotel")
    public void save(@RequestBody FeedbackDTO feedbackDTO) {
        feedbackService.saveFeedback(feedbackDTO);
    }
    @RequestMapping(value = "/hotelsList",method = RequestMethod.GET)
        public String hotelList(ModelMap map){
        map.addAttribute("hotelsList",hotelService.getAllHotels());
        return"hotelsList";
    }
}
