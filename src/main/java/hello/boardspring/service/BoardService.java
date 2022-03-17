package hello.boardspring.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate; //따로 dependcy 설치 해줬어야 했음
import hello.boardspring.domain.Board;
import hello.boardspring.mapper.BoardMapper;
import hello.boardspring.repository.BoardRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
   * @params search 검색조건
   * @params page 페이징 조건
   * @return  검색된 목록 페이지
   */
  @Transactional(readOnly = true,isolation=Isolation.READ_UNCOMMITTED)
  public Page<Board> getPage(Predicate search, Pageable page){ //page에는 페이징 조건
    return repository.findAll(search,page);
  }

  /**
   * 등록 (Create)
   * @params  entity
   * @return
   */
  public Board add(Board entity){
    return repository.save(entity);
  }



  /**
   * 조회 (Read)
   * @Params  id 식별번호
   * @return
   */
  @Transactional(readOnly = true)
  public Board get(UUID id){
    return repository.findOne(new BooleanBuilder(QBoard.Board.id.eq(id)));
  }


  /**
   * 수정(Update) //그냥 수정할 내용을 가지고 있는 객체로 갈아끼움
   *  @parma entity
   *  @return
   */
  public Board modify(UUID id,Board entity){ //entity는 얘로 수정이 되어야 하는 객체. 즉 수정본
    entity.setId(id);
    return mapper.modify(entity,get(entity.getId()));

  }

  /**
   * 삭제
   * @param id 번호
   */
  public void remove(UUID id){
    repository.deleteById(id);
  }
}
