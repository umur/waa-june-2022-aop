package edu.miu.springdata.repo;

import edu.miu.springdata.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<Category,Integer> {

}
