package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.ByteTypeHandler;
import org.apache.ibatis.type.TypeHandler;

public class ByteOptionTypeHandler extends DelegateScalaOptionTypeHandler<Byte> {
    @Override
    public TypeHandler<Byte> delegate() {
        return new ByteTypeHandler();
    }
}
