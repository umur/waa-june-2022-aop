package com.example.lab3.Service;

import com.example.lab3.Dto.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> findAll();

    UserDto findById(int id);

    UserDto save(UserDto user);

    String remove(int id);
}
