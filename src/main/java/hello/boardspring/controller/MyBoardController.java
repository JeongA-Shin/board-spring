package hello.boardspring.controller;


import hello.boardspring.service.BoardService;
import hello.boardspring.service.MyBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myboard")
public class MyBoardController {
    
    private MyBoardService myBoardService;
    
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
        return "myboard/list";
    }
}

