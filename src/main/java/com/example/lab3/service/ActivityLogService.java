package com.example.lab3.service;

import com.example.lab3.DTO.ActivityLogDto;

import java.time.LocalDate;

public interface ActivityLogService {
    void create(ActivityLogDto activityLogDto);
}
