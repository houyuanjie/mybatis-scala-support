package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.ClobTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

@MappedJdbcTypes({JdbcType.CLOB, JdbcType.LONGVARCHAR})
public class ClobOptionTypeHandler extends DelegateScalaOptionTypeHandler<String> {
    public ClobOptionTypeHandler() {
        super(new ClobTypeHandler());
    }
}
