package my.example.awards.diversity.emb_id;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "emid_composite_inner")
public class CompositeInner {

    @Embeddable
    public record Id(
            @Column(name = "event_id") UUID eventId,
            @Column(name = "user_id") UUID userId,
            @Column(name = "instance_id") UUID instanceId
    ) {}

    @EmbeddedId
    private Id id;

    @Column(name = "event_description", length = 500)
    private String event_description;

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }
}