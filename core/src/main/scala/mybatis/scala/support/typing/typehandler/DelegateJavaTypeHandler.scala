package mybatis.scala.support.typing.typehandler

import mybatis.scala.support.typing.typehandler.TypeHandler
import org.apache.ibatis.`type`.{TypeHandler as _, *}

import java.sql.{CallableStatement, PreparedStatement, ResultSet}

class DelegateJavaTypeHandler[T](delegate: BaseTypeHandler[T]) extends TypeHandler[T]:
  override def setParameter(ps: PreparedStatement, i: Int, parameter: T, jdbcType: JdbcType): Unit =
    delegate.setParameter(ps, i, parameter, jdbcType)

  override def getResult(rs: ResultSet, columnName: String): T =
    delegate.getResult(rs, columnName)

  override def getResult(rs: ResultSet, columnIndex: Int): T =
    delegate.getResult(rs, columnIndex)

  override def getResult(cs: CallableStatement, columnIndex: Int): T =
    delegate.getResult(cs, columnIndex)

object DelegateJavaTypeHandler extends DelegateJavaTypeHandlerInstances:
  inline def make[T](baseTypeHandler: BaseTypeHandler[T]): TypeHandler[T] =
    new DelegateJavaTypeHandler[T](baseTypeHandler)

trait DelegateJavaTypeHandlerInstances:
  import DelegateJavaTypeHandler.make

  given stringTypeHandler: TypeHandler[java.lang.String] = make(new StringTypeHandler)
  given characterTypeHandler: TypeHandler[java.lang.Character] = make(new CharacterTypeHandler)

  given booleanTypeHandler: TypeHandler[java.lang.Boolean] = make(new BooleanTypeHandler)

  given byteTypeHandler: TypeHandler[java.lang.Byte] = make(new ByteTypeHandler)
  given shortTypeHandler: TypeHandler[java.lang.Short] = make(new ShortTypeHandler)
  given integerTypeHandler: TypeHandler[java.lang.Integer] = make(new IntegerTypeHandler)
  given longTypeHandler: TypeHandler[java.lang.Long] = make(new LongTypeHandler)

  given floatTypeHandler: TypeHandler[java.lang.Float] = make(new FloatTypeHandler)
  given doubleTypeHandler: TypeHandler[java.lang.Double] = make(new DoubleTypeHandler)

  given bigIntegerTypeHandler: TypeHandler[java.math.BigInteger] = make(new BigIntegerTypeHandler)
  given bigDecimalTypeHandler: TypeHandler[java.math.BigDecimal] = make(new BigDecimalTypeHandler)

  given blobTypeHandler: TypeHandler[Array[Byte]] = make(new BlobTypeHandler)

  given utilDateTypeHandler: TypeHandler[java.util.Date] = make(new DateTypeHandler)
  given sqlDateTypeHandler: TypeHandler[java.sql.Date] = make(new SqlDateTypeHandler)
  given sqlTimeTypeHandler: TypeHandler[java.sql.Time] = make(new SqlTimeTypeHandler)
  given sqlTimestampTypeHandler: TypeHandler[java.sql.Timestamp] = make(new SqlTimestampTypeHandler)
  given localDateTypeHandler: TypeHandler[java.time.LocalDate] = make(new LocalDateTypeHandler)
  given localTimeTypeHandler: TypeHandler[java.time.LocalTime] = make(new LocalTimeTypeHandler)
  given localDateTimeTypeHandler: TypeHandler[java.time.LocalDateTime] = make(new LocalDateTimeTypeHandler)
  given zonedDateTimeTypeHandler: TypeHandler[java.time.ZonedDateTime] = make(new ZonedDateTimeTypeHandler)

object DelegateJavaTypeHandlerInstances extends DelegateJavaTypeHandlerInstances
