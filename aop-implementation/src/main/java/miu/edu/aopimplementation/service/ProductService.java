package miu.edu.aopimplementation.service;

import miu.edu.aopimplementation.aspect.annotation.ExecutionTime;
import miu.edu.aopimplementation.aspect.annotation.LogMe;
import miu.edu.aopimplementation.dto.ProductDto;
import miu.edu.aopimplementation.entity.Product;

import java.util.Collection;

public interface ProductService {

    public Collection<ProductDto> getAllProduct();

    public Product addProduct(ProductDto productDto);


    public void deleteProduct(Integer id);


    public Product updateProduct(ProductDto productDto, Integer id);
}
