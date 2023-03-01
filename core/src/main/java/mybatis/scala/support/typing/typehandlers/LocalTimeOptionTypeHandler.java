package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.LocalTimeTypeHandler;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import scala.Option;

import java.time.LocalTime;

@MappedTypes(Option.class)
@MappedJdbcTypes(JdbcType.TIME)
public class LocalTimeOptionTypeHandler extends DelegateScalaOptionTypeHandler<LocalTime> {
    public LocalTimeOptionTypeHandler() {
        super(new LocalTimeTypeHandler());
    }
}
