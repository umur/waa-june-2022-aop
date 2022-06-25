package com.example.lab5.controller;

import com.example.lab5.aspect.annotation.ExecutionTime;
import com.example.lab5.dto.ActivityLogDTO;
import com.example.lab5.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aop")
public class AOPController {

    private final ActivityLogService activityLogService;

    @ExecutionTime
    @GetMapping
    public List<ActivityLogDTO> getAllLog() {
        return activityLogService.findAllLogs();
    }
}
