package com.HobooProject.demo.Spring.controller;

import com.HobooProject.demo.Spring.model.User;
import com.HobooProject.demo.Spring.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class FavoriteController {
    private HotelService hotelService;

    public FavoriteController(final HotelService hotelService) {
        this.hotelService = hotelService;

    }

    @RequestMapping(value = "/favorite", method = RequestMethod.GET)
    public String getFavoriteListByUserId(ModelMap map) {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getSession();
        final Long userID = (Long) session.getAttribute("id");
        map.addAttribute("favoriteList", hotelService.getFavoriteListByUserId(userID));
        return "favorite";
    }

    @RequestMapping(value = "/favorite", method = RequestMethod.POST)
    public String saveFavorite(ModelMap map,@RequestParam long hotelId) {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getSession();
        final Long userID = (Long) session.getAttribute("id");
        hotelService.saveFavorite(userID, hotelId);
        map.addAttribute("favoriteList", hotelService.getFavoriteListByUserId(userID));

        return "favorite";
    }
}
