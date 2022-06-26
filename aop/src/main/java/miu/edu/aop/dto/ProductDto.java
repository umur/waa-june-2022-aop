package miu.edu.aop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private long id;
    private String nme;
    private double price;
    private double rating;
    private CategoryDto categoryDto;
}
