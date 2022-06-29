package com.example.lab5.bidirectional.service.impl;

import com.example.lab5.bidirectional.entity.ActivityLog;
import com.example.lab5.bidirectional.repository.ActivityRepository;
import com.example.lab5.bidirectional.service.ActivityService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }
    @Override
    public void save(ActivityLog activityLog) {
        activityRepository.save(activityLog);
    }
}
