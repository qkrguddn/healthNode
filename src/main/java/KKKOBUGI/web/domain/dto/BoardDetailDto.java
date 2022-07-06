package KKKOBUGI.web.domain.dto;

import KKKOBUGI.web.domain.entity.Comment;

import java.util.ArrayList;

public class BoardDetailDto {
    private  ArrayList<Comment> comment;
    private String boardNickname;
    private String boardTitle;
    private String boardContent;

    public BoardDetailDto(String boardNickname, String boardTitle, String boardContent, ArrayList<Comment> comment) {
        this.boardNickname = boardNickname;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.comment = comment;
    }
}
