package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.BigDecimalTypeHandler;
import org.apache.ibatis.type.TypeHandler;

import java.math.BigDecimal;

public class BigDecimalOptionTypeHandler extends DelegateScalaOptionTypeHandler<BigDecimal> {
    @Override
    public TypeHandler<BigDecimal> delegate() {
        return new BigDecimalTypeHandler();
    }
}
