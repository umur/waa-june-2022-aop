package com.example.aop.repository;

import com.example.aop.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActivityLogRepo extends JpaRepository<ActivityLog, Integer> {
}
