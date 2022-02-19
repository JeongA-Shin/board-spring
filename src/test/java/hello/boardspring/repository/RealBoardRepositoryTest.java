package hello.boardspring.repository;

import hello.boardspring.domain.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class RealBoardRepositoryTest {
    
    RealBoardRepository repository=new RealBoardRepository();
    
    @AfterEach //테스트 함수 각각이 끝날 때마다 실행됨
    public void afterEach(){
        repository.clearStore();
    }
    
    
    @Test //@Test가 선언된 메서드는 테스트를 수행하는 메소드가 된다.
    public void save(){
        Board board=new Board();
        board.setTitle("spring");
        
        repository.save(board); //얘가 테스트되는 함수임
        //여기서 정상 동작 되어야 함
        
        Board result= repository.findByIdx(board.getIdx()).get();
        //optional값은 get함수로 가져 와야 함
        
        //검증 (result가 내가 처음에 생성한 board와 동일한가)
        //System.out.println("result="+(result ==board));
        Assertions.assertEquals(board,result); // assertEquals(x, y), x(예상 값)와 y(실제 값)
    }
    
    @Test
    public void findByTitle(){
        //테스트 전 작업(전제조건)
        Board board1=new Board();
        board1.setTitle("board1");
        repository.save(board1);
    
        Board board2=new Board();
        board2.setTitle("board2");
        repository.save(board2);
        
        //테스트하고 싶은 함수 구동
         Board result = repository.findByTitle("board1").get();
        Assertions.assertEquals(board1,result); // assertEquals(x, y), x(예상 값)와 y(실제 값)
    
        Board result2 = repository.findByTitle("board2").get();
        Assertions.assertEquals(board2,result2); // assertEquals(x, y), x(예상 값)와 y(실제 값)
        
    
    }
    
    @Test
    public void findAll() {
        //given 전제조건
        Board board1 = new Board();
        board1.setTitle("spring1");
        repository.save(board1);
        
        Board board2 = new Board();
        board2.setTitle("spring2");
        repository.save(board2);
        //when
        List<Board> result = repository.findAll(); //테스트하는 함수
        
        //then //검증
        Assertions.assertEquals(result.size(),2); // assertEquals(x, y), x(예상 값)와 y(실제 값)
    }
    
    
}
