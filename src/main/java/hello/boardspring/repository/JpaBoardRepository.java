package hello.boardspring.repository;

import hello.boardspring.domain.Board;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaBoardRepository implements BoardRepository {

    private final EntityManager em; //JPA는 entity manager라는 것을 통해 모든 동작을 함
    //jpa 라이브러리를 설치하면 스프링 부트가 알아서 EntityManager를 생성함

    public JpaBoardRepository(EntityManager em) { //외부에서 해당 db를 사용하고 싶은 애랑 같아야 하므로 injeciton을 해줌
        this.em = em;
    }

    @Override
    public Board save(Board board) {
        em.persist(board); //이게 저장하는 것
        return board; //이건 걍 반환형 맞출려고
    }

    @Override
    public Optional<Board> findByIdx(Long idx) {
        //pk로 조회하는 경우의 코드
        Board board=em.find(Board.class,idx); //em.find(조회되는 타입,식별자)
        return Optional.ofNullable(board);
    }

    @Override
    public Optional<Board> findByTitle(String title) {
        //pk가 아닌 값으로 조회하는 코드
        List<Board> result=em.createQuery("select b from Board b where b.title= :title",Board.class) //쿼리문에서 반환되는 타입
                .setParameter("title",title)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Board> findAll() {
        //jpa는 table이 아니라 객체를 대상으로 쿼리를 날린다
        return em.createQuery("select b from Board b",Board.class)
                       .getResultList();
    }
}
