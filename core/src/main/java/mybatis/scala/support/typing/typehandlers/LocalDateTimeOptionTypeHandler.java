package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.LocalDateTimeTypeHandler;
import org.apache.ibatis.type.TypeHandler;

import java.time.LocalDateTime;

public class LocalDateTimeOptionTypeHandler extends DelegateScalaOptionTypeHandler<LocalDateTime> {
    @Override
    public TypeHandler<LocalDateTime> delegate() {
        return new LocalDateTimeTypeHandler();
    }
}
