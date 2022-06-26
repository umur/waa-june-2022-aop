package miu.edu.aop.controller;

import miu.edu.aop.aspect.annotation.ExecutionTime;
import miu.edu.aop.aspect.annotation.LogMe;
import miu.edu.aop.dto.ProductDto;
import miu.edu.aop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    @LogMe
    @ExecutionTime
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @PostMapping
    @LogMe
    @ExecutionTime
    public void create(@RequestBody ProductDto product) {
        productService.create(product);
    }

    @PutMapping("/{id}")
    @LogMe
    @ExecutionTime
    public ProductDto update(@RequestBody ProductDto product, @PathVariable int id) {
        return productService.update(product, id);
    }

    @DeleteMapping("/{id}")
    @LogMe
    @ExecutionTime
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

}
