package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.IntegerTypeHandler;
import org.apache.ibatis.type.TypeHandler;

public class IntegerOptionTypeHandler extends DelegateScalaOptionTypeHandler<Integer> {
    @Override
    public TypeHandler<Integer> delegate() {
        return new IntegerTypeHandler();
    }
}
