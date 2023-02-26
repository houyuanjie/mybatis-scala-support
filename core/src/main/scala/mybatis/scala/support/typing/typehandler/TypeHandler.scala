package mybatis.scala.support.typing.typehandler

import org.apache.ibatis.`type`.TypeHandler as MyBatisTypeHandler

type TypeHandler[T] = MyBatisTypeHandler[T]

object TypeHandler extends TypeHandlerInstances:
  def of[T](using typeHandler: TypeHandler[T]): TypeHandler[T] = typeHandler

trait TypeHandlerInstances
    extends JavaTypeHandlerInstances
    with DelegateScalaTypeHandlerInstances
    with DelegateScalaOptionTypeHandlerInstances

object TypeHandlerInstances extends TypeHandlerInstances
