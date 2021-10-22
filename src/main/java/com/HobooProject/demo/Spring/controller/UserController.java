package com.HobooProject.demo.Spring.controller;

import com.HobooProject.demo.Spring.DTO.UserDTO;
import com.HobooProject.demo.Spring.controller.interceptors.LoggerInterceptor;
import com.HobooProject.demo.Spring.model.User;
import com.HobooProject.demo.Spring.service.CityService;
import com.HobooProject.demo.Spring.service.UserService;
import com.HobooProject.demo.Spring.utils.HashPasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {
    private final UserService userService;
    private final CityService cityService;
    private static Logger logger = Logger.getLogger(LoggerInterceptor.class);


    public UserController(final UserService userService, final CityService cityService) {
        this.userService = userService;
        this.cityService = cityService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String save(@ModelAttribute UserDTO userDTO) {
        userService.regist(userDTO);
        return "login";
    }

    @GetMapping("/registration")
    public String redirectToRegistrationPage(ModelMap map) {
        map.addAttribute("cityList", cityService.getAllCities());
        return "register";
    }

    //
    @PostMapping(value = "/login")

    public String login(@RequestParam("login") final String login,
                        @RequestParam("password") final String password, ModelMap map) {

        User user = null;

        try {
            user = userService.login(login);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
        }

        if (user != null) {

            //   final boolean validPassword = HashPasswordUtil.checkPassword(password, user.getPassword());

            // if (validPassword) {

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true); // true == allow create
            session.setAttribute("login", login);
            session.setAttribute("id", user.getId());
            System.out.println("you are logged");
        }
//        } else {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(null);
        map.addAttribute("cityList", cityService.getAllCities());
        return "index";
    }

    @GetMapping("/login")
    public String redirectTologinPage() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout() {

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(false); // true == allow create
        session.invalidate();

        return "redirect:/";
    }
//    public String foo(Model model) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String login = user.getLogin();
//        model.addAttribute("login", login);
//        return "index";
//    }
}
