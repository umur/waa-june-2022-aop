package edu.miu.Lab05.service.impl;

import edu.miu.Lab05.dto.LabAopDto;
import edu.miu.Lab05.entity.LabAop;
import edu.miu.Lab05.repo.ActiviyLogRepo;
import edu.miu.Lab05.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {


    private  final ActiviyLogRepo activiyLogRepo;

    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public void save(LabAopDto p) {
        activiyLogRepo.save(modelMapper.map(p, LabAop.class));

    }
    @Override
    public List<LabAopDto> getAll() {
        return StreamSupport.stream(activiyLogRepo.findAll().spliterator(), false)
                .map(m->modelMapper.map(m,LabAopDto.class))
                .collect(Collectors.toList());
    }



}
