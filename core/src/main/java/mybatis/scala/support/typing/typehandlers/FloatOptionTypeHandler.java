package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.FloatTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import scala.Option;

@MappedTypes(Option.class)
@MappedJdbcTypes({JdbcType.FLOAT, JdbcType.REAL})
public class FloatOptionTypeHandler extends DelegateScalaOptionTypeHandler<Float> {
    public FloatOptionTypeHandler() {
        super(new FloatTypeHandler());
    }
}
