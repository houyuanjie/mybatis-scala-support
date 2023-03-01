package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.BooleanTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import scala.Option;

@MappedTypes(Option.class)
@MappedJdbcTypes({JdbcType.BOOLEAN, JdbcType.BIT})
public class BooleanOptionTypeHandler extends DelegateScalaOptionTypeHandler<Boolean> {
    public BooleanOptionTypeHandler() {
        super(new BooleanTypeHandler());
    }
}
