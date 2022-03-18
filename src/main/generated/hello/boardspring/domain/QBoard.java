package hello.boardspring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = 827628627L;

    public static final QBoard board = new QBoard("board");

    public final hello.boardspring.domain.common.QRegModEntity _super = new hello.boardspring.domain.common.QRegModEntity(this);

    public final StringPath descCont = createString("descCont");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    //inherited
    public final DateTimePath<org.joda.time.DateTime> modDt = _super.modDt;

    //inherited
    public final ComparablePath<java.util.UUID> modId = _super.modId;

    //inherited
    public final DateTimePath<org.joda.time.DateTime> regDt = _super.regDt;

    //inherited
    public final ComparablePath<java.util.UUID> regId = _super.regId;

    public final StringPath title = createString("title");

    public QBoard(String variable) {
        super(Board.class, forVariable(variable));
    }

    public QBoard(Path<? extends Board> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoard(PathMetadata metadata) {
        super(Board.class, metadata);
    }

}

