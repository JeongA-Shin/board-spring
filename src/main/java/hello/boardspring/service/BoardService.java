package hello.boardspring.service;

import hello.boardspring.domain.Board;
import hello.boardspring.repository.RealBoardRepository;

import java.util.List;
import java.util.Optional;

public class BoardService {
    
    //일단 회원 서비스를 만들려면 현재 저장소에 어떤 board가 있는지 현황?을 알아야 하니까
    //리포지토리를 당연히 가져와야 함
    //private final RealBoardRepository realBoardRepository=new RealBoardRepository();
    
    //!!!! 보드 서비스코드에서 만든 보드 리포지토리 객체와 보드 서비스 테스트 코드에서 만든 보드 리포지토리 객체가 같아야
    // 혹시나 생길 문제를 예방할 수 있다(물론 지금은 리포지토리의 store가 static이라서 각 객체마다 모두 동일하겠지만,
    //static이 아니라면 외부(ex.테스트)에서 쓰는 리포지토리 객체와 서비스가 사용하는 리포지토리가
    // 서로 다른 객체로 생성이 되어서 문제가 될 수도 있다)
    //그래서 원래는 13번 라인처럼 리포지토리를 사용했는데, 이제는 생성자에서 주입을 활용한다
    
    private final RealBoardRepository realBoardRepository;
    
    public BoardService(RealBoardRepository realBoardRepository){ //외부?에서 자기가 쓸 리포지토리를 서비스의 생성자의 파라미터로 주입하면
        //보드 서비스의 리포지토리는 그 외부(ex. 테스트코드)가 사용하는 리포지토리와 동일한 리포지토리를 갖게 된다(쓴다)
        this.realBoardRepository=realBoardRepository;
    }
    
    /*
    보드 등록
    * */
    public Long register(Board board){
        realBoardRepository.save(board); //일단 해당 보드를 리포지토리에 저장
        return board.getIdx();
    }
    
    
    /* 전체 보드 조회
    * */
    public List<Board> getAllBoard(){
        //그냥 현재 리포지토리 전체를 가져오면 됨
        return realBoardRepository.findAll();
    }
    
    /*
    * 하나의 보드만 조회하기*/
    public Optional<Board> getOneBoard(Long boardIdx){
        return realBoardRepository.findByIdx(boardIdx);
    }
}
