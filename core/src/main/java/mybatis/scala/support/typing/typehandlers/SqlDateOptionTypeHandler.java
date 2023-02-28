package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.SqlDateTypeHandler;
import org.apache.ibatis.type.TypeHandler;

import java.sql.Date;

public class SqlDateOptionTypeHandler extends DelegateScalaOptionTypeHandler<Date> {
    @Override
    public TypeHandler<Date> delegate() {
        return new SqlDateTypeHandler();
    }
}
