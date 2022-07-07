package KKKOBUGI.web.service;

import KKKOBUGI.web.domain.dto.BoardDto;
import KKKOBUGI.web.domain.entity.Board;
import KKKOBUGI.web.repository.BoardRepository;
import KKKOBUGI.web.repository.CommentRepository;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ToString
@Service
@Transactional
public class BoardService {
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    CommentRepository commentRepository;

    //게시판 등록
    public BoardDto saveBorad(BoardDto boardDto) {
        Board board = boardDto.toEntity();
       Board savedBoard = boardRepository.save(board);
        boardDto.setCreateDate(savedBoard.getCreateDate());
        boardDto.setId(savedBoard.getId());
        return boardDto;
    }
    //게시판 삭제
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    //게시판 목록에서 하나의 내용조회
    public BoardDto getOneBoard(Long id) {
        Optional<Board> boardEntityWrapper = boardRepository.findById(id);
        Board board = boardEntityWrapper.get();
        return this.convertEntityToDto(board);
    }

    //게시판 목록의 전체 리스트 조회
    public List<BoardDto> getBoardList() {
        List<Board> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();
        for (Board board : boardEntities) {
            boardDtoList.add(convertEntityToDto(board));
        }
        return boardDtoList;
    }

    /*
     * 댓글 페이지 조회, CommentService의 댓글리스트조회와 같이 api전송해야하는 것 같은데 어떻게 해야하는 지 생각할 것
     * comment(n) 대 board(1) 관계이므로 생각하면서 코드짤 것.
     * */
    public BoardDto getCommentPage(Long id) {
        //해당 기능은 comment가 n인 경우 이므로 comment 파트에서 작성하였음.
        return null;
    }

    //entity -> dto 변환 하는 빌더
    private BoardDto convertEntityToDto(Board board) {
        return BoardDto.builder()
                .id(board.getId())
                .nickname(board.getNickname())
                .title(board.getTitle())
                .content(board.getContent())
                .createDate(board.getCreateDate())
                .build();
    }
}
//등록, 삭제, 조회(게시물 각 목록, 모든 게시물 리스트, 댓글페이지)
