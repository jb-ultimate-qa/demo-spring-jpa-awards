package my.example.awards.diversity.id_types;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "uuid_entity")
@NamedQueries({
        @NamedQuery(name = "UuidEntityQuery_2", query = "select e from UuidEntity e where id = :param") // run with aaaabbbb-1111-2222-3333-4444ffffaaaa
})
public class UuidEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}