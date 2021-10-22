package com.HobooProject.demo.Spring.service.impl;

import com.HobooProject.demo.Spring.DTO.UserDTO;
import com.HobooProject.demo.Spring.dao.CityDAO;
import com.HobooProject.demo.Spring.dao.UserDAO;
import com.HobooProject.demo.Spring.mapper.UserMapper;
import com.HobooProject.demo.Spring.model.User;
import com.HobooProject.demo.Spring.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final UserMapper userMapper;
    private final CityDAO cityDAO;

    public UserServiceImpl(final UserDAO userDAO, final CityDAO cityDAO) {
        this.userDAO = userDAO;
        this.cityDAO = cityDAO;
        this.userMapper = new UserMapper();
    }

    @Transactional
    @Override
    public void regist(final UserDTO userDTO) {
        User user = userMapper.map(userDTO);
        String str = userDTO.getBirthday();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(str, formatter);
        user.setBirthday(dateTime);
        System.out.println(dateTime.format(formatter));
        user.setCity(cityDAO.getCityById(userDTO.getCityId()));

        userDAO.regist(user);
    }

    @Override
    public User login(final String login) {

        return userDAO.login(login);
        //шоно вставила

    }
}
