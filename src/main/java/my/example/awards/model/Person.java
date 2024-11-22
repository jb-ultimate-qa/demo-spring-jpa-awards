package my.example.awards.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Person {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name")
    private String fullName;

}