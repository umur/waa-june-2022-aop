package miu.edu.bimapping.service;

import miu.edu.bimapping.dto.ProductDto;
import miu.edu.bimapping.entity.Product;

import java.util.Collection;

public interface ProductService {
    public Collection<ProductDto> getAllProduct();

    public Product addProduct(ProductDto productDto);

    public void deleteProduct(Integer id);

    public Product updateProduct(ProductDto productDto, Integer id);
}
