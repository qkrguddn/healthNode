package KKKOBUGI.healthNote.repository;

import KKKOBUGI.healthNote.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
