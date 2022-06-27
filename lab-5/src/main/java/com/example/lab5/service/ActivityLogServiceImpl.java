package com.example.lab5.service;

import com.example.lab5.dto.ActivityLogDTO;
import com.example.lab5.entity.ActivityLog;
import com.example.lab5.repo.ActivityLogRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepo activityLogRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<ActivityLogDTO> findAllLogs() {
        return activityLogRepo.findAll()
                .stream()
                .map(activityLog -> modelMapper.map(activityLog, ActivityLogDTO.class))
                .toList();
    }

    @Override
    public void createLog(ActivityLogDTO dto) {
        activityLogRepo.save(modelMapper.map(dto, ActivityLog.class));
    }

    @Override
    public void updateLog(ActivityLogDTO dto, int id) {
        activityLogRepo.save(modelMapper.map(dto, ActivityLog.class));
    }

    @Override
    public void deleteLog(int id) {
        activityLogRepo.deleteById(id);
    }
}
