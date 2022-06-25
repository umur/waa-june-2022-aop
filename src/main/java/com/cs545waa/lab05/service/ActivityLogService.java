package com.cs545waa.lab05.service;

import com.cs545waa.lab05.dto.ActivityLogDTO;

import java.util.List;

public interface ActivityLogService {
    public void create(ActivityLogDTO dto);
    public List<ActivityLogDTO> readAll();
}
