package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.SqlDateTypeHandler;

import java.sql.Date;

@MappedJdbcTypes(JdbcType.DATE)
public class SqlDateOptionTypeHandler extends DelegateScalaOptionTypeHandler<Date> {
    public SqlDateOptionTypeHandler() {
        super(new SqlDateTypeHandler());
    }
}
