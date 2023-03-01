package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.LongTypeHandler;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import scala.Option;

@MappedTypes(Option.class)
@MappedJdbcTypes(JdbcType.BIGINT)
public class LongOptionTypeHandler extends DelegateScalaOptionTypeHandler<Long> {
    public LongOptionTypeHandler() {
        super(new LongTypeHandler());
    }
}
