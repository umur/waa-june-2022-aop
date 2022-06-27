package com.example.lab3.Repository;

import com.example.lab3.model.bidirectional.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends JpaRepository<ActivityLog, Long> {
}
