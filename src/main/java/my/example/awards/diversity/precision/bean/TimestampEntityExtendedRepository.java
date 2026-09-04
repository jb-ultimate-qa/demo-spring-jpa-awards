package my.example.awards.diversity.precision.bean;

import my.example.awards.diversity.precision.TimestampDefaultPrecisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimestampEntityExtendedRepository extends JpaRepository<TimestampDefaultPrecisionEntity, Long> {
    // Date only
    @Query("""
            select extract(DAY from t.localDate),
                   extract(MONTH from t.localDate),
                   extract(month from t.localDate),
                   extract(year from t.localDate),
                   extract(week from t.localDate),
                   extract(quarter from t.localDate) from TimestampDefaultPrecisionEntity t""")
    List<TimestampDefaultPrecisionEntity> findByLocalDate();

    // Time Only
    @Query("""
           select extract(hour from t.localTime),
                  extract(minute from t.localTime),
                  extract(second from t.localTime),
                  extract(nanosecond from t.localTime),
                  extract(epoch from t.localTime) from TimestampDefaultPrecisionEntity t""")
    List<TimestampDefaultPrecisionEntity> findByLocalTime();

    // Timestamps
    @Query("""
           select extract(date from t.localDateTime),
                  extract(time from t.localDateTime),
                  extract(day of week from t.localDateTime),
                  extract(day of month from t.localDateTime),
                  extract(day of year from t.localDateTime),
                  extract(week of month from t.localDateTime),
                  extract(week of year from t.localDateTime) from TimestampDefaultPrecisionEntity t""")
    List<TimestampDefaultPrecisionEntity> findByLocalDateTime();

    // with offset
    @Query("""
           select extract(offset from t.offsetDateTime),
                  extract(offset hour from t.offsetDateTime),
                  extract(offset minute from t.offsetDateTime) from TimestampDefaultPrecisionEntity t""")
    List<TimestampDefaultPrecisionEntity> findByOffsetDateTime();

}