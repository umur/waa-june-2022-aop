package edu.miu.cs545.aop.repo;

import edu.miu.cs545.aop.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLogRepo extends JpaRepository<ActivityLog,Long> {
}
