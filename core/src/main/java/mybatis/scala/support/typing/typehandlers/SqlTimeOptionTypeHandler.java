package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.SqlTimeTypeHandler;
import scala.Option;

import java.sql.Time;

@MappedTypes(Option.class)
@MappedJdbcTypes(JdbcType.TIME)
public class SqlTimeOptionTypeHandler extends DelegateScalaOptionTypeHandler<Time> {
    public SqlTimeOptionTypeHandler() {
        super(new SqlTimeTypeHandler());
    }
}
