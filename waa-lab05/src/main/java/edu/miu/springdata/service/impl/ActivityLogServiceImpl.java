package edu.miu.springdata.service.impl;



import edu.miu.springdata.entity.ActivityLog;
import edu.miu.springdata.repo.ActivityLogRepo;
import edu.miu.springdata.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepo activityLogRepo;

    @Override
    public void create(Date date, String operation, long duration) {
        ActivityLog activityLog = new ActivityLog();
        activityLog.setDate(date);
        activityLog.setOperation(operation);
        activityLog.setDuration(duration);
        activityLogRepo.save(activityLog);
    }


}
