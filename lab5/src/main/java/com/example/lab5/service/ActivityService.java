package com.example.lab5.service;

import com.example.lab5.dto.ActivityDto;

import java.util.List;

public interface ActivityService {
    public List<ActivityDto> getActivity();
    public void createActivity(ActivityDto activityDto);
    public void updateActivity(ActivityDto activityDto, int id);
    public void deleteActivity(int id);
}
