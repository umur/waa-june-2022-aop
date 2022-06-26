package edu.miu.aop.service.impl;

import edu.miu.aop.entity.ActivityLog;
import edu.miu.aop.repository.ActivityLogRepo;
import edu.miu.aop.service.ActivityLogService;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepo activityLogRepo;

    public ActivityLogServiceImpl(ActivityLogRepo activityLogRepo) {
        this.activityLogRepo = activityLogRepo;
    }


    @Override
    public ActivityLog save(ActivityLog al) {
        return activityLogRepo.save(al);
    }
}
