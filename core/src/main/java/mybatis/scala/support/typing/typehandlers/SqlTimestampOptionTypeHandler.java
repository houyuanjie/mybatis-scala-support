package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.SqlTimestampTypeHandler;
import org.apache.ibatis.type.TypeHandler;

import java.sql.Timestamp;

public class SqlTimestampOptionTypeHandler extends DelegateScalaOptionTypeHandler<Timestamp> {
    @Override
    public TypeHandler<Timestamp> delegate() {
        return new SqlTimestampTypeHandler();
    }
}
