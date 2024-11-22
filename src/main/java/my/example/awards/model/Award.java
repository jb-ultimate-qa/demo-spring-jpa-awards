package my.example.awards.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "award")
public class Award {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "year_", nullable = false)
    private Short year;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Player winner;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (" + year + " - " + title + ")";
    }
}