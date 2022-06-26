package com.example.aop.controller;

import com.example.aop.aspect.annotation.ExecutionTime;
import com.example.aop.dto.UserDto;
import com.example.aop.entity.User;
import com.example.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ExecutionTime
    @GetMapping("")
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @ExecutionTime
    @PostMapping("")
    public User addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteById(id);
    }

    @PutMapping("")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

}
