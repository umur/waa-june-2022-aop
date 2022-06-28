package com.example.demo.repository;

import com.example.demo.model.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActivityLogRepository extends CrudRepository<ActivityLog, Integer> {
}