package mybatis.scala.support.typing.typehandler.instances

import mybatis.scala.support.typing.typehandler.TypeHandler
import org.apache.ibatis.`type`.JdbcType

import java.sql.{CallableStatement, PreparedStatement, ResultSet}

class DelegateUsingTypeHandler[T](using delegate: TypeHandler[T]) extends TypeHandler[T]:

  override def setParameter(ps: PreparedStatement, i: Int, parameter: T, jdbcType: JdbcType): Unit =
    delegate.setParameter(ps, i, parameter, jdbcType)

  override def getResult(rs: ResultSet, columnName: String): T =
    delegate.getResult(rs, columnName)

  override def getResult(rs: ResultSet, columnIndex: Int): T =
    delegate.getResult(rs, columnIndex)

  override def getResult(cs: CallableStatement, columnIndex: Int): T =
    delegate.getResult(cs, columnIndex)
