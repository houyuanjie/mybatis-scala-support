package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.BooleanTypeHandler;
import org.apache.ibatis.type.TypeHandler;

public class BooleanOptionTypeHandler extends DelegateScalaOptionTypeHandler<Boolean> {
    @Override
    public TypeHandler<Boolean> delegate() {
        return new BooleanTypeHandler();
    }
}
