package hello.boardspring;

import hello.boardspring.domain.Board;
import hello.boardspring.repository.BoardRepository;
import hello.boardspring.repository.JpaBoardRepository;
import hello.boardspring.repository.RealBoardRepository;
import hello.boardspring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;


//스프링이 처음 뜰 때, @Configuration 인 걸 읽고 이 내용들을 스프링 빈에 등록한다
@Configuration
public class springConfig {
    
    private final EntityManager em; //외부와 동일한 em을 쓰기 위해 em을 주입하도록 함
    
    @Autowired
    public springConfig(EntityManager em){
        this.em=em;
    }
    
    
    @Bean //얘를 스프링 빈으로 등록할 것이라는 의미
    public BoardService boardService(){
        //return new BoardService(realBoardRepository()); //스프링 빈으로 등록된 realBoardRepository를 넣음
        return new BoardService(boardRepository()); //스프링 빈으로 등록된 realBoardRepository를 넣음
    
    }
    
//    @Bean
//    public RealBoardRepository realBoardRepository(){
//       return new RealBoardRepository();
//    }
    
    @Bean
    public BoardRepository boardRepository(){
        return new JpaBoardRepository(em);
    }
}

//그럼 이제 스프링이 뜰 때, BoardService와 BoardRepository를 둘 다 스프링 빈으로 등록함
