package hello.boardspring.domain;
import javax.persistence.*;

@Entity //이제부터 JPA가 관리하는 객체가 된다는 것
public class Board {
    
    @Id //primary key임
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //db가 자동으로 생성해주되, 이게 SEQUENCE가 됨
    private Long idx; //데이터를 구분하기 위한 인덱스
    
    //@Column(name="boardtitle") : 만약 이 도에인 변수와 JPA 테이블의 컬럼명이 다르면 이 COLUM에 해당 변수를 매핑하라는 의미
    private String title;
    
    public Long getIdx() {
        return idx;
    }
    
    public void setIdx(Long idx) {
        this.idx = idx;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
   
}
