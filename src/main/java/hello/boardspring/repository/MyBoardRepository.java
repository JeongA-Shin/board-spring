package hello.boardspring.repository;

import hello.boardspring.domain.MyBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyBoardRepository extends JpaRepository<MyBoard,Long> {
}
