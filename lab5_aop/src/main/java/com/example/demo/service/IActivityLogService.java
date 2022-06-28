package com.example.demo.service;
import com.example.demo.model.ActivityLog;

import java.util.List;
import java.util.Optional;

public interface IActivityLogService {
    public List<ActivityLog> getAllActivityLog();
    public ActivityLog createActivityLog(ActivityLog activityLog);
    public ActivityLog updateActivityLog(ActivityLog activityLog);
    public Optional<ActivityLog> getById(int id);
    public void deleteById(int id);
}