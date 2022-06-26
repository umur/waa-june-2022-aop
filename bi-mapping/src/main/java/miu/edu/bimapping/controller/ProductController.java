package miu.edu.bimapping.controller;

import miu.edu.bimapping.dto.ProductDto;
import miu.edu.bimapping.entity.Product;
import miu.edu.bimapping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public Collection<ProductDto> findAll(){
        return productService.getAllProduct();
    }
    @PostMapping
    public Product addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }

    @PutMapping("/{id}")
    public Product Update(@RequestBody ProductDto productDto, @PathVariable Integer id){
        return productService.updateProduct(productDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        productService.deleteProduct(id);
    }
}
