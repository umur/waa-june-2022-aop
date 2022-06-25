package com.example.lab5.service;

import com.example.lab5.dto.ActivityLogDTO;

import java.util.List;

public interface ActivityLogService {

    List<ActivityLogDTO> findAllLogs();

    void createLog(ActivityLogDTO dto);

    void updateLog(ActivityLogDTO dto, int id);

    void deleteLog(int id);
}
