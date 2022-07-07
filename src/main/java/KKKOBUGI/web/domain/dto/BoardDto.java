package KKKOBUGI.web.domain.dto;

import KKKOBUGI.web.domain.entity.Board;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class BoardDto {
    private Long id;
    private String nickname;
    private String title;
    private String content;
    private LocalDateTime createDate;

    public BoardDto() {
    }
    public Board toEntity() {
        return Board.builder()
                .nickname(nickname)
                .title(title)
                .content(content)
                .build();
    }
    @Builder // 빌더 패턴 적용
    public BoardDto(Long id, String nickname, String title, String content,LocalDateTime createDate ) {
        this.id = id;
        this.nickname = nickname;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
    }
//    public BoardDto(Board board) {
//        this.nickname = board.getNickname();
//        this.title = board.getTitle();
//        this.content = board.getContent();
//    }
}
