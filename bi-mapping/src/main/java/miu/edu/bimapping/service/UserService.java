package miu.edu.bimapping.service;

import miu.edu.bimapping.dto.UserDto;
import miu.edu.bimapping.entity.User;

import java.util.List;

public interface UserService {
    public List<UserDto> getAllUser();

    public User addUser(UserDto userDto);

    public void deleteUser(Integer id);

    public User updateUser(UserDto userDto, Integer id);
}
