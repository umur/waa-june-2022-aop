package com.example.lab3.controller;

import com.example.lab3.DTO.ProductDto;
import com.example.lab3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @PostMapping
    public void create(@RequestBody ProductDto productDto) {
        productService.save(productDto);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody ProductDto productDto, @PathVariable long id) {
        productService.update(id, productDto);
    }


}
