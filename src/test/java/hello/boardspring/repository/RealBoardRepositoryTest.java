package hello.boardspring.repository;

import hello.boardspring.domain.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RealBoardRepositoryTest {
    
    RealBoardRepository repository=new RealBoardRepository();
    
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
}
