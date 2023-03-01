package mybatis.scala.support.objecting;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.CollectionWrapper;
import org.apache.ibatis.reflection.wrapper.MapWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.HashSet;
import scala.jdk.CollectionConverters;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ScalaObjectWrapperFactory implements ObjectWrapperFactory {

    @Override
    public boolean hasWrapperFor(Object object) {
        return object instanceof ArrayBuffer || object instanceof HashSet || object instanceof HashMap;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        ObjectWrapper objectWrapper = null;

        if (object instanceof ArrayBuffer) {
            ArrayBuffer<?> arrayBuffer = ((ArrayBuffer<?>) object);
            List<?> list = CollectionConverters.BufferHasAsJava(arrayBuffer).asJava();
            objectWrapper = new CollectionWrapper(metaObject, (List<Object>) list);
        } else if (object instanceof HashSet) {
            HashSet<?> hashSet = (HashSet<?>) object;
            Set<?> set = CollectionConverters.MutableSetHasAsJava(hashSet).asJava();
            objectWrapper = new CollectionWrapper(metaObject, (Set<Object>) set);
        } else if (object instanceof HashMap) {
            HashMap<?, ?> hashMap = (HashMap<?, ?>) object;
            Map<String, Object> map = (Map<String, Object>) CollectionConverters.MutableMapHasAsJava(hashMap).asJava();
            objectWrapper = new MapWrapper(metaObject, map);
        } else {
            throw new IllegalArgumentException("Type (" + object.getClass().getName() + ") is NOT supported.");
        }

        return objectWrapper;
    }

}
