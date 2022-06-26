package edu.miu.aop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name="name")
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Todo> todoList;
}
