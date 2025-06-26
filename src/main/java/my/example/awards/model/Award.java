package my.example.awards.model;

import jakarta.persistence.*;

@Entity(name = "AwardLogical")
@Table(name = "Award", indexes = {@Index(name = "winnerIdIdx", columnList = "winner_id")})
@NamedQuery(name = "Award.findByWinnerFullNameLike", query = "select a from AwardLogical a where a.winner.fullName like :fullName")
public class Award {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "awardYear", nullable = false)
    private Short year;

    @Column(name = "awardTitle", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "winnerId")
    private Player winner;

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (" + year + " - " + title + ")";
    }
}