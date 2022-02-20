package hello.boardspring.service;

import hello.boardspring.domain.Board;
import hello.boardspring.repository.BoardRepository;
import hello.boardspring.repository.JpaBoardRepository;
import hello.boardspring.repository.RealBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//이 때, boardSerivce 클래스에 @Service라는 어노테이션이ㅣ 있어야 함.
//자동 컴포넌트 방식// @Service//이게 있어야 스프링이 얘를 찾아서 연결시켜줄 수 있음. 없으면 못 찾음
@Transactional
public class BoardService {
    
    //일단 회원 서비스를 만들려면 현재 저장소에 어떤 board가 있는지 현황?을 알아야 하니까
    //리포지토리를 당연히 가져와야 함
    //private final RealBoardRepository realBoardRepository=new RealBoardRepository();
    
    //!!!! 보드 서비스코드에서 만든 보드 리포지토리 객체와 보드 서비스 테스트 코드에서 만든 보드 리포지토리 객체가 같아야
    // 혹시나 생길 문제를 예방할 수 있다(물론 지금은 리포지토리의 store가 static이라서 각 객체마다 모두 동일하겠지만,
    //static이 아니라면 외부(ex.테스트)에서 쓰는 리포지토리 객체와 서비스가 사용하는 리포지토리가
    // 서로 다른 객체로 생성이 되어서 문제가 될 수도 있다)
    //그래서 원래는 13번 라인처럼 리포지토리를 사용했는데, 이제는 생성자에서 주입을 활용한다
    private final BoardRepository boardRepository;
    
    //자동 컴포넌트 방식
    //Autowired가 있으면 그 때, 스프링이 파라미터에 있는 realRepository를 찾아서 연결시켜줌
    //마찬가지로 리포지토리 클래스에도 @Repository라는 어노테이션이 있어야 스프링이 리포지토리로 찾아낼 수 있음
    //해당 리포지토리 클래스에 @Repository 이게 있어야 스프링이 얘를 찾아서 연결시켜줄 수 있음. 없으면 못 찾음
    //@Autowired
    public BoardService(BoardRepository boardRepository){ //외부?에서 자기가 쓸 리포지토리를 서비스의 생성자의 파라미터로 주입하면
        //보드 서비스의 리포지토리는 그 외부(ex. 테스트코드)가 사용하는 리포지토리와 동일한 리포지토리를 갖게 된다(쓴다)
        this.boardRepository=boardRepository;
    }
    
    /*
    보드 등록
    * */
    public Long register(Board board){
//        System.out.println("boardRepository"+boardRepository);
        boardRepository.save(board); //일단 해당 보드를 리포지토리에 저장
        return board.getIdx();
    }
    
    
    /* 전체 보드 조회
    * */
    public List<Board> getAllBoard(){
        //그냥 현재 리포지토리 전체를 가져오면 됨
        return boardRepository.findAll();
    }
    
    /*
    * 하나의 보드만 조회하기*/
    public Optional<Board> getOneBoard(Long boardIdx){
        return boardRepository.findByIdx(boardIdx);
    }
}
