package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.SqlTimeTypeHandler;
import org.apache.ibatis.type.TypeHandler;

import java.sql.Time;

public class SqlTimeOptionTypeHandler extends DelegateScalaOptionTypeHandler<Time> {
    @Override
    public TypeHandler<Time> delegate() {
        return new SqlTimeTypeHandler();
    }
}
