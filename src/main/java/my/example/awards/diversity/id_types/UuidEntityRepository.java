package my.example.awards.diversity.id_types;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UuidEntityRepository extends JpaRepository<UuidEntity, UUID> {

    Optional<UuidEntity> findById(UUID id);

    @Query("select e from UuidEntity e where e.id=?1")
    Optional<UuidEntity> findByUuidHql(UUID id);
}