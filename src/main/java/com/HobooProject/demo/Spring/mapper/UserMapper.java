package com.HobooProject.demo.Spring.mapper;

import com.HobooProject.demo.Spring.DTO.UserDTO;
import com.HobooProject.demo.Spring.model.User;

import java.time.LocalDate;

public class UserMapper {
    public User map(UserDTO userDTO) {
        final User result = new User();
        result.setLastname(userDTO.getLastname());
        result.setName(userDTO.getName());
        result.setSurname(userDTO.getSurname());
      //  result.setBirthday(LocalDate.parse(userDTO.getBirthday()));
        result.setStreet(userDTO.getStreet());
        result.setNumberOfBuilding(userDTO.getNumberOfBuilding());
        result.setLogin(userDTO.getLogin());
        result.setPhoneNumber(userDTO.getPhoneNumber());
        result.setPassword(userDTO.getPassword());
        result.setId(userDTO.getId());
        return result;
    }
}
