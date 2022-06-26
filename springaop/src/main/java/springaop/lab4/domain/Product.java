package springaop.lab4.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int rating;
    private double price;

    @JsonManagedReference
    @ManyToOne
    private Category category;
    @ManyToOne
    @JsonManagedReference
    private User user;
    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
