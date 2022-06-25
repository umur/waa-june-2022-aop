package com.example.lab5.service;

import com.example.lab5.dto.ActivityDto;
import com.example.lab5.repo.ActivityRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityService{

    private final ActivityRepo activityRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<ActivityDto> getActivity() {
        return activityRepo.findAll().stream().map(activityLog -> modelMapper.map(activityLog, ActivityDto.class)).toList();
    }

    @Override
    public void createActivity(ActivityDto activityDto) {

    }

    @Override
    public void updateActivity(ActivityDto activityDto, int id) {

    }

    @Override
    public void deleteActivity(int id) {

    }
}
