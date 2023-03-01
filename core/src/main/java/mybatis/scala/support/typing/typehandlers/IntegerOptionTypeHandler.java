package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.IntegerTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

@MappedJdbcTypes(JdbcType.INTEGER)
public class IntegerOptionTypeHandler extends DelegateScalaOptionTypeHandler<Integer> {
    public IntegerOptionTypeHandler() {
        super(new IntegerTypeHandler());
    }
}
