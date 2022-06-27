package edu.miu.springdata.service;

import edu.miu.springdata.dto.AddressDto;

import java.util.Date;
import java.util.List;

public interface ActivityLogService {
    public void create(Date date, String operation, long duration);
}
