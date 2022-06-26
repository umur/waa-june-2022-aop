package miu.edu.aopimplementation.repository;

import miu.edu.aopimplementation.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
