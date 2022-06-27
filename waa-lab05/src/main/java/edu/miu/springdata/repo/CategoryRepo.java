package edu.miu.springdata.repo;

import edu.miu.springdata.entity.Category;
import edu.miu.springdata.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends CrudRepository<Category,Integer> {

    List<Category> findAll();
    Category findById(int id);

}
