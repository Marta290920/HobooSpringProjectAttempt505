package com.HobooProject.demo.Spring.dao;

import com.HobooProject.demo.Spring.DTO.BookingDTO;
import com.HobooProject.demo.Spring.model.Hotel;
import com.HobooProject.demo.Spring.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface UserDAO {
    void regist(User user);

    User login(String login);
    public User getUserById(Long id);
    Set<Hotel> getFavoriteListByUserId(long userID);

    void saveFavorite(User user);
}
