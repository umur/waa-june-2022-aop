package com.example.aop.controller;

import com.example.aop.aspect.annotation.ExecutionTime;
import com.example.aop.dto.ProductDto;
import com.example.aop.entity.Product;
import com.example.aop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @ExecutionTime
    @GetMapping("")
    public List<Product> findAllUsers(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.findById(id);
    }

    @ExecutionTime
    @GetMapping("/filter")
    public List<Product> getByPriceGreaterThan(@RequestParam(name = "price") int price){
        return productService.findAllByPriceGreaterThan((double) price);
    }

    @PostMapping("")
    public Product addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        productService.deleteById(id);
        return "Deleted";
    }

    @PutMapping("")
    public Product updateUser(@RequestBody Product product){
        return productService.updateProduct(product);
    }

//    @ExecutionTime
//    @GetMapping("")
//    public void getAll(@RequestHeader Map<String, String> headers){
//        Map<String, String> var = headers;
//        System.out.println("getAll method is called");
//    }


}
