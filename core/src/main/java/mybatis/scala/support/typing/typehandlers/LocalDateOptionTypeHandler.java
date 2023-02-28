package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.LocalDateTypeHandler;
import org.apache.ibatis.type.TypeHandler;

import java.time.LocalDate;

public class LocalDateOptionTypeHandler extends DelegateScalaOptionTypeHandler<LocalDate> {
    @Override
    public TypeHandler<LocalDate> delegate() {
        return new LocalDateTypeHandler();
    }
}
