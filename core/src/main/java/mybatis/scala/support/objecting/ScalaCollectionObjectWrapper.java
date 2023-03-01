package mybatis.scala.support.objecting;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.CollectionWrapper;

import java.util.Collection;

public class ScalaCollectionObjectWrapper extends CollectionWrapper {

    public ScalaCollectionObjectWrapper(MetaObject metaObject, Collection<Object> object) {
        super(metaObject, object);
    }

    @Override
    public String findProperty(String name, boolean useCamelCaseMapping) {
        return null;
    }

}
