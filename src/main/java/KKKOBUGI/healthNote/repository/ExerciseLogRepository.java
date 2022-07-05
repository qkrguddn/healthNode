package KKKOBUGI.healthNote.repository;

import KKKOBUGI.healthNote.domain.entity.ExerciseLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseLogRepository extends JpaRepository<ExerciseLog, Long> {
}
