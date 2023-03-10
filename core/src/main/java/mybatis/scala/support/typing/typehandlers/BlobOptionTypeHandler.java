package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.BlobTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import scala.Option;

@MappedTypes(Option.class)
@MappedJdbcTypes({JdbcType.BLOB, JdbcType.VARBINARY, JdbcType.LONGVARBINARY})
public class BlobOptionTypeHandler extends DelegateScalaOptionTypeHandler<byte[]> {
    public BlobOptionTypeHandler() {
        super(new BlobTypeHandler());
    }
}
