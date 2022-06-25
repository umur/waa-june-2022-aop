package edu.miu.cs545.aop.controller;

import edu.miu.cs545.aop.dto.ReviewDto;
import edu.miu.cs545.aop.dto.UserDto;
import edu.miu.cs545.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping
    public UserDto createNewUser(@RequestBody UserDto userDto){
        return userService.createNewUser(userDto);
    }


    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    //patch mapping specific update only
    @PatchMapping("/{id}")
//    @PutMapping("/{id}")
    public UserDto updateUserById(@PathVariable Integer id, @RequestBody UserDto userDto){
        return userService.updateUserById(id,userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
    }
}
