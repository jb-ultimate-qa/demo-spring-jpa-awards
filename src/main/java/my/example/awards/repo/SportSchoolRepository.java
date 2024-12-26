package my.example.awards.repo;

import my.example.awards.model.SportSchool;
import org.springframework.data.repository.CrudRepository;

public interface SportSchoolRepository extends CrudRepository<SportSchool, String> {
}