package edu.miu.springdata.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.springdata.entity.Product;
import edu.miu.springdata.entity.User;
import lombok.Data;

import javax.persistence.OneToOne;

@Data
public class AddressDto {

    private int id;
    private String street;
    private int zip;
    private String city;
    private User user;
}
