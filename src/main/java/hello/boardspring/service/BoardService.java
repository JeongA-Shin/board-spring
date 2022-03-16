package hello.boardspring.service;

import com.querydsl.core.types.Predicate; //따로 dependcy 설치 해줬어야 했음
import hello.boardspring.domain.Board;
import hello.boardspring.mapper.BoardMapper;
import hello.boardspring.repository.BoardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
  private final BoardRepository repository;
  private final BoardMapper mapper;

  /**
   * 목록조회
   * @param search 검색조건
   * @return 검색된 목록 리스트
   */
  @Transactional(readOnly = true,isolation = Isolation.READ_UNCOMMITTED)
  public List<Board> getList(Predicate search){
    return (List<Board>)repository.findAll(search);
  }

  /**
   * 페이징 조회
   */

  /**
   * 등록 (Create)
   */

  /**
   * 조회 (Read)
   */


  /**
   * 수정(Update)
   */

  /**
   * 삭제(Delete)
   */
}
