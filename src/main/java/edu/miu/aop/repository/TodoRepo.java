package edu.miu.aop.repository;

import edu.miu.aop.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends CrudRepository<Todo, Integer> {
}
