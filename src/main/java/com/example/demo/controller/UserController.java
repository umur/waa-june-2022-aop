package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("labs/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public void save(@RequestBody User u){
        userService.save(u);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public  void update(@PathVariable int id, @RequestBody User u){
        userService.update(id,u);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id){
        return userService.getById(id);
    }

}
