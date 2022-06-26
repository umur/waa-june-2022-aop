package com.example.aop.service.impl;

import com.example.aop.entity.ActivityLog;
import com.example.aop.repository.IActivityLogRepo;
import com.example.aop.service.IActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityLogService implements IActivityLogService {
    @Autowired
    private IActivityLogRepo activityLogRepo;

    @Override
    public ActivityLog save(ActivityLog activityLog) {
        return activityLogRepo.save(activityLog);
    }

    @Override
    public List<ActivityLog> activitylogs() {
        return activityLogRepo.findAll();
    }
}
