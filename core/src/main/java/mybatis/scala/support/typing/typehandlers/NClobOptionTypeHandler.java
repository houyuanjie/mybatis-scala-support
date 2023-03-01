package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.NClobTypeHandler;
import scala.Option;

@MappedTypes(Option.class)
@MappedJdbcTypes(JdbcType.NCLOB)
public class NClobOptionTypeHandler extends DelegateScalaOptionTypeHandler<String> {
    public NClobOptionTypeHandler() {
        super(new NClobTypeHandler());
    }
}
