package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.InstantTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.time.Instant;

@MappedJdbcTypes(JdbcType.TIMESTAMP)
public class InstantOptionTypeHandler extends DelegateScalaOptionTypeHandler<Instant> {
    public InstantOptionTypeHandler() {
        super(new InstantTypeHandler());
    }
}
