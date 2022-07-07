package KKKOBUGI.web.controller;

import KKKOBUGI.web.domain.dto.BoardDto;
import KKKOBUGI.web.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    @PostMapping("home/board/write")
    public BoardDto saveBoard(@RequestBody BoardDto boardDto){
       return boardService.saveBorad(boardDto);
    }
    @DeleteMapping("home/board/{id}")
    public void deleteBoard(@PathVariable Long id){
        boardService.deleteBoard(id);
    }
    @GetMapping("home/board")
    public List<BoardDto> getBoardList(){
        return boardService.getBoardList();
    }

}
