package KKKOBUGI.web.controller;

import KKKOBUGI.web.domain.dto.BoardDetailDto;
import KKKOBUGI.web.domain.dto.BoardDto;
import KKKOBUGI.web.domain.dto.CommentDto;
import KKKOBUGI.web.domain.entity.Board;
import KKKOBUGI.web.domain.entity.Comment;
import KKKOBUGI.web.repository.BoardRepository;
import KKKOBUGI.web.repository.CommentRepository;
import KKKOBUGI.web.service.BoardService;
import KKKOBUGI.web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    //댓글 저장
    @PostMapping("home/board/{id}")
    public CommentDto saveComent(@PathVariable Long id, @RequestBody CommentDto commentDto) {
        CommentDto savedComment = commentService.saveComment(id, commentDto);
        return savedComment;
    }

    //댓글 삭제
    @DeleteMapping("home/board/{id}/{number}")
    public void deleteComment(@PathVariable Long number) {
        commentService.deleteComment(number);
    }

    //세부사항 게시물 페이지(게시물 제목, 내용, 댓글목록) 조회
    @GetMapping("home/board/{id}")
    public BoardDetailDto getBoardCommenPage(@PathVariable Long id) {
        return commentService.getBoardDetail(id);
    }
//    @PatchMapping("web/board/{id}/{number}")
//    public CommentDto updateComment(@PathVariable Long id, @PathVariable Long number, @RequestBody CommentDto commentDto){
//        CommentDto savedComment = commentService.updateComment(number, commentDto);
//        return savedComment;
//    }
}
/*
@Controller(Rest -x)
    @GetMapping("test")
    public String test() {
        Board board = new Board("guddn","health","good");
        Board savedEntity = boardRepository.save(board);
        BoardDto boardDto = boardService.getOneBoard(savedEntity.getId());
        System.out.println(boardDto.toString());
        return "write";
    }
    //api 통신할 때는 @RequestBody 추가할 것.
    @PostMapping("test")
    public String post(CommentDto commentDto ) {
        Comment comment = commentDto.toEntity();
        Comment savedComment = commentRepository.save(comment);
        System.out.println("time: "+ savedComment.getCreateDate());
        commentDto.setCreateDate(savedComment.getCreateDate());
        System.out.println("dto" +commentDto.toString());
        return "write";
    }*/
