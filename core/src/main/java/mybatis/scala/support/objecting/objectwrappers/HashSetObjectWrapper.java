package mybatis.scala.support.objecting.objectwrappers;

import org.apache.ibatis.reflection.MetaObject;
import scala.collection.mutable.HashSet;

import java.util.List;

public class HashSetObjectWrapper extends ScalaCollectionObjectWrapper {

    private final HashSet hashSet;

    public HashSetObjectWrapper(MetaObject metaObject, HashSet hashSet) {
        this.hashSet = hashSet;
    }

    @Override
    public void add(Object element) {
        hashSet.add(element);
    }

    @Override
    public <E> void addAll(List<E> element) {
        element.forEach(hashSet::add);
    }

}
