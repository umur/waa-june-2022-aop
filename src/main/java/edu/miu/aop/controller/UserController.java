package edu.miu.aop.controller;

import edu.miu.aop.aspect.annotation.ExecutionTime;
import edu.miu.aop.dto.UserDto;
import edu.miu.aop.entity.User;
import edu.miu.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ExecutionTime
    @PostMapping("/users/")
    public void save(@RequestBody UserDto p) {
        userService.save(p);
    }

    @ExecutionTime
    @GetMapping("/users/")
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @ExecutionTime
    @GetMapping("/users/{id}")
    public User getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @ExecutionTime
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

    @ExecutionTime
    @PutMapping("/users/{id}")
    public void update(@PathVariable("id") int id, @RequestBody UserDto user) {
        userService.updateUser(user, id);
    }

}
