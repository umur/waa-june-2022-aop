package com.example.lab5.bidirectional.repository;

import com.example.lab5.bidirectional.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {

}
