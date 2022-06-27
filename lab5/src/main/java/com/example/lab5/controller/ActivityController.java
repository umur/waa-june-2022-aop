package com.example.lab5.controller;

import com.example.lab5.annotation.ExecutionTime;
import com.example.lab5.dto.ActivityDto;
import com.example.lab5.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
@AllArgsConstructor
public class ActivityController {

    ActivityService activityService;

    @ExecutionTime
    @GetMapping
    public List<ActivityDto> getAll(){
        System.out.println("inside getMapping method");
        return activityService.getActivity();
    }

    @ExecutionTime
    @PostMapping
    public void createActivity(@RequestBody ActivityDto activityDto){
        //activityService.createActivity(activityDto);
        //System.out.println("inside postMapping method");
    }

    @ExecutionTime
    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable int id){
        activityService.deleteActivity(id);
    }
}
