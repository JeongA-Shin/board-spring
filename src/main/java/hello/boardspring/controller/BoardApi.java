package hello.boardspring.controller;

//import hello.boardspring.controller.form.BoardForm;
import hello.boardspring.controller.form.BoardForm;
import hello.boardspring.controller.form.BoardForm.OutPut.GetAll;
import hello.boardspring.controller.mapper.BoardFormMapper;
import hello.boardspring.predicate.BoardFormPredicate;
import hello.boardspring.service.BoardService;
//import io.swagger.annotations.Api;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Api(value = "API OF BOARD CRUD", tags = {"Board"})
@RequestMapping(value = "board", produces = MediaType.APPLICATION_JSON_VALUE) //produces는 반환하는 데이터 타입을 정의한다.  이럴 경우 반환 타입이 json으로 강제된다.
@RestController
@RequiredArgsConstructor
public class BoardApi {
  private final BoardService service;
  private final BoardFormMapper formMapper;

  @SneakyThrows
  @GetMapping("/get-list")
  public List<GetAll> getList(@Valid BoardForm.Input.GetAll in){
    return formMapper.toGetAllList(service.getList(BoardFormPredicate.search(in)));
  }

  @SneakyThrows
  @GetMapping("/get-page")
  public Page<GetAll> getPage(@Valid BoardForm.Input.GetAll in,@PageableDefault(size=20,sort="regDt",direction= Sort.Direction.DESC) Pageable page){
    //페이징에서는 매퍼를 .map을 통해서 해준다
    return service.getPage(BoardFormPredicate.search(in),page).map(formMapper::toGetAll);
  }

  @SneakyThrows
  @GetMapping("/get/{id}")
  public BoardForm.OutPut.Get get(@PathVariable UUID id){ //그냥 일반 쿼리 및 파라미터는 get?id=1234 , pathvariable은 get/1234
    return formMapper.toGet(service.get(id));
  }

  @SneakyThrows
  @PostMapping("/add")
  public BoardForm.OutPut.Get add(@Valid @RequestBody BoardForm.Input.Add in){
    return formMapper.toGet(service.add(formMapper.toBoard(in)));
  }

  @SneakyThrows
  @PostMapping("/modify/{id}")
  public BoardForm.OutPut.Get modify(@PathVariable UUID id, @Valid @RequestBody BoardForm.Input.Modify in){
    return formMapper.toGet(service.modify(id,formMapper.toBoard(in)));
  }

  @SneakyThrows
  @PostMapping("/remove/{id}")
  public void remove(@PathVariable UUID id){
    service.remove(id);
  }

}
