package KKKOBUGI.healthNote.repository;

import KKKOBUGI.healthNote.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
