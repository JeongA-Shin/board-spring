package hello.boardspring.predicate;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import hello.boardspring.controller.form.BoardForm;
import hello.boardspring.domain.QBoard;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

public class BoardFormPredicate { //실제 db에 객체가 있는지 확인해야 함
  //즉 실제 db에 대해 쿼리를 날려야 하므로 Q class를 써야 함

  //사용자가 넘겨준 검색 조건에 맞게 predicate(booleanBuilder)를 만드는 함수
  public static Predicate search(BoardForm.Input.GetAll in){
    BooleanBuilder builder=new BooleanBuilder();
    QBoard qboard = QBoard.board;

    if(StringUtils.isNotEmpty(in.getTitle())){ //제목에 대한 검색 조건이 있다면
      builder.and(qboard.title.lower().contains(in.getTitle().toLowerCase(Locale.ROOT))); //일부라도 일치한다면 그걸로 판단함
    }

    if(StringUtils.isNotEmpty(in.getDescCont())){
      builder.and(qboard.descCont.contains(in.getDescCont().toLowerCase(Locale.ROOT)));
    }

    return builder; //위의 내용들을 모두 충족하는 것

  }
}
