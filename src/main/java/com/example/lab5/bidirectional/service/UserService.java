package com.example.lab5.bidirectional.service;

import com.example.lab5.bidirectional.dto.UserDTO;
import com.example.lab5.bidirectional.entity.User;

import java.util.List;


public interface UserService {
    void save(User user);

    void delete(int id);

    User findById(int id);

    List<UserDTO> getAll();
}
