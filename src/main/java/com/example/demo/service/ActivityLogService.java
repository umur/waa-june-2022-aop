package com.example.demo.service;

import com.example.demo.entity.ActivityLog;
import com.example.demo.entity.Address;
import com.example.demo.repo.ActivityLogRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogService {
    private final ActivityLogRepo activityLogRepo;
    public void save(ActivityLog activityLog){
        activityLogRepo.save(activityLog);
    }
}
