package com.example.lab3.service.impl;


import com.example.lab3.DTO.ActivityLogDto;
import com.example.lab3.Repository.ActivityLogRepo;
import com.example.lab3.model.bidirectional.ActivityLog;
import com.example.lab3.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepo activityLogRepo;
    private final ModelMapper modelMapper;

    @Override
    public void create(ActivityLogDto activityLogDto) {
        activityLogRepo.save(modelMapper.map(activityLogDto, ActivityLog.class));
    }
}
