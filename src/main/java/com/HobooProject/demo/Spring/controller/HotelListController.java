package com.HobooProject.demo.Spring.controller;

import com.HobooProject.demo.Spring.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HotelListController {
    @Autowired
    private final HotelService hotelService;

    public HotelListController(final HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @RequestMapping(value = "/hotelList", method = RequestMethod.POST)
    public String getHotelListByCiteName (ModelMap map, @RequestParam("name") String name) {
        map.addAttribute("hotelList", hotelService.getHotelListByCiteName(name));
        return "hotelList";

    }
}
