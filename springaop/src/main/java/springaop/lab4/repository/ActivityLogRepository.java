package springaop.lab4.repository;

import org.springframework.data.repository.CrudRepository;
import springaop.lab4.domain.ActivityLog;

public interface ActivityLogRepository extends CrudRepository<ActivityLog,Long> {
}
