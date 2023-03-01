package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.LocalDateTimeTypeHandler;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import scala.Option;

import java.time.LocalDateTime;

@MappedTypes(Option.class)
@MappedJdbcTypes(JdbcType.TIMESTAMP)
public class LocalDateTimeOptionTypeHandler extends DelegateScalaOptionTypeHandler<LocalDateTime> {
    public LocalDateTimeOptionTypeHandler() {
        super(new LocalDateTimeTypeHandler());
    }
}
