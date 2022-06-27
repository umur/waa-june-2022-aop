package edu.miu.Lab05.controller;


import edu.miu.Lab05.aspect.annotation.ExecutionTime;
import edu.miu.Lab05.dto.LabAopDto;
import edu.miu.Lab05.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activity")
@RequiredArgsConstructor
public class ActivityLogController {

    @Autowired
    ActivityLogService activityLogService;
    @ExecutionTime
    @PostMapping
    public void save() {

    }


    @GetMapping
    public List<LabAopDto> getAll() { return activityLogService.getAll();
    }


}
