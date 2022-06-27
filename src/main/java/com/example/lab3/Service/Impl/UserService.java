package com.example.lab3.Service.Impl;

import com.example.lab3.Domain.Uni_Directinal.JoinTable.User;
import com.example.lab3.Dto.UserDto;
import com.example.lab3.Service.IUserService;
import com.example.lab3.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public UserService(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> findAll() {
        var users=userRepo.findAll();
        Type listType=new TypeToken<List<UserService>>(){}.getType();
        return modelMapper.map(users,listType);
    }

    @Override
    public UserDto findById(int id) {
        var user=userRepo.findById(id).orElseThrow();

        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public UserDto save(UserDto user) {
        var u=modelMapper.map(user, User.class);
        userRepo.save(u);

        return modelMapper.map(u,UserDto.class);
    }

    @Override
    public String remove(int id) {
        boolean t=userRepo.findById(id).isPresent();
        if(t==true) {
            userRepo.deleteById(id);
        }
        return "deleted";
    }
}
