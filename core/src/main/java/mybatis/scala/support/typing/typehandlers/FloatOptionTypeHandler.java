package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.FloatTypeHandler;
import org.apache.ibatis.type.TypeHandler;

public class FloatOptionTypeHandler extends DelegateScalaOptionTypeHandler<Float> {
    @Override
    public TypeHandler<Float> delegate() {
        return new FloatTypeHandler();
    }
}
