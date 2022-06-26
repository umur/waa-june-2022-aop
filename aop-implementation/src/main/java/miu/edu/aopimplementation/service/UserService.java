package miu.edu.aopimplementation.service;

import miu.edu.aopimplementation.aspect.annotation.ExecutionTime;
import miu.edu.aopimplementation.aspect.annotation.LogMe;
import miu.edu.aopimplementation.dto.UserDto;
import miu.edu.aopimplementation.entity.User;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

public interface UserService {

    public List<UserDto> getAllUser();


    public User addUser(UserDto userDto);


    public void deleteUser(Integer id);


    public User updateUser(UserDto userDto, Integer id);
}
