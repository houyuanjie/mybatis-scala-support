package mybatis.scala.support.objecting;

import mybatis.scala.support.objecting.objectwrappers.ArrayBufferObjectWrapper;
import mybatis.scala.support.objecting.objectwrappers.HashSetObjectWrapper;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.HashSet;

public class ScalaObjectWrapperFactory implements ObjectWrapperFactory {

    @Override
    public boolean hasWrapperFor(Object object) {
        return object instanceof ArrayBuffer || object instanceof HashSet;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        ObjectWrapper objectWrapper = null;

        if (object instanceof ArrayBuffer) {
            objectWrapper = new ArrayBufferObjectWrapper(metaObject, (ArrayBuffer) object);
        } else if (object instanceof HashSet) {
            objectWrapper = new HashSetObjectWrapper(metaObject, (HashSet) object);
        } else {
            throw new IllegalArgumentException("Type (" + object.getClass().getName() + ") is NOT supported.");
        }

        return objectWrapper;
    }

}
