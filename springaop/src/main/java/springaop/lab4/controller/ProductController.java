package springaop.lab4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springaop.lab4.dto.ProductDto;
import springaop.lab4.service.impl.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping(path = "{minPrice}")
    public List<ProductDto> getByMinPrice(@PathVariable double min){
     return    productService.getAllProductByMinPrice(min);
    }
    @GetMapping("/products/keyword")
    public List<ProductDto> getAllProductByKeyword(String keyword) {
        return productService.getAllProductByKeyword(keyword);
    }
}
