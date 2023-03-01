package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.BigDecimalTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.math.BigDecimal;

@MappedJdbcTypes({JdbcType.DECIMAL, JdbcType.NUMERIC})
public class BigDecimalOptionTypeHandler extends DelegateScalaOptionTypeHandler<BigDecimal> {
    public BigDecimalOptionTypeHandler() {
        super(new BigDecimalTypeHandler());
    }
}
