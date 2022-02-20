package hello.boardspring.controller;

import hello.boardspring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
    
    
    
    
}
