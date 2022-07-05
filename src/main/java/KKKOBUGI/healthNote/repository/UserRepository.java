package KKKOBUGI.healthNote.repository;

import KKKOBUGI.healthNote.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
