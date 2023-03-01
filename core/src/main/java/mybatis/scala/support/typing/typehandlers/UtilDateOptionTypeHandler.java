package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.DateTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.util.Date;

@MappedJdbcTypes(JdbcType.TIMESTAMP)
public class UtilDateOptionTypeHandler extends DelegateScalaOptionTypeHandler<Date> {
    public UtilDateOptionTypeHandler() {
        super(new DateTypeHandler());
    }
}