package hello.boardspring.controller.form;

import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.joda.time.DateTime;

public class BoardForm { //DTO로 쓰일 객체임
  public static class Input{ //사용자(프론트가)가 넘겨주는 객체 폼 (dto)

    @Data
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetAll{ //사용자(프론트)가 파라미터로 넣어줄 리스트, 페이징 검색 조건에 해당되는 객체

      @ApiModelProperty(value="제목",position=0)
      private String title;

      @ApiModelProperty(value="설명내용",position=1)
      private String descCont;
    }

    @Data
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    //등록시 프론트에서 넘어오는 값
    public static class Add{ //Board 객체를 보면 알겠지만, id는 DB에서 자동으로 생성되도록 GenerationType을 정해놓았다

      @ApiModelProperty(value = "제목 - 길이 100", required = true, position = 0) //position --> 문서상에 보이는 순서
      @NotBlank(message = "속성키 은/는 필수입력 항목입니다.")
      @Length(max = 100, message = "속성키 의 입력길이를 확인하시기 바랍니다.")
      private String title;

      @ApiModelProperty(value="내용 - 길이 1000",required = true,position = 1)
      @Length(max = 1000, message = "속성값 의 입력길이를 확인하시기 바랍니다.")
      private String descCont;
    }


    @Data
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Modify {

      @ApiModelProperty(value = "제목 - 길이 1000", position = 0)
      @Length(max = 1000, message = "제목의 입력길이를 확인하시기 바랍니다.")
      private String title;

      @ApiModelProperty(value = "내용 - 길이 1000", position = 1)
      @Length(max = 1000, message = "내용 의 입력길이를 확인하시기 바랍니다.")
      private String descCont;

    }

    @Data
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Remove {

      @ApiModelProperty(value = "제목")
      private String title;
    }

  }


  public static class OutPut{ //검색 결과 등이 되는 객체 (dto)

    @Data
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetAll{ //검색 후 검색 결과에 해당되는 객체 폼

      @ApiModelProperty(value = "식별번호")
      private UUID id;

      @ApiModelProperty(value="제목")
      private String title;

      @ApiModelProperty(value="설명내용")
      private String descCont;

      @ApiModelProperty(value = "등록자식별번호")
      private UUID regId;

      @ApiModelProperty(value = "등록일시")
      private DateTime regDt;

      @ApiModelProperty(value = "수정자식별번호")
      private UUID modId;

      @ApiModelProperty(value = "수정일시")
      private DateTime modDt;
    }

    @Data
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Get { //상세 조회 시의 결과에 해당되는 객체(폼)

      @ApiModelProperty(value = "식별번호")
      private UUID id;

      @ApiModelProperty(value = "제목")
      private String title;

      @ApiModelProperty(value = "설명내용")
      private String descCont;

      @ApiModelProperty(value = "등록자식별번호")
      private UUID regId;

      @ApiModelProperty(value = "등록일시")
      private DateTime regDt;

      @ApiModelProperty(value = "수정자식별번호")
      private UUID modId;

      @ApiModelProperty(value = "수정일시")
      private DateTime modDt;

    }

  }
}
