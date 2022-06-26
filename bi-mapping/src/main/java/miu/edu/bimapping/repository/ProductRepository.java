package miu.edu.bimapping.repository;

import miu.edu.bimapping.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
