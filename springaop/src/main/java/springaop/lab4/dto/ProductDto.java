package springaop.lab4.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import springaop.lab4.domain.Category;

@Data
@Component
public class ProductDto {
    private Long id;
    private String name;
    private int rating;
    private double price;
    private Category category;
}
