package hello.boardspring.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity //이제부터 JPA가 관리하는 객체가 된다는 것
public class Board {
    
    @Id //primary key임
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //db가 자동으로 생성해주되, 이게 SEQUENCE가 됨
    private Long idx; //데이터를 구분하기 위한 인덱스
    
    //@Column(name="boardtitle") : 만약 이 도에인 변수와 JPA 테이블의 컬럼명이 다르면 이 COLUM에 해당 변수를 매핑하라는 의미
    private String title;
    //private String content;
    //private LocalDateTime createdDate;
    //private LocalDateTime updatedDate;
    
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
    
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public LocalDateTime getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(LocalDateTime createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public LocalDateTime getUpdatedDate() {
//        return updatedDate;
//    }
//
//    public void setUpdatedDate(LocalDateTime updatedDate) {
//        this.updatedDate = updatedDate;
//    }
}
