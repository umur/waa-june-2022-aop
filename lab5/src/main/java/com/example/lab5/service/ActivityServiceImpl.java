package com.example.lab5.service;

import com.example.lab5.dto.ActivityDto;
import com.example.lab5.entity.ActivityLog;
import com.example.lab5.repo.ActivityRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityService{

    private final ActivityRepo activityRepo;


//    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    public ActivityServiceImpl(ModelMapper mapper, ActivityRepo activityRepo){
        this.modelMapper=mapper;
        this.activityRepo=activityRepo;

    }
    @Override
    public List<ActivityDto> getActivity() {
        return activityRepo.findAll().stream().map(activityLog -> modelMapper.map(activityLog, ActivityDto.class)).toList();
    }

    @Override
    public void createActivity(ActivityDto activityDto) {
        ActivityLog log =modelMapper.map(activityDto, ActivityLog.class);
        activityRepo.save(log);
    }

    @Override
    public void updateActivity(ActivityDto activityDto, int id) {
        ActivityLog activityLog=modelMapper.map(activityDto,ActivityLog.class);
        activityLog.setId(id);
        activityRepo.save(activityLog);
    }

    @Override
    public void deleteActivity(int id) {
        activityRepo.deleteById(id);
    }
}
