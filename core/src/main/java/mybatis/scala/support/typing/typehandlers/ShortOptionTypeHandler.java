package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.ShortTypeHandler;
import org.apache.ibatis.type.TypeHandler;

public class ShortOptionTypeHandler extends DelegateScalaOptionTypeHandler<Short> {
    @Override
    public TypeHandler<Short> delegate() {
        return new ShortTypeHandler();
    }
}
