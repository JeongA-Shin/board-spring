package hello.boardspring.repository;

import hello.boardspring.domain.Board;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor; //동적 쿼리 가능하도록
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, UUID>, QuerydslPredicateExecutor<Board> {

}
