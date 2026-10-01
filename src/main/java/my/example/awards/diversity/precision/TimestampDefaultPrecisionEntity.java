package my.example.awards.diversity.precision;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;

@Entity
@Table(name = "precision_time_def")
@NamedQueries({
        @NamedQuery(name = "Time_test1", query = "select t from TimestampDefaultPrecisionEntity t where sqlDate=:date"),    // ok
        @NamedQuery(name = "Time_test2", query = "select t from TimestampDefaultPrecisionEntity t where localDate=:date"),  // ok
        @NamedQuery(name = "Time_test3", query = "select t from TimestampDefaultPrecisionEntity t where sqlTime=:time"),    // ok
        @NamedQuery(name = "Time_test4", query = "select t from TimestampDefaultPrecisionEntity t where localTime=:time"),  // ok
        @NamedQuery(name = "Time_test5", query = "select t from TimestampDefaultPrecisionEntity t where offsetTime=:time"), // doesn't work, org.hibernate.query.QueryArgumentException: Argument to query parameter has an incompatible type (java.lang.String is not assignable to java.time.OffsetTime)
        @NamedQuery(name = "Time_test6", query = "select t from TimestampDefaultPrecisionEntity t where javaDate>:timestamp"),     // works with 1970-07-17T08:17:17, doesn't work with 1970-07-17 08:17:17 java.time.format.DateTimeParseException: Text '1970-07-17 08:17:17.123000' could not be parsed, unparsed text found at index 10
        @NamedQuery(name = "Time_test7", query = "select t from TimestampDefaultPrecisionEntity t where sqlTimestamp>:timestamp"), // the same
        @NamedQuery(name = "Time_test8", query = "select t from TimestampDefaultPrecisionEntity t where dtInstant>:timestamp"),      // works with 1970-07-17T08:17:17Z
        @NamedQuery(name = "Time_test9", query = "select t from TimestampDefaultPrecisionEntity t where localDateTime>:timestamp"),  // works with 1970-07-17T08:17:17Z
        @NamedQuery(name = "Time_test10", query = "select t from TimestampDefaultPrecisionEntity t where offsetDateTime>:timestamp"),// works with 1970-07-17T08:17:17+01 or 1970-07-17T08:17:17+01:00
        @NamedQuery(name = "Time_test11", query = "select t from TimestampDefaultPrecisionEntity t where zonedDateTime>:timestamp"), // works with 1970-07-17T08:17:17+01 or 1970-07-17T08:17:17+01:00
})
public class TimestampDefaultPrecisionEntity {
    @Id
    @Column(nullable = false)
    private Long id;

    // Date only
    @Column
    private java.sql.Date sqlDate;           // extends java.util.Date BUT USES DATE ONLY. [Outdated]
    @Column
    private java.time.LocalDate localDate;   // Date only w/o time-zone

    // Time Only
    @Column
    private java.sql.Time sqlTime;            // extends java.util.Date BUT USES TIME ONLY with seconds precision. [Outdated]
    @Column
    private java.time.LocalTime localTime;    // Time only with nanosecond precision w/o time-zone.
    @Column
    private java.time.OffsetTime offsetTime;  // Time only with nanosecond precision + offset from UTC/Greenwich

    // Timestamps
    @Column
    private java.util.Date javaDate;                // Date and Time with millisecond precision. [Outdated]
    @Column
    private java.sql.Timestamp sqlTimestamp;        // = java.util.Date + nanoseconds. [Outdated]
    @Column
    private java.time.Instant dtInstant;            // Date and Time with nanosecond precision w/o time-zone
    @Column
    private java.time.LocalDateTime localDateTime;  // Date and Time with nanosecond precision w/o time-zone
    @Column
    private java.time.OffsetDateTime offsetDateTime;// Date and Time with nanosecond precision + offset from UTC/Greenwich
    @Column
    private java.time.ZonedDateTime zonedDateTime;  // Date and Time with nanosecond precision + full time-zone


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSqlDate() {
        return sqlDate;
    }

    public void setSqlDate(Date sqlDate) {
        this.sqlDate = sqlDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Time getSqlTime() {
        return sqlTime;
    }

    public void setSqlTime(Time sqlTime) {
        this.sqlTime = sqlTime;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public OffsetTime getOffsetTime() {
        return offsetTime;
    }

    public void setOffsetTime(OffsetTime offsetTime) {
        this.offsetTime = offsetTime;
    }

    public java.util.Date getJavaDate() {
        return javaDate;
    }

    public void setJavaDate(java.util.Date javaDate) {
        this.javaDate = javaDate;
    }

    public Timestamp getSqlTimestamp() {
        return sqlTimestamp;
    }

    public void setSqlTimestamp(Timestamp sqlTimestamp) {
        this.sqlTimestamp = sqlTimestamp;
    }

    public Instant getDtInstant() {
        return dtInstant;
    }

    public void setDtInstant(Instant dtInstant) {
        this.dtInstant = dtInstant;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public OffsetDateTime getOffsetDateTime() {
        return offsetDateTime;
    }

    public void setOffsetDateTime(OffsetDateTime offsetDateTime) {
        this.offsetDateTime = offsetDateTime;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

}
