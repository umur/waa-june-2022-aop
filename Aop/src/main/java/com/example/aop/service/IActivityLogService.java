package com.example.aop.service;

import com.example.aop.entity.ActivityLog;

import java.util.List;

public interface IActivityLogService {
    ActivityLog save(ActivityLog activityLog);
    List<ActivityLog> activitylogs();

}
