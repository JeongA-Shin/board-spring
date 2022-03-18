package hello.boardspring.controller.mapper;

import hello.boardspring.controller.form.BoardForm.OutPut.Get;
import hello.boardspring.controller.form.BoardForm.OutPut.GetAll;
import hello.boardspring.domain.Board;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-18T14:10:33+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_322 (Temurin)"
)
public class BoardFormMapperImpl extends BoardFormMapper {

    @Override
    public Get toGet(Board in) {
        if ( in == null ) {
            return null;
        }

        Get get = new Get();

        get.setId( in.getId() );
        get.setTitle( in.getTitle() );
        get.setDescCont( in.getDescCont() );
        get.setRegId( in.getRegId() );
        get.setRegDt( in.getRegDt() );
        get.setModId( in.getModId() );
        get.setModDt( in.getModDt() );

        return get;
    }

    @Override
    public GetAll toGetAll(Board in) {
        if ( in == null ) {
            return null;
        }

        GetAll getAll = new GetAll();

        getAll.setId( in.getId() );
        getAll.setTitle( in.getTitle() );
        getAll.setDescCont( in.getDescCont() );
        getAll.setRegId( in.getRegId() );
        getAll.setRegDt( in.getRegDt() );
        getAll.setModId( in.getModId() );
        getAll.setModDt( in.getModDt() );

        return getAll;
    }

    @Override
    public List<GetAll> toGetAllList(List<Board> in) {
        if ( in == null ) {
            return null;
        }

        List<GetAll> list = new ArrayList<GetAll>( in.size() );
        for ( Board board : in ) {
            list.add( toGetAll( board ) );
        }

        return list;
    }
}