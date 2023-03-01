package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.ZonedDateTimeTypeHandler;
import scala.Option;

import java.time.ZonedDateTime;

@MappedTypes(Option.class)
@MappedJdbcTypes(JdbcType.TIMESTAMP)
public class ZonedDateTimeOptionTypeHandler extends DelegateScalaOptionTypeHandler<ZonedDateTime> {
    public ZonedDateTimeOptionTypeHandler() {
        super(new ZonedDateTimeTypeHandler());
    }
}
