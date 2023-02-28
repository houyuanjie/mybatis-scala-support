package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.StringTypeHandler;
import org.apache.ibatis.type.TypeHandler;

public class StringOptionTypeHandler extends DelegateScalaOptionTypeHandler<String> {
    @Override
    public TypeHandler<String> delegate() {
        return new StringTypeHandler();
    }
}
