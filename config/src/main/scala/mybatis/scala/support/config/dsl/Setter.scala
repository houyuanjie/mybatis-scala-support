package mybatis.scala.support.config.dsl

import scala.annotation.targetName

class Setter[C, P](setter: C => P => Unit):
  @targetName("set")
  inline def :=(parameter: P)(using carrier: C): Unit =
    setter(carrier)(parameter)
