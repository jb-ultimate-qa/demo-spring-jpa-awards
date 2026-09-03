package my.example.awards.diversity.precision.bean;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import my.example.awards.diversity.precision.TimestampDefaultPrecisionEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class TimestampService {
    @PersistenceContext
    private EntityManager entityManager;
    private final TimestampDefaultPrecisionEntityRepository repo;

    TimestampService(TimestampDefaultPrecisionEntityRepository repo) {
        this.repo = repo;
    }

    @Transactional(readOnly = true)
    public void checkHqlSyntax() {
        var result1 = entityManager.createQuery(
                        "select t from TimestampDefaultPrecisionEntity t where t.sqlDate = {1970-07-17}",
                        TimestampDefaultPrecisionEntity.class)
                .getResultList();

        System.out.println(result1);

        var result2 = entityManager.createQuery(
                        "select t from TimestampDefaultPrecisionEntity t where t.sqlTime = {02:26:06}",
                        TimestampDefaultPrecisionEntity.class)
                .getResultList();

        var result3 = entityManager.createQuery(
                        "select t from TimestampDefaultPrecisionEntity t where t.javaDate > {2000-10-20 20:00:00}",
                        TimestampDefaultPrecisionEntity.class)
                .getResultList();

        var result4 = entityManager.createQuery(
                        "select t from TimestampDefaultPrecisionEntity t where t.localDateTime > {2000-10-20 20:00:00.456789123}",
                        TimestampDefaultPrecisionEntity.class)
                .getResultList();

        var result5 = entityManager.createQuery(
                        "select t from TimestampDefaultPrecisionEntity t where t.offsetDateTime > {2000-10-20 20:00:00 +00:00}",
                        TimestampDefaultPrecisionEntity.class)
                .getResultList();

        var result6 = entityManager.createQuery(
                        "select t from TimestampDefaultPrecisionEntity t where t.zonedDateTime > {2000-10-20 20:00:00 GMT}",
                        TimestampDefaultPrecisionEntity.class)
                .getResultList();

    }




    public void createTestData() {
        repo.saveAll(List.of(
                createEntity(1L, ZonedDateTime.of(1970, 7, 17, 7, 17, 17, 123_456_789, ZoneOffset.UTC)),
                createEntity(2L, ZonedDateTime.of(1999, 9, 19, 9, 19, 19, 987_654_321, ZoneOffset.UTC)),
                createEntity(3L, ZonedDateTime.of(2000, 10, 20, 20, 0, 0, 456_789_123, ZoneOffset.UTC)),
                createEntity(4L, ZonedDateTime.of(2026, 2, 6, 2, 26, 6, 789_123_456, ZoneOffset.UTC))
        ));
    }

    private TimestampDefaultPrecisionEntity createEntity(
            Long id,
            ZonedDateTime value
    ) {
        LocalDate localDate = value.toLocalDate();
        LocalTime localTime = value.toLocalTime();
        LocalDateTime localDateTime = value.toLocalDateTime();
        OffsetDateTime offsetDateTime = value.toOffsetDateTime();
        Instant instant = value.toInstant();

        TimestampDefaultPrecisionEntity entity =
                new TimestampDefaultPrecisionEntity();

        entity.setId(id);

        // Date only
        entity.setSqlDate(java.sql.Date.valueOf(localDate));
        entity.setLocalDate(localDate);

        // Time only
        entity.setSqlTime(java.sql.Time.valueOf(localTime));
        entity.setLocalTime(localTime);
        entity.setOffsetTime(offsetDateTime.toOffsetTime());

        // Date and time
        entity.setJavaDate(java.util.Date.from(instant));
        entity.setSqlTimestamp(java.sql.Timestamp.from(instant));
        entity.setDtInstant(instant);
        entity.setLocalDateTime(localDateTime);
        entity.setOffsetDateTime(offsetDateTime);
        entity.setZonedDateTime(value);

        return entity;
    }
}
