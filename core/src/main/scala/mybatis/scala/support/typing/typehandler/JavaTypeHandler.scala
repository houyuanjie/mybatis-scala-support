package mybatis.scala.support.typing.typehandler

import org.apache.ibatis.`type`.{TypeHandler as _, *}

import java.sql.{CallableStatement, PreparedStatement, ResultSet}

object JavaTypeHandler extends JavaTypeHandlerInstances:
  inline def convert[T](baseTypeHandler: BaseTypeHandler[T]): TypeHandler[T] = new TypeHandler[T]:

    override def setParameter(ps: PreparedStatement, i: Int, parameter: T, jdbcType: JdbcType): Unit =
      baseTypeHandler.setParameter(ps, i, parameter, jdbcType)

    override def getResult(rs: ResultSet, columnName: String): T =
      baseTypeHandler.getResult(rs, columnName)

    override def getResult(rs: ResultSet, columnIndex: Int): T =
      baseTypeHandler.getResult(rs, columnIndex)

    override def getResult(cs: CallableStatement, columnIndex: Int): T =
      baseTypeHandler.getResult(cs, columnIndex)

trait JavaTypeHandlerInstances:
  import JavaTypeHandler.convert

  given stringTypeHandler: TypeHandler[java.lang.String] = convert(new StringTypeHandler)

  given booleanTypeHandler: TypeHandler[java.lang.Boolean] = convert(new BooleanTypeHandler)

  given byteTypeHandler: TypeHandler[java.lang.Byte] = convert(new ByteTypeHandler)
  given shortTypeHandler: TypeHandler[java.lang.Short] = convert(new ShortTypeHandler)
  given integerTypeHandler: TypeHandler[java.lang.Integer] = convert(new IntegerTypeHandler)
  given longTypeHandler: TypeHandler[java.lang.Long] = convert(new LongTypeHandler)

  given floatTypeHandler: TypeHandler[java.lang.Float] = convert(new FloatTypeHandler)
  given doubleTypeHandler: TypeHandler[java.lang.Double] = convert(new DoubleTypeHandler)

  given bigIntegerTypeHandler: TypeHandler[java.math.BigInteger] = convert(new BigIntegerTypeHandler)
  given bigDecimalTypeHandler: TypeHandler[java.math.BigDecimal] = convert(new BigDecimalTypeHandler)

  given blobTypeHandler: TypeHandler[Array[Byte]] = convert(new BlobTypeHandler)

  given utilDateTypeHandler: TypeHandler[java.util.Date] = convert(new DateTypeHandler)
  given sqlDateTypeHandler: TypeHandler[java.sql.Date] = convert(new SqlDateTypeHandler)
  given sqlTimeTypeHandler: TypeHandler[java.sql.Time] = convert(new SqlTimeTypeHandler)
  given sqlTimestampTypeHandler: TypeHandler[java.sql.Timestamp] = convert(new SqlTimestampTypeHandler)
  given localDateTypeHandler: TypeHandler[java.time.LocalDate] = convert(new LocalDateTypeHandler)
  given localTimeTypeHandler: TypeHandler[java.time.LocalTime] = convert(new LocalTimeTypeHandler)
  given localDateTimeTypeHandler: TypeHandler[java.time.LocalDateTime] = convert(new LocalDateTimeTypeHandler)
  given zonedDateTimeTypeHandler: TypeHandler[java.time.ZonedDateTime] = convert(new ZonedDateTimeTypeHandler)

object JavaTypeHandlerInstances extends JavaTypeHandlerInstances
