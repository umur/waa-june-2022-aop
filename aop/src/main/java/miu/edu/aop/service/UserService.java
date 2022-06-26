package miu.edu.aop.service;

import miu.edu.aop.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    void create(UserDto user);
    UserDto update(UserDto user, int id);
    void delete(int id);
}