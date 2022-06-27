package edu.miu.springdata.repo;

import edu.miu.springdata.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog,Integer> {
    ActivityLog save(ActivityLog a);
}
