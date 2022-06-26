package miu.edu.aop.service.impl;

import miu.edu.aop.domain.Product;
import miu.edu.aop.dto.ProductDto;
import miu.edu.aop.repo.ProductRepo;
import miu.edu.aop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProductDto> findAll() {
        List<Product> products = (List<Product>) productRepo.findAll();
        return products.stream().map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public void create(ProductDto product) {
        productRepo.save(modelMapper.map(product, Product.class));
        System.out.println("New product added successfully");
    }

    @Override
    public ProductDto update(ProductDto product, int id) {
        Product add = modelMapper.map(product, Product.class);
        productRepo.findById(id).map(ad -> {
            return productRepo.save(add);
        });

        return product;
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }
}
