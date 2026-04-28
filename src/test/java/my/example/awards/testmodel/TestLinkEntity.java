package my.example.awards.testmodel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class TestLinkEntity {
    @Id
    private Integer id;
    private Integer testNumber;
}