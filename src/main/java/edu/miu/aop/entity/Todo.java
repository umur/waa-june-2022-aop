package edu.miu.aop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;
    @Column(name = "description", length = 200, nullable = false)
    private String description;
    @Column(name = "crated_at")
    private Date createdAt;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
