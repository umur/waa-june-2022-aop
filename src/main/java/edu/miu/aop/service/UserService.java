package edu.miu.aop.service;

import edu.miu.aop.dto.UserDto;
import edu.miu.aop.entity.User;

import java.util.List;

public interface UserService {
    void save(UserDto user);

    public void updateUser(UserDto user, Integer id);
    void delete(int id);

    User getById(int id);

    List<UserDto> getAll();
}
