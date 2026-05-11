package my.example.awards.diversity.precision;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "precision_time_set")
public class TimestampSetPrecisionEntity {
    @Id
    @Column(nullable = false)
    private Long id;

    // Date only
    @Column
    private java.sql.Date sqlDate;           // extends java.util.Date BUT USES DATE ONLY. [Outdated]
    @Column
    private java.time.LocalDate localDate;   // Date only w/o time-zone

    // Time Only
    @Column(precision = 5)
    private java.sql.Time sqlTime;            // extends java.util.Date BUT USES TIME ONLY with seconds precision. [Outdated]
    @Column(precision = 5)
    private java.time.LocalTime localTime;    // Time only with nanosecond precision w/o time-zone.
    @Column(precision = 5)
    private java.time.OffsetTime offsetTime;  // Time only with nanosecond precision + offset from UTC/Greenwich

    // Timestamps
    @Column(precision = 5)
    private java.util.Date javaDate;                // Date and Time with millisecond precision. [Outdated]
    @Column(precision = 5)
    private java.sql.Timestamp sqlTimestamp;        // = java.util.Date + nanoseconds. [Outdated]
    @Column(precision = 5)
    private java.time.Instant dtInstant;            // Date and Time with nanosecond precision w/o time-zone
    @Column(precision = 5)
    private java.time.LocalDateTime localDateTime;  // Date and Time with nanosecond precision w/o time-zone
    @Column(precision = 5)
    private java.time.OffsetDateTime offsetDateTime;// Date and Time with nanosecond precision + offset from UTC/Greenwich
    @Column(precision = 5)
    private java.time.ZonedDateTime zonedDateTime;  // Date and Time with nanosecond precision + full time-zone
}
