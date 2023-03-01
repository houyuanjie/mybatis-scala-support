package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.StringTypeHandler;
import scala.Option;

@MappedTypes(Option.class)
@MappedJdbcTypes({JdbcType.VARCHAR, JdbcType.CHAR})
public class StringOptionTypeHandler extends DelegateScalaOptionTypeHandler<String> {
    public StringOptionTypeHandler() {
        super(new StringTypeHandler());
    }
}
