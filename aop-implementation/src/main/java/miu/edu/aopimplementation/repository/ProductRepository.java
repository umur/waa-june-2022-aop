package miu.edu.aopimplementation.repository;

import miu.edu.aopimplementation.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
