package com.cs545waa.lab05.controller;

import com.cs545waa.lab05.aspect.annotation.ExecutionTime;
import com.cs545waa.lab05.dto.ProductDTO;
import com.cs545waa.lab05.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {
    ProductService service;
    @ExecutionTime
    @GetMapping
    public List<ProductDTO> readAll(){
    return service.readAll();
    }
    @PostMapping
    public void create(@RequestBody ProductDTO dto){
        service.create(dto);
    }
}
