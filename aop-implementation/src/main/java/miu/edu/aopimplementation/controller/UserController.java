package miu.edu.aopimplementation.controller;

import miu.edu.aopimplementation.aspect.annotation.ExecutionTime;
import miu.edu.aopimplementation.aspect.annotation.LogMe;
import miu.edu.aopimplementation.dto.UserDto;
import miu.edu.aopimplementation.entity.User;
import miu.edu.aopimplementation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @ExecutionTime
    @LogMe
    @GetMapping
    public List<UserDto> findAll(){
        return userService.getAllUser();
    }

    @ExecutionTime
    @LogMe
    @PostMapping
    public User addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }


    @ExecutionTime
    @LogMe
    @PutMapping("/{id}")
    public User Update(@RequestBody UserDto userDto, @PathVariable Integer id){
        return userService.updateUser(userDto, id);
    }

    @ExecutionTime
    @LogMe
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        userService.deleteUser(id);
    }



}
