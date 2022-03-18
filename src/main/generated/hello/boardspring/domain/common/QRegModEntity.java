package hello.boardspring.domain.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRegModEntity is a Querydsl query type for RegModEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QRegModEntity extends EntityPathBase<RegModEntity> {

    private static final long serialVersionUID = 359131489L;

    public static final QRegModEntity regModEntity = new QRegModEntity("regModEntity");

    public final DateTimePath<org.joda.time.DateTime> modDt = createDateTime("modDt", org.joda.time.DateTime.class);

    public final ComparablePath<java.util.UUID> modId = createComparable("modId", java.util.UUID.class);

    public final DateTimePath<org.joda.time.DateTime> regDt = createDateTime("regDt", org.joda.time.DateTime.class);

    public final ComparablePath<java.util.UUID> regId = createComparable("regId", java.util.UUID.class);

    public QRegModEntity(String variable) {
        super(RegModEntity.class, forVariable(variable));
    }

    public QRegModEntity(Path<? extends RegModEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRegModEntity(PathMetadata metadata) {
        super(RegModEntity.class, metadata);
    }

}

