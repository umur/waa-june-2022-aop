package com.example.lab3.Repository;

import com.example.lab3.model.bidirectional.CategoryBi;
import com.example.lab3.model.bidirectional.ProductBi;
import com.example.lab3.model.bidirectional.ReviewBi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepo extends JpaRepository<ProductBi, Long> {
    List<ProductBi> findAllByPriceAfter(double minPrice);
    List<ProductBi>  findAllByCategoryBiAndPriceBefore(CategoryBi categoryBi,double price);

    List<ProductBi> findAllByNameContaining(String name);

//    List<ProductBi> findAllBy(long id);

//    List<ReviewBi> findAllByProductBi(long id);
}
