package miu.edu.bimapping.service.impl;

import miu.edu.bimapping.dto.ProductDto;
import miu.edu.bimapping.entity.Product;
import miu.edu.bimapping.repository.ProductRepository;
import miu.edu.bimapping.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Collection<ProductDto> getAllProduct() {
        List<Product> products = (List<Product>) productRepository.findAll();
        List<ProductDto> productsDto = products.stream()
                .map(st ->toDto(st))
                .collect(Collectors.toList());
        return productsDto;
    }

    @Override
    public Product addProduct(ProductDto productDto) {
        Product product = toEntity(productDto);
        return productRepository.save(product) ;
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(ProductDto productDto, Integer id) {
        Product product = toEntity(productDto);
        productRepository.findById(id).map(products->{
            products.setName(product.getName());
            products.setPrice(product.getPrice());
            products.setRating(product.getRating());
            return productRepository.save(products);
        });
        return product;
    }

    public ProductDto toDto(Product product){
        ProductDto productDto = mapper.map(product, ProductDto.class);
        return productDto;
    }

    public Product toEntity(ProductDto productDto){
        Product product = mapper.map(productDto, Product.class);
        return product;
    }
}
