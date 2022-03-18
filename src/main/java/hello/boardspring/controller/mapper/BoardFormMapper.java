package hello.boardspring.controller.mapper;


import hello.boardspring.controller.form.BoardForm;
import hello.boardspring.domain.Board;
import java.util.List;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(
    implementationName = "BoardFormMapperImpl",
    builder=@Builder(disableBuilder = true),
    componentModel = "spring"
)
public abstract class BoardFormMapper { //Board는 엔티티, BoardForm은 DTO

  // dto가 파라미터로 들어오면 엔티티로 매핑함
  public abstract Board toBoard(BoardForm.Input.Add in);
  public abstract Board toBoard(BoardForm.Input.Modify in);

  //엔티티를  dto로
  public abstract BoardForm.OutPut.Get toGet(Board in); //객체를 dto(form)객체(형식으)로 바꿈
  public abstract BoardForm.OutPut.GetAll toGetAll(Board in);

  public abstract List<BoardForm.OutPut.GetAll> toGetAllList(List<Board> in);

}
