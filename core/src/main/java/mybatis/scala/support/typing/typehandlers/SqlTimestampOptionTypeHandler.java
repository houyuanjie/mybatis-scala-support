package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.SqlTimestampTypeHandler;
import scala.Option;

import java.sql.Timestamp;

@MappedTypes(Option.class)
@MappedJdbcTypes(JdbcType.TIMESTAMP)
public class SqlTimestampOptionTypeHandler extends DelegateScalaOptionTypeHandler<Timestamp> {
    public SqlTimestampOptionTypeHandler() {
        super(new SqlTimestampTypeHandler());
    }
}
