package springaop.lab4.service.impl;

import springaop.lab4.dto.ProductDto;

import java.util.List;

public interface UserService {

    List<ProductDto> getAllCreateProductsByUserId(int userId);
}
