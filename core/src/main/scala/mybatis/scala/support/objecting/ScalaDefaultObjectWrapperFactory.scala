package mybatis.scala.support.objecting

import org.apache.ibatis.reflection.MetaObject
import org.apache.ibatis.reflection.wrapper.{DefaultObjectWrapperFactory, ObjectWrapper}

import scala.collection.mutable

class ScalaDefaultObjectWrapperFactory extends DefaultObjectWrapperFactory:

  override def hasWrapperFor(obj: AnyRef): Boolean =
    obj match
      case buffer: mutable.ArrayBuffer[?] => true
      case set: mutable.HashSet[?]        => true
      case other                          => super.hasWrapperFor(other)

  override def getWrapperFor(metaObject: MetaObject, obj: AnyRef): ObjectWrapper =
    obj match
      case buffer: mutable.ArrayBuffer[?] =>
        new ArrayBufferObjectWrapper(buffer.asInstanceOf[mutable.ArrayBuffer[AnyRef]])
      case set: mutable.HashSet[?] =>
        new HashSetObjectWrapper(set.asInstanceOf[mutable.HashSet[AnyRef]])
      case other =>
        super.getWrapperFor(metaObject, other)
