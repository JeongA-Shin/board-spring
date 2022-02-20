package hello.boardspring;


import hello.boardspring.domain.Board;
import hello.boardspring.repository.BoardRepository;
import hello.boardspring.repository.RealBoardRepository;
import hello.boardspring.service.BoardService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//스프링이 처음 뜰 때, @Configuration 인 걸 읽고 이 내용들을 스프링 빈에 등록한다
@Configuration
public class springConfig {
    
    @Bean //얘를 스프링 빈으로 등록할 것이라는 의미
    public BoardService boardService(){
        return new BoardService(realBoardRepository()); //스프링 빈으로 등록된 realBoardRepository를 넣음
    }
    
    @Bean
    public RealBoardRepository realBoardRepository(){
       return new RealBoardRepository();
    }
}

//그럼 이제 스프링이 뜰 때, BoardService와 RealBoardRepository를 둘 다 스프링 빈으로 등록함
