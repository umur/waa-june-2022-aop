package com.example.lab3.Controller;

import com.example.lab3.Dto.UserDto;
import com.example.lab3.Service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    //@Resource
    @Autowired
    private UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping("/users")
    public List<UserDto> findAll(){
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public UserDto findById(@PathVariable int id){
        return userService.findById(id);
    }
    @PostMapping("/user")
    public UserDto save(@RequestBody UserDto user){
        return userService.save(user);
    }
    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id){
        return userService.remove(id);
    }
}
