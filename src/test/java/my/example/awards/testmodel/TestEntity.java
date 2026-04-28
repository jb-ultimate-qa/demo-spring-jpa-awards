package my.example.awards.testmodel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TestEntity {
    @Id private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "link_entity_id")
    private TestLinkEntity linkEntity;
}
