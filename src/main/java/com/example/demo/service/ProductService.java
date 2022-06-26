package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public void save(Product p){
        productRepo.save(p);
    }
    public Product getById(int id){
        var res= productRepo.findById(id);
        return res.orElse(null);
    }
    public List<Product> getAll(){
        var res= productRepo.findAll();
        List<Product> products= new ArrayList<>();
        res.forEach(products::add);
        return products;
    }

    public List<Product> findByName(String keyword){
        return productRepo.findAllyByNameContaining(keyword);
    }

    public List<Product> findByCostGreaterThan(Double minCost){
        return productRepo.findAllByPriceGreaterThan(minCost);
    }

    public List<Product> findByCategoryIdAndPriceLessThan(int cid,Double maxPrice){
        return productRepo.findAllByCategoryIdAndPriceLessThan(cid, maxPrice);
    }

    public List<Product> findAllReviewedByUser(int uid){
        return productRepo.findByReviewsUserId(uid);
    }


    public void delete(int id){
        productRepo.deleteById(id);
    }

    public void update(int id, Product p){
        productRepo.deleteById(id);
        productRepo.save(p);
    }


}
