package miu.edu.bimapping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;
}
