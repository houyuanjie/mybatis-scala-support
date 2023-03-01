package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.NStringTypeHandler;
import scala.Option;

@MappedTypes(Option.class)
@MappedJdbcTypes({JdbcType.NVARCHAR, JdbcType.NCHAR})
public class NStringOptionTypeHandler extends DelegateScalaOptionTypeHandler<String> {
    public NStringOptionTypeHandler() {
        super(new NStringTypeHandler());
    }
}
