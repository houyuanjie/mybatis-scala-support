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

  given TypeHandler[java.lang.String] = convert(new StringTypeHandler)

  given TypeHandler[java.lang.Boolean] = convert(new BooleanTypeHandler)

  given TypeHandler[java.lang.Byte] = convert(new ByteTypeHandler)
  given TypeHandler[java.lang.Short] = convert(new ShortTypeHandler)
  given TypeHandler[java.lang.Integer] = convert(new IntegerTypeHandler)
  given TypeHandler[java.lang.Long] = convert(new LongTypeHandler)

  given TypeHandler[java.lang.Float] = convert(new FloatTypeHandler)
  given TypeHandler[java.lang.Double] = convert(new DoubleTypeHandler)

  given TypeHandler[java.math.BigInteger] = convert(new BigIntegerTypeHandler)
  given TypeHandler[java.math.BigDecimal] = convert(new BigDecimalTypeHandler)

  given TypeHandler[Array[Byte]] = convert(new BlobTypeHandler)

  given TypeHandler[java.util.Date] = convert(new DateTypeHandler)
  given TypeHandler[java.time.LocalDate] = convert(new LocalDateTypeHandler)
  given TypeHandler[java.time.LocalTime] = convert(new LocalTimeTypeHandler)
  given TypeHandler[java.time.LocalDateTime] = convert(new LocalDateTimeTypeHandler)
  given TypeHandler[java.time.ZonedDateTime] = convert(new ZonedDateTimeTypeHandler)

object JavaTypeHandlerInstances extends JavaTypeHandlerInstances
