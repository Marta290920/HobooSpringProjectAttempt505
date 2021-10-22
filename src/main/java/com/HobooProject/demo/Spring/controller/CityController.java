package com.HobooProject.demo.Spring.controller;

import com.HobooProject.demo.Spring.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class CityController {
 //   private static Logger logger = Logger.getLogger(String.valueOf(CityController.class));
    @Autowired
    private CityService cityService;



    public CityController(final CityService cityService) {
        this.cityService = cityService;

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllCities(ModelMap map){
        map.addAttribute("cityList", cityService.getAllCities());
        return "index";
    }

//    @RequestMapping(value = "/cityId", method = RequestMethod.GET)
//    public String getCityIdbyName(ModelMap map, @RequestParam String name){
//    map.addAttribute("cityId",cityService.getCityIdbyName(name));
//       return "cityId";
//    }

@RequestMapping(value="/header")
    public String getUserId(Model map) {
    HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
            .getRequest().getSession();
    final Long userId = (Long) session.getAttribute("userId");
    map.addAttribute("userId",userId);

    return "header";
}

}
