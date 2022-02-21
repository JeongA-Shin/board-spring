package hello.boardspring.controller;


import hello.boardspring.domain.MyBoard;
import hello.boardspring.repository.MyBoardRepository;
import hello.boardspring.service.BoardService;
import hello.boardspring.service.MyBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/myboard")
public class MyBoardController {
    
    private final  MyBoardService myBoardService;
    private MyBoardRepository myBoardRepository;
    
    @Autowired
    public MyBoardController(MyBoardService myBoardService){
        this.myBoardService=myBoardService;
    }
    
    /**
     * 게시글 목록
     */
    @GetMapping("/list") //@PageableDefault 어노테이션을 선언해 주고 page에 대한 설정을 할 수 있다.
    public String list(@PageableDefault Pageable pageable, Model model){
        model.addAttribute("boardList",myBoardService.findBoardList(pageable));
        //컨트롤러에서 뷰에 어떤 정보등을 넘겨줘야 하면 반드시 model에 담아서 줘야 한다
        return "/myboard/list";
    }
    
    /*
     * 게시글 상세 및 등록 폼 호출
     */
    @GetMapping({"", "/"})
    public String board(@RequestParam(value = "idx", defaultValue = "0") Long idx, Model model) {
        model.addAttribute("board", myBoardService.findBoardByIdx(idx));
        return "/board/form";
    }
    
    /*
     * 게시글 생성
     */
    @PostMapping
    public ResponseEntity<?> postBoard(@RequestBody MyBoard myBoard) {
//        board.setCreatedDate(LocalDateTime.now());
//        board.setUpdatedDate(LocalDateTime.now());
         myBoardRepository.save(myBoard);
        
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }
    
    /*
     * 게시글 수정
     */
    @PutMapping("/{idx}")
    public ResponseEntity<?> putBoard(@PathVariable("idx") Long idx, @RequestBody MyBoard myBoard) {
        MyBoard updateBoard = myBoardRepository.getOne(idx); //해당 객체를 가져오고
        updateBoard.setTitle(myBoard.getTitle());
        updateBoard.setContent(myBoard.getContent());
        //updateBoard.setUpdatedDate(LocalDateTime.now());
        myBoardRepository.save(updateBoard);
        
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
    
    
    /*
            * 게시글 삭제
     */
    @DeleteMapping("/{idx}")
    public ResponseEntity<?> deleteBoard(@PathVariable("idx") Long idx) {
        myBoardRepository.deleteById(idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
    
    
    
}

