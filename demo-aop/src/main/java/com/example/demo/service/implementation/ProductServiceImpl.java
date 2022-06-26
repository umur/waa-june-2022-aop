package com.example.demo.service.implementation;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;
import com.example.demo.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  ModelMapper modelMapper;
  @Autowired
  ListMapper<Product, ProductDto> listMapper;
  @Autowired
  ProductRepo productRepo;

  @Override
  public List<ProductDto> findAllProduct() {
    List<Product> products = (List<Product>) productRepo.findAll();
    List<ProductDto> productDto = (List<ProductDto>) listMapper.mapList(products, new ProductDto());
    return productDto;
  }

  @Override
  public void createProduct(ProductDto productDto) {
    Product product = modelMapper.map(productDto, Product.class);
    productRepo.save(product);
  }

  @Override
  public void delete(int id) {
    productRepo.deleteById(id);
  }

  @Override
  public void update(int id, ProductDto addressDto) {
    Product product = modelMapper.map(addressDto, Product.class);
    productRepo.findById(id).map(st -> {
      st.setName(product.getName());
      st.setPrice(product.getPrice());
      return productRepo.save(st);
    });

  }

  @Override
  public List<ProductDto> findAllByPriceAfter(double checkPrice) {
    List<Product> products = productRepo.findAllByPriceAfter(checkPrice);
    List<ProductDto> productDtos = products.stream()
            .map(st -> modelMapper.map(st, ProductDto.class)).toList();
    return productDtos;
  }

//  @Override
//  public List<ProductDto> findAllByCategoryAndPriceBefore(Category category, double checkprice) {
//    List<Product> products = productRepo.findAllByCategoryAndPriceBefore(category, checkprice);
//    List<ProductDto> productDtos = products.stream().map(st -> modelMapper.map(st, ProductDto.class)).toList();
//    return productDtos;
//  }

  @Override
  public List<ProductDto> findAllByNameContains(String checkName) {
    List<Product> products = productRepo.findAllByNameContains(checkName);
    List<ProductDto> productDtos = products.stream().map(st -> modelMapper.map(st, ProductDto.class)).toList();

    return productDtos;
  }
}
