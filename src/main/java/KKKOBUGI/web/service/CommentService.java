package KKKOBUGI.web.service;

import KKKOBUGI.web.domain.dto.BoardDetailDto;
import KKKOBUGI.web.domain.dto.CommentDto;
import KKKOBUGI.web.domain.entity.Board;
import KKKOBUGI.web.domain.entity.Comment;
import KKKOBUGI.web.repository.BoardRepository;
import KKKOBUGI.web.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    BoardRepository boardRepository;
    //댓글 저장, 수정
    public static ArrayList<ArrayList<Comment>> comments = new ArrayList<ArrayList<Comment>>();
    private ArrayList<ArrayList<Comment>> saveComment(CommentDto commentDto, Long id)
    {
        Optional<Board> boardEntityWrapper = boardRepository.findById(id);
        Long boardLongId = boardEntityWrapper.get().getId();


        Comment comment = commentDto.toEntity();
        Comment savedComment = commentRepository.save(comment);
        int boardId = boardLongId.intValue();
        comments.get(boardId).add(comment);
        return comments;
    }

    //댓글 삭제
    private void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    //댓글 리스트 조회, boardService의 댓글페이지와 같이 api전송해야하는 것 같은데 어떻게 해야하는 지 생각할 것
    private BoardDetailDto getCommentList(Long id) {
       Optional<Board> boardEntityWrapper = boardRepository.findById(id);
       Board board = boardEntityWrapper.get();
       Long boardLongId = boardEntityWrapper.get().getId();
       int boardId = boardLongId.intValue();
       ArrayList<Comment> commentList = new ArrayList<>();
       for(Comment comment : comments.get(boardId))
           commentList.add(comment);
        BoardDetailDto boardDetailDto =
                new BoardDetailDto(board.getNickname(),board.getTitle(),board.getContent(),commentList);
        return boardDetailDto;
    }
}

//등록, 수정, 삭제, 모든 댓글 리스트 조회