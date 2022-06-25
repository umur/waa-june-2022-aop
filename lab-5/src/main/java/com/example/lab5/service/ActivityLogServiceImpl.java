package com.example.lab5.service;

import com.example.lab5.dto.ActivityLogDTO;
import com.example.lab5.repo.ActivityLogRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepo activityLogRepo;

    @Override
    public List<ActivityLogDTO> findAllLogs() {
        return null;
    }

    @Override
    public void createLog(ActivityLogDTO dto) {

    }

    @Override
    public void updateLog(ActivityLogDTO dto, int id) {

    }

    @Override
    public void deleteLog(int id) {

    }
}
