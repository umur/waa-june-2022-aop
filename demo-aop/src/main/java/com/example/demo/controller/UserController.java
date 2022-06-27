package com.example.demo.controller;

import com.example.demo.aspect.annotations.ExecutionTime;
import com.example.demo.aspect.annotations.LogMe;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
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
  public List<UserDto> findAllUser() {

    return userService.findAllUser();
  }

  @PostMapping
  @LogMe
  @ExecutionTime
  public void createUser(@RequestBody UserDto dto) {
    userService.createUser(dto);
  }

  @DeleteMapping("/{id}")
  @LogMe
  @ExecutionTime
  public void deleteUser(@PathVariable int id) {
    userService.delete(id);
  }

  @PutMapping("/{id}")
  @LogMe
  @ExecutionTime
  public void update(@RequestBody @PathVariable int id, UserDto userDto) {

    userService.update(id, userDto);
  }
}
