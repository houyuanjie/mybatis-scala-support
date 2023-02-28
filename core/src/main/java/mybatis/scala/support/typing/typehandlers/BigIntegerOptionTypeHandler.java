package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.BigIntegerTypeHandler;
import org.apache.ibatis.type.TypeHandler;

import java.math.BigInteger;

public class BigIntegerOptionTypeHandler extends DelegateScalaOptionTypeHandler<BigInteger> {
    @Override
    public TypeHandler<BigInteger> delegate() {
        return new BigIntegerTypeHandler();
    }
}
