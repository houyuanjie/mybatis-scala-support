package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.DoubleTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

@MappedJdbcTypes(JdbcType.DOUBLE)
public class DoubleOptionTypeHandler extends DelegateScalaOptionTypeHandler<Double> {
    public DoubleOptionTypeHandler() {
        super(new DoubleTypeHandler());
    }
}
