package miu.edu.aop.service.impl;

import miu.edu.aop.domain.User;
import miu.edu.aop.dto.UserDto;
import miu.edu.aop.repo.UserRepo;
import miu.edu.aop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        List<User> users = (List<User>) userRepo.findAll();
        return users.stream().map(user-> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public void create(UserDto user) {
        userRepo.save(modelMapper.map(user, User.class));
        System.out.println("New user added successfully");
    }

    @Override
    public UserDto update(UserDto user, int id) {
        User add = modelMapper.map(user, User.class);
        userRepo.findById(id).map(ad -> {
            return userRepo.save(add);
        });

        return user;
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }
}
