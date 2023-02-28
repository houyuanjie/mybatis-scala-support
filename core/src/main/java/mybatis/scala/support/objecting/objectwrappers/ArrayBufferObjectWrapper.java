package mybatis.scala.support.objecting.objectwrappers;

import org.apache.ibatis.reflection.MetaObject;
import scala.collection.mutable.ArrayBuffer;

import java.util.List;

public class ArrayBufferObjectWrapper extends ScalaCollectionObjectWrapper {

    private final ArrayBuffer arrayBuffer;

    public ArrayBufferObjectWrapper(MetaObject metaObject, ArrayBuffer arrayBuffer) {
        this.arrayBuffer = arrayBuffer;
    }

    @Override
    public void add(Object element) {
        arrayBuffer.addOne(element);
    }

    @Override
    public <E> void addAll(List<E> element) {
        element.forEach(arrayBuffer::addOne);
    }

}
