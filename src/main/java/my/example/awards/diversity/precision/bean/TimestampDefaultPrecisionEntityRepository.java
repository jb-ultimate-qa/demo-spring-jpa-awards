package my.example.awards.diversity.precision.bean;

import my.example.awards.diversity.precision.TimestampDefaultPrecisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimestampDefaultPrecisionEntityRepository extends JpaRepository<TimestampDefaultPrecisionEntity, Long> {
    // Date only
//    @Query("select t from TimestampDefaultPrecisionEntity t where t.sqlDate = {1970-07-17}")
//    List<TimestampDefaultPrecisionEntity> findBySqlDate();    //[Outdated]

    @Query("select t from TimestampDefaultPrecisionEntity t where t.localDate = date 1970-07-17") // ok in Console
    List<TimestampDefaultPrecisionEntity> findByLocalDate();

    @Query("select t from TimestampDefaultPrecisionEntity t where t.localDate = {d '1970-07-17'}") // ok in Console
    List<TimestampDefaultPrecisionEntity> findByLocalDateJ();

    // Time Only
//    @Query("select t from TimestampDefaultPrecisionEntity t where t.sqlTime = {02:26:06}")
//    List<TimestampDefaultPrecisionEntity> findBySqlTime();    //[Outdated]

    @Query("select t from TimestampDefaultPrecisionEntity t where t.localTime = {t '02:26:06'}") // todo JPQL doesn't work
//    @Query("select t from TimestampDefaultPrecisionEntity t where t.localTime = {t '02:26:06'}")
//    @Query("select t from TimestampDefaultPrecisionEntity t where t.localTime = time 02:26:06.789123456")
    List<TimestampDefaultPrecisionEntity> findByLocalTime();

//    // with offset
//    @Query("select t from TimestampDefaultPrecisionEntity t where t.offsetTime = time 02:26:06+02:00")
//    @Query("select t from TimestampDefaultPrecisionEntity t where t.offsetTime = {t '02:26:06+02:00'}")
//    List<TimestampDefaultPrecisionEntity> findByOffsetTime();  // not supported


    // Timestamps
//    @Query("select t from TimestampDefaultPrecisionEntity t where t.javaDate = {2000-10-20 20:00:00}")
//    List<TimestampDefaultPrecisionEntity> findByDate();    //[Outdated]

    @Query("select t from TimestampDefaultPrecisionEntity t where t.sqlTimestamp > datetime 2000-10-20 20:00:00")
    List<TimestampDefaultPrecisionEntity> findByTimestamp();    //[Outdated]

    @Query("select t from TimestampDefaultPrecisionEntity t where t.dtInstant < {ts '2000-10-20 20:00:00 +00:00'}")
    List<TimestampDefaultPrecisionEntity> findByInstant();

//    @Query("select t from TimestampDefaultPrecisionEntity t where t.localDateTime > datetime 2000-10-20 20:00:00.456789123") // ok
    @Query("select t from TimestampDefaultPrecisionEntity t where t.localDateTime > datetime 2000-10-20 20:00:00.456789") // ok
    List<TimestampDefaultPrecisionEntity> findByLocalDateTime();

    // with offset
//    @Query("select t from TimestampDefaultPrecisionEntity t where t.offsetDateTime = {2000-10-20 20:00:00 +00:00}")
//    List<TimestampDefaultPrecisionEntity> findByOffsetDateTime();

    // with timezone
//    @Query("select t from TimestampDefaultPrecisionEntity t where t.zonedDateTime = {2000-10-20 20:00:00 GMT}")
//    List<TimestampDefaultPrecisionEntity> findByZonedDateTime();

}