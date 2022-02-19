package hello.boardspring.repository;

import hello.boardspring.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board save(Board board);
    Optional<Board> findByIdx(Long idx);
    Optional<Board> findByTitle(String title);
    List<Board> findAll();
    
}
