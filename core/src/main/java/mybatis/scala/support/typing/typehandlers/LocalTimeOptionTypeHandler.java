package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.LocalTimeTypeHandler;
import org.apache.ibatis.type.TypeHandler;

import java.time.LocalTime;

public class LocalTimeOptionTypeHandler extends DelegateScalaOptionTypeHandler<LocalTime> {
    @Override
    public TypeHandler<LocalTime> delegate() {
        return new LocalTimeTypeHandler();
    }
}
