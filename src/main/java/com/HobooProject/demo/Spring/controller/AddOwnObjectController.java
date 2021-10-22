package com.HobooProject.demo.Spring.controller;

import com.HobooProject.demo.Spring.DTO.HotelForObjectCreationDTO;
import com.HobooProject.demo.Spring.DTO.RoomDTO;
import com.HobooProject.demo.Spring.controller.interceptors.LoggerInterceptor;
import com.HobooProject.demo.Spring.service.CityService;
import com.HobooProject.demo.Spring.service.HotelService;
import com.HobooProject.demo.Spring.service.RoomService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddOwnObjectController {
    @Autowired
    private final RoomService roomService;
    private final CityService cityService;
    private final HotelService hotelService;
    private static Logger logger = Logger.getLogger(LoggerInterceptor.class);

    public AddOwnObjectController(final RoomService roomService, final CityService cityService, final HotelService hotelService) {
        this.roomService = roomService;
        this.cityService = cityService;
        this.hotelService = hotelService;

    }

    @RequestMapping(value = "/addOwnObject", method = RequestMethod.POST)
    public String addOwnObject(@ModelAttribute HotelForObjectCreationDTO hotelDTO) {
       hotelDTO.setHotelId(hotelService.addOwnObject(hotelDTO));
        roomService.addRoom(hotelDTO);
        return "index";
    }

    @RequestMapping(value = "/addOwnObject", method = RequestMethod.GET)
    public String addOwnObjectViews(Model map) {
        map.addAttribute("cityList", cityService.getAllCities());
        map.addAttribute("categoryList", hotelService.getCategoryList());
        return "addOwnObject";
    }
}
