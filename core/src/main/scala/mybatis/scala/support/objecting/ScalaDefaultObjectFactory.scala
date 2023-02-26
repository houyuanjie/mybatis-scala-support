package mybatis.scala.support.objecting

import org.apache.ibatis.reflection.factory.DefaultObjectFactory

import java.util.Properties
import scala.collection.mutable

class ScalaDefaultObjectFactory extends DefaultObjectFactory:

  override def resolveInterface(clazz: Class[?]): Class[?] =
    var resolved = super.resolveInterface(clazz)
    if clazz == classOf[Seq[?]] then resolved = classOf[mutable.ArrayBuffer[?]]
    else if clazz == classOf[Set[?]] then resolved = classOf[mutable.HashSet[?]]
    else if clazz == classOf[Map[?, ?]] then resolved = classOf[mutable.HashMap[?, ?]]
    else resolved = clazz
    resolved

  override def isCollection[T](clazz: Class[T]): Boolean =
    super.isCollection(clazz) ||
      classOf[Seq[?]].isAssignableFrom(clazz) ||
      classOf[Set[?]].isAssignableFrom(clazz)
