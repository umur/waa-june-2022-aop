package com.example.lab3.Repository;

import com.example.lab3.model.bidirectional.CategoryBi;
import com.example.lab3.model.unidirectional.CategoryUni;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<CategoryBi,Long> {
}
