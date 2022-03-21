package hello.boardspring.domain.common;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) //현재 JPA의 AUDIT 기능을 사용 중. AUDIT에 대한 리스너임
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class RegModEntity implements Reg,Mod{

  /**
   * 등록자식별번호
   */
  @CreatedBy
  @Column(name = "reg_id", length = 30, nullable = false, updatable = false)
  private UUID regId;

  /**
   * 등록일시
   */
  @CreatedDate
  @Column(name = "reg_dt", nullable = false, updatable = false)
  @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
  private DateTime regDt;
//  private Timestamp regDt;

  /**
   * 수정자식별번호
   */
  @LastModifiedBy
  @Column(name = "mod_id", length = 30)
  private UUID modId;

  /**
   * 수정일시
   */
  @LastModifiedDate
  @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
  @Column(name = "mod_dt")
  private DateTime modDt;
//  private Timestamp modDt;

}
