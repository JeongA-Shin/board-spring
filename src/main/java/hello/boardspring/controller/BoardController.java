package hello.boardspring.controller;

import hello.boardspring.domain.Board;
import hello.boardspring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {
    
    //이제 얘가 보드 서비스의 로직을 불러와야 함
    //즉 url 요청을 받았을 떄 그에 상응하는 로직을 구현하는 거임
    //보드 서비스의 기능?들로 그 로직을 구성하므로 우선 보드 서비스를 불러옴
    private final BoardService boardService;
    
    //만약 여러 컨트롤러가 있었다고 가정해보자. (ex, 등록 컨트롤러, 결제 컨트롤러 등..) 그런데 얘네들은
    //또 모두 공유하는? 동일한 서비스 객체에 대해 동작해야 한다.(당연... 컨트롤러가 호출될 때마다 새로운
    //서비스 객체가 생기면 안 된다. 서비스는 static 변수처럶 단 하나만 스프링에 등록되어야 한다)
    
    // 즉 스프링 컨테이너에 하나의 서비스 객체만 등록되어야 한다
    
    //그러면 모든 컨트롤러에 대해 어떻게 동일한 보드 서비스를 쓰이게 할 것인가?
    //== 그러면 모든 컨트롤러에 대해 어떻게 동일한 보드 서비스를 주입할 것인가?
    //생성자로 해결한다.(생성자를 통해 DI. dependency injection)
    
    //!!!! 스프링 컨테이너가 뜰 때, 컨트롤러를 생성하므로 그 때 컨트롤러 생성자를 호출한다
    //Autowired가 있으면 그 때, 스프링이 파라미터에 있는 boardService를 찾아서 연결시켜줌
    //이 때, 컴포넌트 자동 스캔 방식을 이용한다면 boardSerivce 클래스에 @Service라는 어노테이션이ㅣ 있어야 함.
    //이게 있어야 스프링이 얘를 찾아서 연결시켜줄 수 있음. 없으면 못 찾음
    //마찬가지로  컴포넌트 자동 스캔 방식을 이용한다면 리포지토리 클래스에도 @Repository라는 어노테이션이 있어야 스프링이 리포지토리로 찾아낼 수 있음
    @Autowired
    public BoardController(BoardService boardService){
        this.boardService=boardService;
    }
    
    
    @GetMapping("/board/new")
    public String createForm(){
        return "boards/createBoardForm";
    }
    
    @PostMapping("/board/new")
    public String create(BoardForm boardForm){//사용자가 쓴 폼이 파라미터로 넘어옴
        Board board=new Board(); //그러면 이 폼에 대한 새로운 객체를 하나 만들고
        board.setTitle(boardForm.getTitle()); //제목을 set
        
        System.out.println("board title: "+ board.getTitle());//확인됨
        System.out.println("board idx: "+ board.getIdx());//왜 null이 나올까
        
        boardService.register(board); //그리고 리포지토리에 등록 -(서비스의 register 함수가 리포지토리에 등록하는 함수임)
        
        return "redirect:/"; //끝나면 홈 화면으로 보냄
    }
    
    @GetMapping("/boards")
    public String list(Model model){ //파라미터의ㅣ model은 스프링이 자동으로 넘겨줌
        List<Board> boards=boardService.getAllBoard();
        model.addAttribute("boards",boards); // 뷰에 넘겨주는 모델 내용
        return "boards/boardList";
    }
    
    
}