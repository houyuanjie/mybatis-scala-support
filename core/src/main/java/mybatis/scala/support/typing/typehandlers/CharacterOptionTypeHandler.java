package mybatis.scala.support.typing.typehandlers;

import mybatis.scala.support.typing.DelegateScalaOptionTypeHandler;
import org.apache.ibatis.type.CharacterTypeHandler;
import org.apache.ibatis.type.TypeHandler;

public class CharacterOptionTypeHandler extends DelegateScalaOptionTypeHandler<Character> {
    @Override
    public TypeHandler<Character> delegate() {
        return new CharacterTypeHandler();
    }
}

