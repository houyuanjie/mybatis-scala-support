package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.LongTypeHandler;
import org.apache.ibatis.type.TypeHandler;

public class LongOptionTypeHandler extends DelegateScalaOptionTypeHandler<Long> {
    @Override
    public TypeHandler<Long> delegate() {
        return new LongTypeHandler();
    }
}
