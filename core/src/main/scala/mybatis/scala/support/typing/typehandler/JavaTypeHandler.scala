package mybatis.scala.support.typing.typehandler

import org.apache.ibatis.`type`.*

object JavaTypeHandler extends JavaTypeHandlerInstances

trait JavaTypeHandlerInstances:

  given TypeHandler[java.lang.String] = new StringTypeHandler

  given TypeHandler[java.lang.Boolean] = new BooleanTypeHandler

  given TypeHandler[java.lang.Byte] = new ByteTypeHandler
  given TypeHandler[java.lang.Short] = new ShortTypeHandler
  given TypeHandler[java.lang.Integer] = new IntegerTypeHandler
  given TypeHandler[java.lang.Long] = new LongTypeHandler

  given TypeHandler[java.lang.Float] = new FloatTypeHandler
  given TypeHandler[java.lang.Double] = new DoubleTypeHandler

  given TypeHandler[java.math.BigInteger] = new BigIntegerTypeHandler
  given TypeHandler[java.math.BigDecimal] = new BigDecimalTypeHandler

  given TypeHandler[Array[Byte]] = new BlobTypeHandler

  given TypeHandler[java.util.Date] = new DateTypeHandler
  given TypeHandler[java.time.LocalDate] = new LocalDateTypeHandler
  given TypeHandler[java.time.LocalTime] = new LocalTimeTypeHandler
  given TypeHandler[java.time.LocalDateTime] = new LocalDateTimeTypeHandler
  given TypeHandler[java.time.ZonedDateTime] = new ZonedDateTimeTypeHandler

object JavaTypeHandlerInstances extends JavaTypeHandlerInstances
