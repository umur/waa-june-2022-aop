package edu.miu.springdata.repo;

import edu.miu.springdata.entity.Category;
import edu.miu.springdata.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product,Integer> {

    List<Product> findAll();
    Product findById(int id);

}
