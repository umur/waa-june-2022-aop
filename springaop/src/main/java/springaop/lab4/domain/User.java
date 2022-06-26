package springaop.lab4.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "user1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    //@JoinColumn
    private List<Review> reviews;
    //@JoinColumn
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Product> products;

    @OneToOne(mappedBy ="user")
    @JsonBackReference
    private Address address;

}
