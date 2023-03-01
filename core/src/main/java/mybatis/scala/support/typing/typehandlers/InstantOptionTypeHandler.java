package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.InstantTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import scala.Option;

import java.time.Instant;

@MappedTypes(Option.class)
@MappedJdbcTypes(JdbcType.TIMESTAMP)
public class InstantOptionTypeHandler extends DelegateScalaOptionTypeHandler<Instant> {
    public InstantOptionTypeHandler() {
        super(new InstantTypeHandler());
    }
}
