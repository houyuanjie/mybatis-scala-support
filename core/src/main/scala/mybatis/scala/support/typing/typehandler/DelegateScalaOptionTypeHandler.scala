package mybatis.scala.support.typing.typehandler

import org.apache.ibatis.`type`.JdbcType

import java.sql.{CallableStatement, PreparedStatement, ResultSet}

class DelegateScalaOptionTypeHandler[T](delegate: TypeHandler[T]) extends TypeHandler[scala.Option[T]]:

  override def setParameter(ps: PreparedStatement, i: Int, parameter: Option[T], jdbcType: JdbcType): Unit =
    parameter match
      case Some(value) => delegate.setParameter(ps, i, value, jdbcType)
      case None        => delegate.setParameter(ps, i, null.asInstanceOf[T], jdbcType)

  override def getResult(rs: ResultSet, columnName: String): Option[T] =
    Option(delegate.getResult(rs, columnName))

  override def getResult(rs: ResultSet, columnIndex: Int): Option[T] =
    Option(delegate.getResult(rs, columnIndex))

  override def getResult(cs: CallableStatement, columnIndex: Int): Option[T] =
    Option(delegate.getResult(cs, columnIndex))

object DelegateScalaOptionTypeHandler extends DelegateScalaOptionTypeHandlerInstances

trait DelegateScalaOptionTypeHandlerInstances:
  given [T](using delegate: TypeHandler[T]): TypeHandler[scala.Option[T]] =
    new DelegateScalaOptionTypeHandler[T](delegate)

object DelegateScalaOptionTypeHandlerInstances extends DelegateScalaOptionTypeHandlerInstances
