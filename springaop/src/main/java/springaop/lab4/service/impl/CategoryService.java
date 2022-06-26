package springaop.lab4.service.impl;


import springaop.lab4.dto.ProductDto;

import java.util.List;

public interface CategoryService {

    List<ProductDto> findAllProductsByCategory(String category, double max);
}
