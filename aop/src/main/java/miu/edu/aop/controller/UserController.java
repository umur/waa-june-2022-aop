package miu.edu.aop.controller;

import miu.edu.aop.aspect.annotation.ExecutionTime;
import miu.edu.aop.aspect.annotation.LogMe;
import miu.edu.aop.dto.UserDto;
import miu.edu.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    @LogMe
    @ExecutionTime
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PostMapping
    @LogMe
    @ExecutionTime
    public void create(@RequestBody UserDto user) {
        userService.create(user);
    }

    @PutMapping("/{id}")
    @LogMe
    @ExecutionTime
    public UserDto update(@RequestBody UserDto user, @PathVariable int id) {
        return userService.update(user, id);
    }

    @DeleteMapping("/{id}")
    @LogMe
    @ExecutionTime
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }
}
