package com.lab5.Spring.aop.service.impl;

import com.lab5.Spring.aop.dto.AddProducDto;
import com.lab5.Spring.aop.dto.ProductDto;
import com.lab5.Spring.aop.model.Category;
import com.lab5.Spring.aop.model.Product;
import com.lab5.Spring.aop.repo.CategoryRepo;
import com.lab5.Spring.aop.repo.ProductRepo;
import com.lab5.Spring.aop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> productDtos = new ArrayList<>();
        productRepo.findAll().forEach(p-> {
            System.out.println(p.getCategory().getId());
            productDtos.add(convertToDto(p));
        });
        return productDtos;
    }

    @Override
    public AddProducDto create(AddProducDto addProducDto) {
        Product product = convertToEntity(addProducDto);
        Optional<Category> category = categoryRepo.findById(addProducDto.getCategory_id());
        if (category.isPresent()) {
            product.setCategory(category.get());
        }
        productRepo.save(product);
        return addProducDto;
    }

    public ProductDto convertToDto(Product product) {
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    public Product convertToEntity(AddProducDto addProductDto) {
        Product product = modelMapper.map(addProductDto, Product.class);
        return product;
    }

}
