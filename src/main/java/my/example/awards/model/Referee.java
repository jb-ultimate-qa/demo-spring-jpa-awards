package my.example.awards.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "referee")
public class Referee extends Person {

    @Getter
    @Setter
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "license_id")
    private License license;

    @Override
    public String toString() {
        return "Referee " + getFullName() + " with license number " + license.getLicenseNumber();
    }
}