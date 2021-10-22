package com.HobooProject.demo.Spring.controller;

import com.HobooProject.demo.Spring.DTO.BookingDTO;
import com.HobooProject.demo.Spring.service.BookingServise;
import com.HobooProject.demo.Spring.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class BookingController {
    @Autowired
    private BookingServise bookingServise;
    private final CityService cityService;

    public BookingController(final BookingServise bookingServise, final CityService cityService) {
        this.bookingServise = bookingServise;
        this.cityService = cityService;
    }
    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public String save(@ModelAttribute BookingDTO bookingDTO,ModelMap map){
      bookingServise.saveBooking(bookingDTO);
        map.addAttribute("cityList",cityService.getAllCities());
        return "index";
    }
    @RequestMapping(value = "/booking",method=RequestMethod.GET)
    public String getBookingListByUserId(ModelMap map){
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getSession();
        final Long userID = (Long) session.getAttribute("id");
        map.addAttribute("bookingList", bookingServise.getBookingListByUserId(userID));
        return "myBookings";
    }

}
