package my.example.awards.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Location {
    @Column(name = "city")
    private String city;

    @Column(name = "stadium")
    private String stadium;

}