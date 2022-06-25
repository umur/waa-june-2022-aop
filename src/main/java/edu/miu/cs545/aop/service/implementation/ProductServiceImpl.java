package edu.miu.cs545.aop.service.implementation;

import edu.miu.cs545.aop.dto.ProductDto;
import edu.miu.cs545.aop.entity.Product;
import edu.miu.cs545.aop.repo.CategoryRepo;
import edu.miu.cs545.aop.repo.ProductRepo;
import edu.miu.cs545.aop.service.ProductService;
import edu.miu.cs545.aop.utils.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public List<ProductDto> findProductByMinPrice(int minPrice) {

        var dataList = productRepo.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : dataList) {
            if (product.getPrice() > minPrice) {
                var rs = ProductUtils.parseProductToProductDto(product);
                productDtoList.add(rs);
            }
        }
        return productDtoList;
    }

    @Override
    public List<ProductDto> findProductByCatAndPrice(int maxPrice, int id) {
        List<ProductDto> productDtoList = new ArrayList<>();
        var category = categoryRepo.findById(id);
        List<Product> products = category.getProducts();
        for (Product product : products) {
            if (product.getPrice() < maxPrice) {
                var rs = ProductUtils.parseProductToProductDto(product);
                productDtoList.add(rs);
            }
        }
        return productDtoList;
    }

    @Override
    public List<ProductDto> findProductByName(String name) {

        var dataList = productRepo.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : dataList) {
            if (product.getName().contains(name)) {
                var rs = ProductUtils.parseProductToProductDto(product);
                productDtoList.add(rs);
            }
        }
        return productDtoList;
    }

    @Override
    public List<ProductDto> findProductByUserId(int userId) {
        var dataList = productRepo.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : dataList) {
            if (product.getUser().getId() == userId) {
                var rs = ProductUtils.parseProductToProductDto(product);
                productDtoList.add(rs);
            }
        }
        return productDtoList;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return ProductUtils.parseProductToProductDto(productRepo.save(ProductUtils.parseProductDtoToProduct(productDto)));
    }

    @Override
    public ProductDto updateProduct(int id, ProductDto productDto) {
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepo.findAll().stream().map(p-> ProductUtils.parseProductToProductDto(p)).toList();
    }

    @Override
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

}