package com.example.lab5.bidirectional.repository;

import com.example.lab5.bidirectional.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<ActivityLog,Integer> {

}
