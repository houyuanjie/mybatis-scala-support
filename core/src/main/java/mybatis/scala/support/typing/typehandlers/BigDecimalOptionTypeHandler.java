package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.BigDecimalTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import scala.Option;

import java.math.BigDecimal;

@MappedTypes(Option.class)
@MappedJdbcTypes({JdbcType.DECIMAL, JdbcType.NUMERIC})
public class BigDecimalOptionTypeHandler extends DelegateScalaOptionTypeHandler<BigDecimal> {
    public BigDecimalOptionTypeHandler() {
        super(new BigDecimalTypeHandler());
    }
}
