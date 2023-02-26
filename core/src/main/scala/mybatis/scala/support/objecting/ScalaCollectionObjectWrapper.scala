package mybatis.scala.support.objecting

import org.apache.ibatis.reflection.factory.ObjectFactory
import org.apache.ibatis.reflection.property.PropertyTokenizer
import org.apache.ibatis.reflection.wrapper.ObjectWrapper

import scala.collection.mutable

trait ScalaCollectionObjectWrapper extends ObjectWrapper:

  override def isCollection: Boolean = true

  override def get(prop: PropertyTokenizer) = throw new UnsupportedOperationException
  override def set(prop: PropertyTokenizer, value: AnyRef): Unit = throw new UnsupportedOperationException
  override def findProperty(name: String, useCamelCaseMapping: Boolean) = throw new UnsupportedOperationException
  override def getGetterNames = throw new UnsupportedOperationException
  override def getSetterNames = throw new UnsupportedOperationException
  override def getSetterType(name: String) = throw new UnsupportedOperationException
  override def getGetterType(name: String) = throw new UnsupportedOperationException
  override def hasSetter(name: String) = throw new UnsupportedOperationException
  override def hasGetter(name: String) = throw new UnsupportedOperationException
  override def instantiatePropertyValue(name: String, prop: PropertyTokenizer, objectFactory: ObjectFactory) =
    throw new UnsupportedOperationException

class ArrayBufferObjectWrapper(buffer: mutable.ArrayBuffer[AnyRef]) extends ScalaCollectionObjectWrapper:
  import scala.jdk.CollectionConverters.*

  override def add(element: AnyRef): Unit =
    buffer.append(element)

  override def addAll[E](elements: java.util.List[E]): Unit =
    buffer.addAll(elements.asInstanceOf[java.util.Collection[AnyRef]].asScala)

class HashSetObjectWrapper(set: mutable.HashSet[AnyRef]) extends ScalaCollectionObjectWrapper:
  import scala.jdk.CollectionConverters.*

  override def add(element: AnyRef): Unit =
    set.add(element)

  override def addAll[E](elements: java.util.List[E]): Unit =
    set.addAll(elements.asInstanceOf[java.util.Collection[AnyRef]].asScala)
