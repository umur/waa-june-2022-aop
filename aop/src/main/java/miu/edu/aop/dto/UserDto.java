package miu.edu.aop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.aop.domain.Address;
import miu.edu.aop.domain.Review;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastname;

    List<Review> reviewList = new ArrayList<>();

    Address address;
}
