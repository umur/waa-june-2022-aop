package springaop.lab4.dto;


import lombok.Data;
import org.springframework.stereotype.Component;
import springaop.lab4.domain.Address;
import springaop.lab4.domain.Product;
import springaop.lab4.domain.Review;

import java.util.List;

@Data
@Component
public class UserDto {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private List<Review> reviews;
    private Address address;
    private List<Product> products;
}

