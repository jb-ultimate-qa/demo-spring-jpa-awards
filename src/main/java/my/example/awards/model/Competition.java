package my.example.awards.model;

import jakarta.persistence.*;

@Entity
@Table(name = "competition")
//@Table(name = "competition", indexes = {@Index(name = "referee_id_uc", columnList = "referee_id", unique = true),
//        @Index(name = "first_player_id_inx", columnList = "first_player_id", unique = false)})
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default")
//    @SequenceGenerator(name = "default", sequenceName = "new_seq_name")
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public CompetitionLevel getCompetitionLevel() {
        return competitionLevel;
    }

    public void setCompetitionLevel(CompetitionLevel competitionLevel) {
        this.competitionLevel = competitionLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}