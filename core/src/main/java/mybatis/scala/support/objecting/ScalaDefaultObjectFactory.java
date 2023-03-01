package mybatis.scala.support.objecting;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import scala.collection.mutable.*;

public class ScalaDefaultObjectFactory extends DefaultObjectFactory {

    @Override
    protected Class<?> resolveInterface(Class<?> type) {
        Class<?> resolved = super.resolveInterface(type);

        if (resolved == Seq.class) {
            resolved = ArrayBuffer.class;
        } else if (resolved == Set.class) {
            resolved = HashSet.class;
        } else if (resolved == Map.class) {
            resolved = HashMap.class;
        }

        return resolved;
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        boolean collection = super.isCollection(type);
        return collection || Seq.class.isAssignableFrom(type) || Set.class.isAssignableFrom(type);
    }

}
