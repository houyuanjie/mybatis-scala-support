package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.BlobTypeHandler;
import org.apache.ibatis.type.TypeHandler;

public class BlobOptionTypeHandler extends DelegateScalaOptionTypeHandler<byte[]> {
    @Override
    public TypeHandler<byte[]> delegate() {
        return new BlobTypeHandler();
    }
}
