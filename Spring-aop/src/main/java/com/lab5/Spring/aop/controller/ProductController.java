package com.lab5.Spring.aop.controller;

import com.lab5.Spring.aop.dto.AddProducDto;
import com.lab5.Spring.aop.dto.ProductDto;
import com.lab5.Spring.aop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

//    Used @Pointcut within service package, if you want to check you can remove it and run it!
//    @ExecutionTime
    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {return ResponseEntity.ok(productService.findAll());}

//    Used @Pointcut within service package, if you want to check you can remove it and run it!
//    @ExecutionTime
    @PostMapping
    public ResponseEntity<AddProducDto> create(@RequestBody AddProducDto addProducDto) {
        return ResponseEntity.ok(productService.create(addProducDto));
    }
}
