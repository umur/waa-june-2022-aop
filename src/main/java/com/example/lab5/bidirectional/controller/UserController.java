package com.example.lab5.bidirectional.controller;

import com.example.lab5.bidirectional.dto.UserDTO;
import com.example.lab5.bidirectional.entity.User;
import com.example.lab5.bidirectional.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/save")
    public void createUser(@RequestBody User user){
        userService.save(user);
    }

    @GetMapping("/get")
    public List<UserDTO> getAll(){
        return userService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }
}
