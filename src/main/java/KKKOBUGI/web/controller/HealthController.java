package KKKOBUGI.web.controller;

import KKKOBUGI.web.domain.dto.BoardDto;
import KKKOBUGI.web.domain.entity.Board;
import KKKOBUGI.web.repository.BoardRepository;
import KKKOBUGI.web.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HealthController {
    @Autowired BoardService boardService;
    @Autowired
    BoardRepository boardRepository;

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
    public String post( BoardDto boardDto) {
      BoardDto savedDto = boardService.saveBorad(boardDto);
        System.out.println("dto: "+savedDto.toString());
        return "write";
    }
}