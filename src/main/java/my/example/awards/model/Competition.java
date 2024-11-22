package my.example.awards.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter@Entity
@Table(name = "competition")
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Enumerated
    @Column(name = "competition_level")
    private CompetitionLevel competitionLevel;

    @Embedded
    private Location location;

    @ManyToOne
    @JoinColumn(name = "referee_id")
    private Referee referee;

    @ManyToOne
    @JoinColumn(name = "first_player_id")
    private Player firstPlayer;

    @ManyToOne
    @JoinColumn(name = "second_player_id")
    private Player secondPlayer;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "competitionLevel = " + competitionLevel + ")"
//                "location = " + location + ", " +
//                "referee = " + referee + ", " +
//                "firstPlayer = " + firstPlayer + ", " +
//                "secondPlayer = " + secondPlayer + ")"
                ;
    }

}