package hello.boardspring.mapper;

import hello.boardspring.domain.Board;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



@Mapper(componentModel = "spring") //해당 속성 반드시!!! 해줘야 함!!- spring과 mapstruct 같이 쓸 땐 무조건
public abstract class BoardMapper {

  //근데 굳이 modify함수를 매퍼로 처리할 필요가 있나? 그냥 이거 자체가 매핑/덮어씌우는 거 아닌가? - 일단 구조는 이렇게 해두자
  public Board modify(Board in, Board out) { //in이 수정하고 싶은 내용이 담긴 수정본, out은 그냥 단순히 덮어씌워질 "기존 "객체
    if(in == null){
      return null;
    }

    out.setId(in.getId());
    out.setTitle(in.getTitle());
    out.setDescCont(in.getDescCont());

    return out;
  }
}
