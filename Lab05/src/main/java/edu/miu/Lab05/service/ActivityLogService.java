package edu.miu.Lab05.service;

import edu.miu.Lab05.dto.LabAopDto;

import java.util.List;

public interface ActivityLogService {

    void save(LabAopDto p);

    List<LabAopDto> getAll();
}
