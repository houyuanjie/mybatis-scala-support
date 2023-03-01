package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.SqlTimeTypeHandler;

import java.sql.Time;

@MappedJdbcTypes(JdbcType.TIME)
public class SqlTimeOptionTypeHandler extends DelegateScalaOptionTypeHandler<Time> {
    public SqlTimeOptionTypeHandler() {
        super(new SqlTimeTypeHandler());
    }
}
