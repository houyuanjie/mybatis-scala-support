package mybatis.scala.support.objecting;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import scala.collection.mutable.*;

public class ScalaObjectFactory extends DefaultObjectFactory {

    @Override
    protected Class<?> resolveInterface(Class<?> type) {
        Class<?> resolved;

        if (type == Seq.class) {
            resolved = ArrayBuffer.class;
        } else if (type == Set.class) {
            resolved = HashSet.class;
        } else if (type == Map.class) {
            resolved = HashMap.class;
        } else {
            resolved = super.resolveInterface(type);
        }

        return resolved;
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return Seq.class.isAssignableFrom(type) ||
                Set.class.isAssignableFrom(type) ||
                super.isCollection(type);
    }

}
