package com.example.demo.service;

import com.example.demo.dto.UserDto;

import java.util.List;


public interface UserService {
  List<UserDto> findAllUser();

  void createUser(UserDto dto);

  void delete(int id);

  void update(int id, UserDto dto);
}
