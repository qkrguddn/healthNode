package KKKOBUGI.web.domain.dto;

import KKKOBUGI.web.domain.entity.Board;
import lombok.*;

@Data
public class BoardDto {

    private String nickname;
    private String title;
    private String content;

    public BoardDto(Board board) {
        this.nickname = board.getNickname();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
    public BoardDto() {
    }
    public Board toEntity() {
        return Board.builder()
                .id(null)
                .nickname(nickname)
                .title(title)
                .content(content)
                .build();
    }
    @Builder // 빌더 패턴 적용
    public BoardDto( String nickname, String title, String content) {
        this.nickname = nickname;
        this.title = title;
        this.content = content;
    }
}
