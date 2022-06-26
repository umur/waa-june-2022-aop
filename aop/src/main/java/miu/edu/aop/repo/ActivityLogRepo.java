package miu.edu.aop.repo;

import miu.edu.aop.domain.ActivityLog;
import org.springframework.data.repository.CrudRepository;

public interface ActivityLogRepo extends CrudRepository<ActivityLog, Integer> {
}
