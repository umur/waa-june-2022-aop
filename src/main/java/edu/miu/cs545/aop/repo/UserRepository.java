package edu.miu.cs545.aop.repo;

import edu.miu.cs545.aop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
