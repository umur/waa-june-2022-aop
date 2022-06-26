package miu.edu.aop.repo;

import miu.edu.aop.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {
}
