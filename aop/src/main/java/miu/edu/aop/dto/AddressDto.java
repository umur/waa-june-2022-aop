package miu.edu.aop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {
    private int id;
    private String street;
    private String zip;
    private String city;

}
