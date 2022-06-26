package com.example.aop.service;


import com.example.aop.dto.UserDto;
import com.example.aop.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(int id);
    User addUser(UserDto userDto);
    User updateUser(User user);
    void deleteById(int id);
}
