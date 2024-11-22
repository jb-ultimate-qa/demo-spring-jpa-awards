package my.example.awards.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "player")
public class Player extends Person {
    @Column(name = "rating")
    private Integer rating;

    @OneToMany(mappedBy = "winner", orphanRemoval = true)
    private Set<Award> awards = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "player_sport_school",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "sport_school_id"))
    private Set<SportSchool> sportSchools = new LinkedHashSet<>();

}