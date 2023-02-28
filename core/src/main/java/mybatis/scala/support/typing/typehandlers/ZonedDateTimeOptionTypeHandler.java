package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.ZonedDateTimeTypeHandler;

import java.time.ZonedDateTime;

public class ZonedDateTimeOptionTypeHandler extends DelegateScalaOptionTypeHandler<ZonedDateTime> {
    @Override
    public TypeHandler<ZonedDateTime> delegate() {
        return new ZonedDateTimeTypeHandler();
    }
}
