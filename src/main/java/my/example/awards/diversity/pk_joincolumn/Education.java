package my.example.awards.diversity.pk_joincolumn;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Education {
    @Id
    @GeneratedValue
    private long id;
    private double averageScore;
    private double averageAttendance;
}
