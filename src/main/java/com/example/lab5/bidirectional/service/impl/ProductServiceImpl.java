package com.example.lab5.bidirectional.service.impl;

import com.example.lab5.bidirectional.dto.ProductDTO;
import com.example.lab5.bidirectional.entity.Product;
import com.example.lab5.bidirectional.repository.ProductRepository;
import com.example.lab5.bidirectional.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        Product product = findById(id);
        if (null != product) productRepository.delete(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).isPresent() ? productRepository.findById(id).get() : null;
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductByPriceGreaterThan(double parseDouble) {
        return productRepository.getProductByPriceGreaterThan(parseDouble)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByPriceLessThanAndCategory_Name(double price, String category) {
        return productRepository.getProductsByPriceLessThanAndCategory_Name(price,category)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByNameContains(String name) {
        return productRepository
                .getProductsByNameContains(name)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByUserId(int id) {
        return productRepository.getProductsByUserId(id)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    //use model mapper here
    public ProductDTO toDTO(Product product){
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product toEntity(ProductDTO productDTO){
        return modelMapper.map(productDTO, Product.class);
    }
}
