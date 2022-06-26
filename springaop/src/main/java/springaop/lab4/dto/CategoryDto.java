package springaop.lab4.dto;


import lombok.Data;
import org.springframework.stereotype.Component;
import springaop.lab4.domain.Product;

import java.util.List;

@Data
@Component
public class CategoryDto {
    private Long id;
    private String name;
    private List<Product> products;
}
