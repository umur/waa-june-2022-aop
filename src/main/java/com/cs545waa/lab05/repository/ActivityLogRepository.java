package com.cs545waa.lab05.repository;

import com.cs545waa.lab05.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends CrudRepository<ActivityLog,Integer> {
}
