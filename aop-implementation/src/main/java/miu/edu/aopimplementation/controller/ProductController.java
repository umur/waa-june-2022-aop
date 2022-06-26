package miu.edu.aopimplementation.controller;

import miu.edu.aopimplementation.aspect.annotation.ExecutionTime;
import miu.edu.aopimplementation.aspect.annotation.LogMe;
import miu.edu.aopimplementation.dto.ProductDto;
import miu.edu.aopimplementation.entity.Product;
import miu.edu.aopimplementation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    @ExecutionTime
    @LogMe
    @GetMapping
    public Collection<ProductDto> findAll(){
        return productService.getAllProduct();
    }

    @ExecutionTime
    @LogMe
    @PostMapping
    public Product addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }

    @ExecutionTime
    @LogMe
    @PutMapping("/{id}")
    public Product Update(@RequestBody ProductDto productDto, @PathVariable Integer id){
        return productService.updateProduct(productDto, id);
    }

    @ExecutionTime
    @LogMe
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        productService.deleteProduct(id);
    }
}
