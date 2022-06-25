package edu.miu.aop.repo;

import edu.miu.aop.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {

    List<User> findAll();

}
