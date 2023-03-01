package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.ShortTypeHandler;

@MappedJdbcTypes({JdbcType.SMALLINT, JdbcType.TINYINT})
public class ShortOptionTypeHandler extends DelegateScalaOptionTypeHandler<Short> {
    public ShortOptionTypeHandler() {
        super(new ShortTypeHandler());
    }
}
