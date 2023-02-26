package mybatis.scala.support.typing.typehandler

import munit.*

class TypeHandlerSuite extends FunSuite:

  test("type-handler instances should be found by 'of' method") {
    import TypeHandler.given

    val byteTypeHandler = TypeHandler.of[Byte]
    val byteArrayTypeHandler = TypeHandler.of[Array[Byte]]
    val stringTypeHandler = TypeHandler.of[String]
    val stringOptionTypeHandler = TypeHandler.of[Option[String]]
  }
