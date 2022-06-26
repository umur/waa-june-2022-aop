package springaop.lab4.service.impl;


import springaop.lab4.dto.ProductDto;

import java.util.List;

public interface ProductService {

     List<ProductDto> getAllProductByMinPrice(double min);

     List<ProductDto> getAllProductByMaxPrice(double max);

     List<ProductDto> getAllProductByKeyword(String keyword);

    // List<ProductDto> getAllByUserId(int userId);


}
