package mybatis.scala.support.objecting;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.HashSet;
import scala.collection.mutable.Set;

public class ScalaDefaultObjectFactory extends DefaultObjectFactory {

    @Override
    protected Class<?> resolveInterface(Class<?> type) {
        Class<?> resolved = super.resolveInterface(type);

        if (resolved == Buffer.class) {
            resolved = ArrayBuffer.class;
        } else if (resolved == Set.class) {
            resolved = HashSet.class;
        } else {
        }

        return resolved;
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        boolean collection = super.isCollection(type);
        return collection || Buffer.class.isAssignableFrom(type) || Set.class.isAssignableFrom(type);
    }

}
