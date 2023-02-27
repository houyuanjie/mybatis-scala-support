package mybatis.scala.support.typing.typehandler

import mybatis.scala.support.typing.{Boxed, Unboxed}
import org.apache.ibatis.`type`.JdbcType

import java.sql.{CallableStatement, PreparedStatement, ResultSet}

class DelegateScalaTypeHandler[T, DelegateType](
    boxed: Boxed[T] { type Output = DelegateType },
    unboxed: Unboxed[T] { type Input = DelegateType },
    delegate: TypeHandler[DelegateType]
) extends TypeHandler[T]:

  override def setParameter(ps: PreparedStatement, i: Int, parameter: T, jdbcType: JdbcType): Unit =
    val boxedParameter: DelegateType = boxed.box(parameter)
    delegate.setParameter(ps, i, boxedParameter, jdbcType)

  override def getResult(rs: ResultSet, columnName: String): T =
    val result = delegate.getResult(rs, columnName)
    unboxed.unbox(result)

  override def getResult(rs: ResultSet, columnIndex: Int): T =
    val result = delegate.getResult(rs, columnIndex)
    unboxed.unbox(result)

  override def getResult(cs: CallableStatement, columnIndex: Int): T =
    val result = delegate.getResult(cs, columnIndex)
    unboxed.unbox(result)

object DelegateScalaTypeHandler extends DelegateScalaTypeHandlerInstances

trait DelegateScalaTypeHandlerInstances:
  given genericDelegateScalaTypeHandler[T, DelegateType](using
      boxed: Boxed[T] { type Output = DelegateType },
      unboxed: Unboxed[T] { type Input = DelegateType },
      delegate: TypeHandler[DelegateType]
  ): TypeHandler[T] =
    new DelegateScalaTypeHandler[T, DelegateType](boxed, unboxed, delegate)

object DelegateScalaTypeHandlerInstances extends DelegateScalaTypeHandlerInstances
