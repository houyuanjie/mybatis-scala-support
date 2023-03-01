package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.SqlDateTypeHandler;
import scala.Option;

import java.sql.Date;

@MappedTypes(Option.class)
@MappedJdbcTypes(JdbcType.DATE)
public class SqlDateOptionTypeHandler extends DelegateScalaOptionTypeHandler<Date> {
    public SqlDateOptionTypeHandler() {
        super(new SqlDateTypeHandler());
    }
}
