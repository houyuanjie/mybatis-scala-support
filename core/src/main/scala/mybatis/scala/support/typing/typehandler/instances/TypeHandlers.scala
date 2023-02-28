package mybatis.scala.support.typing.typehandler.instances

import mybatis.scala.support.typing.typehandler.TypeHandler

// Scala Types

class ScalaCharTypeHandler extends DelegateUsingTypeHandler[Char]

class ScalaBooleanTypeHandler extends DelegateUsingTypeHandler[Boolean]

class ScalaByteTypeHandler extends DelegateUsingTypeHandler[Byte]
class ScalaShortTypeHandler extends DelegateUsingTypeHandler[Short]
class ScalaIntTypeHandler extends DelegateUsingTypeHandler[Int]
class ScalaLongTypeHandler extends DelegateUsingTypeHandler[Long]

class ScalaFloatTypeHandler extends DelegateUsingTypeHandler[Float]
class ScalaDoubleTypeHandler extends DelegateUsingTypeHandler[Double]

// Option Scala Types

class OptionScalaCharTypeHandler extends DelegateUsingTypeHandler[Option[Char]]

class OptionScalaBooleanTypeHandler extends DelegateUsingTypeHandler[Option[Boolean]]

class OptionScalaByteTypeHandler extends DelegateUsingTypeHandler[Option[Byte]]
class OptionScalaShortTypeHandler extends DelegateUsingTypeHandler[Option[Short]]
class OptionScalaIntTypeHandler extends DelegateUsingTypeHandler[Option[Int]]
class OptionScalaLongTypeHandler extends DelegateUsingTypeHandler[Option[Long]]

class OptionScalaFloatTypeHandler extends DelegateUsingTypeHandler[Option[Float]]
class OptionScalaDoubleTypeHandler extends DelegateUsingTypeHandler[Option[Double]]

// Option Java Types

class OptionStringTypeHandler extends DelegateUsingTypeHandler[Option[String]]
class OptionJavaCharacterTypeHandler extends DelegateUsingTypeHandler[Option[java.lang.Character]]

class OptionJavaBooleanTypeHandler extends DelegateUsingTypeHandler[Option[java.lang.Boolean]]

class OptionJavaByteTypeHandler extends DelegateUsingTypeHandler[Option[java.lang.Byte]]
class OptionJavaShortTypeHandler extends DelegateUsingTypeHandler[Option[java.lang.Short]]
class OptionJavaIntegerTypeHandler extends DelegateUsingTypeHandler[Option[java.lang.Integer]]
class OptionJavaLongTypeHandler extends DelegateUsingTypeHandler[Option[java.lang.Long]]

class OptionJavaFloatTypeHandler extends DelegateUsingTypeHandler[Option[java.lang.Float]]
class OptionJavaDoubleTypeHandler extends DelegateUsingTypeHandler[Option[java.lang.Double]]

class OptionJavaBigIntegerTypeHandler extends DelegateUsingTypeHandler[Option[java.math.BigInteger]]
class OptionJavaBigDecimalTypeHandler extends DelegateUsingTypeHandler[Option[java.math.BigDecimal]]

class OptionBlobTypeHandler extends DelegateUsingTypeHandler[Option[Array[Byte]]]

class OptionJavaUtilDateTypeHandler extends DelegateUsingTypeHandler[Option[java.util.Date]]
class OptionJavaSqlDateTypeHandler extends DelegateUsingTypeHandler[Option[java.sql.Date]]
class OptionJavaSqlTimeTypeHandler extends DelegateUsingTypeHandler[Option[java.sql.Time]]
class OptionJavaSqlTimestampTypeHandler extends DelegateUsingTypeHandler[Option[java.sql.Timestamp]]
class OptionJavaLocalDateTypeHandler extends DelegateUsingTypeHandler[Option[java.time.LocalDate]]
class OptionJavaLocalTimeTypeHandler extends DelegateUsingTypeHandler[Option[java.time.LocalTime]]
class OptionJavaLocalDateTimeTypeHandler extends DelegateUsingTypeHandler[Option[java.time.LocalDateTime]]
class OptionJavaZonedDateTimeTypeHandler extends DelegateUsingTypeHandler[Option[java.time.ZonedDateTime]]
