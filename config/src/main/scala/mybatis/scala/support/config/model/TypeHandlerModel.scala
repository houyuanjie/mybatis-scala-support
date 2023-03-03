package mybatis.scala.support.config.model

import org.apache.ibatis.`type`.{JdbcType, TypeHandler}

sealed trait TypeHandlerModel

class ConcreteTypeHandler[T](
    val typeHandler: TypeHandler[T],
    val javaType: Class[T],
    val jdbcType: JdbcType
) extends TypeHandlerModel

class PackageTypeHandler(
    val packageName: String
) extends TypeHandlerModel
