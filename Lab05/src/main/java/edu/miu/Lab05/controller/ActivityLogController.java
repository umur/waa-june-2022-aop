package edu.miu.Lab05.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/activity")
public class ActivityLogController {

    @GetMapping
    public void getAll(){
        System.out.println("Test Statement");
    }

}
