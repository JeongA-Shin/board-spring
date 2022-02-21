package hello.boardspring.service;

import hello.boardspring.domain.Board;
import hello.boardspring.domain.MyBoard;
import hello.boardspring.repository.BoardRepository;
import hello.boardspring.repository.JpaBoardRepository;
import hello.boardspring.repository.MyBoardRepository;
import hello.boardspring.repository.RealBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//이 때, boardSerivce 클래스에 @Service라는 어노테이션이ㅣ 있어야 함.
//자동 컴포넌트 방식// @Service//이게 있어야 스프링이 얘를 찾아서 연결시켜줄 수 있음. 없으면 못 찾음
@Transactional
public class MyBoardService {
    //서비스는 리포지토리의 기능을 이용해 로직을 짠다
    
    private final MyBoardRepository myBoardRepository;
    
    public MyBoardService(MyBoardRepository myBoardRepository) { //외부?에서 자기가 쓸 리포지토리를 서비스의 생성자의 파라미터로 주입하면
        //보드 서비스의 리포지토리는 그 외부(ex. 테스트코드)가 사용하는 리포지토리와 동일한 리포지토리를 갖게 된다(쓴다)
        this.myBoardRepository = myBoardRepository;
    }
    
    //페이지네이션 기능
    //Page<객체>
    //Pageable 페이징을 제공하는 인터페이스
    //PageRequest 객체는 Pageable 인터페이스를 상속받는다.
    //쉽게 Paging 을 위한 정보를 넘길 수 있는데, 이 정보에는 정렬 정보, 페이지 offset, page와 같은 정보가 담겨있다.
    public Page<MyBoard> findBoardList(Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber()<1?0:pageable.getPageNumber()-1,pageable.getPageSize());
        //PageRequest의 생성에는 찾을 page와 한 페이지의 size를 필수 인자로 받는다.
        //정렬해서 paging을 하는 경우에, Sort를 생성자 인자로 추가해서 PageRequest를 생성할 수 있다.
        
        //pageable로 넘어온 pageNumber 객체가 0 이하일 때 0으로 초기화한다.
        // 기본 페이지 크기인 10으로 새로운 PageRequest 객체를 만들어 페이징 처리된 게시글 리스트를 반환한다.
        
        return myBoardRepository.findAll(pageable);
        //페이지네이션: repository의 findAll 메서드의 parameter에 Pageable 또는 Pageable의 구현체인 PageRequest를 넣어주면 된다.
    }
    
    public MyBoard findBoardByIdx(Long idx){
        return myBoardRepository.findById(idx).orElse(new MyBoard(idx,"없음","없습니다"));
    }
    
    
}