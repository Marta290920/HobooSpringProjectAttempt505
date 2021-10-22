package com.HobooProject.demo.Spring.service;

import com.HobooProject.demo.Spring.DTO.UserDTO;
import com.HobooProject.demo.Spring.model.User;

public interface UserService {
    void regist(UserDTO userDTO);

    User login(String login);
}
