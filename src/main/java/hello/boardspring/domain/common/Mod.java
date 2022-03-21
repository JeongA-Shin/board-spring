package hello.boardspring.domain.common;

import java.util.UUID;
import org.joda.time.DateTime;
//import java.sql.Timestamp;


/**
 * DB COLUMNS : MOD_ID, MOD_DT
 */
public interface Mod {
  /**
   * 수정자식별번호
   */
  UUID getModId();

  /**
   * 수정일시
   */
  DateTime getModDt();

}
