package springaop.lab4.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springaop.lab4.dto.ProductDto;
import springaop.lab4.service.impl.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")

public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories/filterPrice")
    public List<ProductDto> findAllProductsByCategory(String category, double max){
       return categoryService.findAllProductsByCategory(category,max);
    }
}
