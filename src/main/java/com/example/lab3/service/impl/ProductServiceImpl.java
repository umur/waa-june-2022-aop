package com.example.lab3.service.impl;

import com.example.lab3.DTO.ProductDto;
import com.example.lab3.Repository.ProductRepo;
import com.example.lab3.model.bidirectional.ProductBi;
import com.example.lab3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepo productRepo;

    @Override
    public void save(ProductDto p) {
        productRepo.save(modelMapper.map(p, ProductBi.class));
    }

    @Override
    public void delete(long id) {
        productRepo.deleteById(id);
    }

    @Override
    public void update(long id, ProductDto productDto) {
        ProductBi product = modelMapper.map(productDto, ProductBi.class);
        product.setId(id);
        productRepo.save(product);

    }

    @Override
    public List<ProductDto> findAll() {
        return productRepo.findAll().stream().map(productBi -> modelMapper.map(productBi, ProductDto.class)).toList();
    }
}
