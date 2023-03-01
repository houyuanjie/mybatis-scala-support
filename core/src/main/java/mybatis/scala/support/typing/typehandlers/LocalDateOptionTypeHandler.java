package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.LocalDateTypeHandler;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.time.LocalDate;

@MappedJdbcTypes(JdbcType.DATE)
public class LocalDateOptionTypeHandler extends DelegateScalaOptionTypeHandler<LocalDate> {
    public LocalDateOptionTypeHandler() {
        super(new LocalDateTypeHandler());
    }
}
