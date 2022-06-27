package edu.miu.cs545.aop.service;

import edu.miu.cs545.aop.entity.ActivityLog;


import java.util.List;

public interface ActivityLogService {
    ActivityLog saveLog(ActivityLog activityLog);
    List<ActivityLog> getActivityLog();
}
