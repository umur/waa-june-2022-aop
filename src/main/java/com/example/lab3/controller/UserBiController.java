package com.example.lab3.controller;

import com.example.lab3.DTO.UserBiDTO;
import com.example.lab3.model.bidirectional.UserBi;
import com.example.lab3.service.UserBiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usersBi")
@AllArgsConstructor
public class UserBiController {
    private final UserBiService userBiService;

    @PostMapping
    public void save(@RequestBody UserBi userBi) {
        userBiService.save(userBi);
    }

    @GetMapping
    public List<UserBi> getAll() {
        return userBiService.getAll();

    }

    @GetMapping("/{id}")
    public UserBi getById(@PathVariable long id) {
        return userBiService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        userBiService.delete(id);
    }

    @GetMapping("/search")
    public List<UserBiDTO> getByAge(@RequestParam int age) {
        return null;
    }


}
