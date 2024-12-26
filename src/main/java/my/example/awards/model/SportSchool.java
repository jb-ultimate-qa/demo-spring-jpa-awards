package my.example.awards.model;

import jakarta.persistence.*;

import java.text.DecimalFormat;
import java.util.*;

@Entity
@Table(name = "sport_school")
public class SportSchool {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "title")
    private String title;

    @ElementCollection
    @Column(name = "rating", nullable = false)
    @CollectionTable(name = "sport_school_rating", joinColumns = @JoinColumn(name = "school_id"))
    private List<Integer> ratingSet = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Integer> getRatingSet() {
        return ratingSet;
    }

    public void setRatingSet(List<Integer> ratingSet) {
        this.ratingSet = ratingSet;
    }

    @Transient
    public Double getAverageRating() {
        if (ratingSet.isEmpty()) return 0.0;
        OptionalDouble averageRating = getRatingSet().stream().mapToDouble(Integer::doubleValue).average();
        if (averageRating.isEmpty()) return 0.0;
        return averageRating.getAsDouble();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return getClass().getSimpleName() + " (" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "averageRating = " + df.format(getAverageRating()) + ")";
    }
}