package miu.edu.bimapping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Integer id;
    private String street;
    private String zip;
    private String city;
}
