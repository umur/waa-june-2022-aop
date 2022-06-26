package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    public void save(User user){
        userRepo.save(user);
    }
    public User getById(int id){
        var res= userRepo.findById(id);
        return res.orElse(null);
    }
    public List<User> getAll(){
        var res= userRepo.findAll();
        List<User> users= new ArrayList<>();
        res.forEach(users::add);
        return users;
    }

    public void delete(int id){
        userRepo.deleteById(id);
    }

    public void update(int id, User user){
        userRepo.deleteById(id);
        userRepo.save(user);
    }

}
