package hello.boardspring;

//import hello.boardspring.domain.Board;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;



//스프링이 처음 뜰 때, @Configuration 인 걸 읽고 이 내용들을 스프링 빈에 등록한다
//@Configuration
//public class springConfig {
//
//    //private final EntityManager em; //외부와 동일한 em을 쓰기 위해 em을 주입하도록 함
//    private final MyBoardRepository myBoardRepository;
//
//    @Autowired
//    public springConfig(MyBoardRepository myBoardRepository){
//        this.myBoardRepository=myBoardRepository;
//    }
//
//
////    @Bean //얘를 스프링 빈으로 등록할 것이라는 의미
////    public BoardService boardService(){
////        //return new BoardService(realBoardRepository()); //스프링 빈으로 등록된 realBoardRepository를 넣음
////        return new BoardService(boardRepository()); //스프링 빈으로 등록된 realBoardRepository를 넣음
////
////    }
//
//    @Bean //얘를 스프링 빈으로 등록할 것이라는 의미
//    public MyBoardService myBoardService(){
//        //return new BoardService(realBoardRepository()); //스프링 빈으로 등록된 realBoardRepository를 넣음
//        return new MyBoardService(mmyBoardRepository()); //스프링 빈으로 등록된 realBoardRepository를 넣음
//
//    }
//
////    @Bean
////    public RealBoardRepository realBoardRepository(){
////       return new RealBoardRepository();
////    }
//
////    @Bean
////    public BoardRepository boardRepository(){
////        return new JpaBoardRepository(em);
////    }
//
//    @Bean
//    public MyBoardRepository mmyBoardRepository(){
//        return myBoardRepository;
//    }
//}

//그럼 이제 스프링이 뜰 때, BoardService와 BoardRepository를 둘 다 스프링 빈으로 등록함
