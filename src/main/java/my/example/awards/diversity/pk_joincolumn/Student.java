package my.example.awards.diversity.pk_joincolumn;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String fullName;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Education education;
}
