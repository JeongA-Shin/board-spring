package hello.boardspring.domain;

import hello.boardspring.domain.common.RegModEntity;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;



@Entity
@Table(name="board" )
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class Board extends RegModEntity {

  /**
   *식별번호
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO) //db에서 자동으로 생성되도록 해준다
  @Column(name="id",nullable = false)
  private UUID id;

  /**
   * 글 제목
   */
  @Column(name="title")
  private String title;

  /**
   * 글 내용 */
  @Column(name="desc_cont")
  private String descCont;


  //id getter setter
  public UUID getId() {
    return id;
  }

  public void setId(UUID Id) {
    this.id=Id;
  }

}
