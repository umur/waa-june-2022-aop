package com.cs545waa.lab05.service.implementeation;

import com.cs545waa.lab05.dto.ActivityLogDTO;
import com.cs545waa.lab05.entity.ActivityLog;
import com.cs545waa.lab05.repository.ActivityLogRepository;
import com.cs545waa.lab05.service.ActivityLogService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@Data
@AllArgsConstructor
public class ActivityLogImplementation implements ActivityLogService {
    private final ModelMapper mapper;
    private final ActivityLogRepository repository;
    @Override
    public void create(ActivityLogDTO dto) {
        repository.save(mapper.map(dto, ActivityLog.class));
    }

    @Override
    public List<ActivityLogDTO> readAll() {
        List<ActivityLogDTO> dtos=new ArrayList<>();
        repository.findAll().forEach(activity -> dtos.add(mapper.map(activity,ActivityLogDTO.class)));
        return dtos;
    }
}
