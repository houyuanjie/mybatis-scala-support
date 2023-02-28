package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.DateTypeHandler;
import org.apache.ibatis.type.TypeHandler;

import java.util.Date;

public class UtilDateOptionTypeHandler extends DelegateScalaOptionTypeHandler<Date> {
    @Override
    public TypeHandler<Date> delegate() {
        return new DateTypeHandler();
    }
}
