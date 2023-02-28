package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.DoubleTypeHandler;
import org.apache.ibatis.type.TypeHandler;

public class DoubleOptionTypeHandler extends DelegateScalaOptionTypeHandler<Double> {
    @Override
    public TypeHandler<Double> delegate() {
        return new DoubleTypeHandler();
    }
}
