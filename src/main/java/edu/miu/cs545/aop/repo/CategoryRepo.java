package edu.miu.cs545.aop.repo;

import edu.miu.cs545.aop.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends CrudRepository<Category,Integer> {
    List<Category> findAll();
    Category findById(int id);
}
