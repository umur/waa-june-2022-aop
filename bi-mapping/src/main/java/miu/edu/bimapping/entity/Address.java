package miu.edu.bimapping.entity;

import lombok.Data;

import javax.persistence.*;

@Entity@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String street;
    private String zip;
    private String city;

    @OneToOne
    private User user;
}
