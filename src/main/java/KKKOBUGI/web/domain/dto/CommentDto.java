package KKKOBUGI.web.domain.dto;


import KKKOBUGI.web.domain.entity.Board;
import KKKOBUGI.web.domain.entity.Comment;
import lombok.Data;
import org.yaml.snakeyaml.tokens.CommentToken;
@Data
public class CommentDto {
    private String nickname;
    private String content;

    public Comment toEntity() {
        return Comment.builder()
                .id(null)
                .nickname(nickname)
                .content(content)
                .build();
    }

    public CommentDto() {
    }
}
