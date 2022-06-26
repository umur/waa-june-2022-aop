package com.example.aop.service.impl;

import com.example.aop.dto.ProductDto;
import com.example.aop.entity.Product;
import com.example.aop.repo.ProductRepo;
import com.example.aop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ModelMapper modelMapper;

    public List<Product> findAll() {
        return (List<Product>) productRepo.findAll();
    }

    @Override
    public List<Product> findAllByPriceGreaterThan(Double price) {
        return productRepo.findAllByPriceGreaterThan(price);
    }

    public Product findById(int id) {
       return productRepo.findById(id).get();
    }

    public Product addProduct(ProductDto productDto) {
       return productRepo.save(modelMapper.map(productDto, Product.class));
    }

    public Product updateProduct(Product product){
        return productRepo.save(product);
    }

    public void deleteById(int id){
        productRepo.deleteById(id);
    }
}
