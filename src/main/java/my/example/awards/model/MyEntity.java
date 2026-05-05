package my.example.awards.model;

import jakarta.persistence.*;

@Entity
//@Table(name = "my_entity_new")
@Table(name = "my_entity")
public class MyEntity {
//    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
}