package hello.boardspring.service;

import hello.boardspring.domain.Board;
import hello.boardspring.repository.RealBoardRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BoardServiceTest {
    
    //보드 서비스를 테스트하는 거니까 당연히 멤버 서비스를 일단 생성함
    BoardService boardService;
    //!!!! 보드 서비스코드에서 내부적으로 사용하는? 보드 리포지토리 객체와 보드 서비스 테스트 코드에서 만든 보드 리포지토리 객체가 같아야
    // 혹시나 생길 문제를 예방할 수 있다(물론 지금은 리포지토리의 store가 static이라서 각 객체마다 모두 동일하겠지만,
    //static이 아니라면 리포지토리를 만들때마다 서로 다른 객체로 생성이 되어서 문제가 될 수도 있다)
    //따라서 MemberService 에서 주입을 사용한 것이다.
    RealBoardRepository realBoardRepository;
    
    @BeforeEach //테스트 각각의 함수가 실행되기 전에
    public void beforeEach(){
        this.realBoardRepository= new RealBoardRepository(); //즉 테스트코드에서 쓸 리포지토리를 생성한 후
        this.boardService=new BoardService(realBoardRepository); //테스트 코드의 리포지토리를 서비스로 주입해주면, 결국
        //이 서비스는 테스트 코드가 쓰는 리포지토리와 동일한 리포지토리를 사용하게 된다(가지게 된다).
    }
    
    @Test
    public void register() {
        Board board=new Board();
        board.setTitle("hihi");
        
        Long saveIdx=boardService.register(board);
        
        Board findBoard=boardService.getOneBoard(saveIdx).get();
        assertThat(board.getTitle()).isEqualTo(findBoard.getTitle());
        
    }
    
    @Test
    public void getAllBoard(){
    
    
    }
    
    @Test()
    public void getOneBoard(Long boardIdx){
    
    }
}
