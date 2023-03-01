package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.LocalTimeTypeHandler;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.time.LocalTime;

@MappedJdbcTypes(JdbcType.TIME)
public class LocalTimeOptionTypeHandler extends DelegateScalaOptionTypeHandler<LocalTime> {
    public LocalTimeOptionTypeHandler() {
        super(new LocalTimeTypeHandler());
    }
}
