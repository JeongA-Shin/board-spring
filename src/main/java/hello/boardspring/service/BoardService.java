package hello.boardspring.service;

import hello.boardspring.domain.Board;
import hello.boardspring.repository.RealBoardRepository;

import java.util.List;
import java.util.Optional;

public class BoardService {
    
    //일단 회원 서비스를 만들려면 현재 저장소에 어떤 board가 있는지 현황?을 알아야 하니까
    //리포지토리를 당연히 가져와야 함
    private final RealBoardRepository realBoardRepository=new RealBoardRepository();
    
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
