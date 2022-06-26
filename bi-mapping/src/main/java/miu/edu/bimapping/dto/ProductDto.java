package miu.edu.bimapping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data@Component
@NoArgsConstructor@AllArgsConstructor
public class ProductDto {
    private Integer id;

    private String name;
    private String price;
    private double rating;
}
