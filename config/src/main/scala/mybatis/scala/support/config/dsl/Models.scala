package mybatis.scala.support.config.dsl

import org.apache.ibatis.mapping.Environment

// Please define Immutable Data Types as mybatis configuration holders

case class Environments(
    default: String = "default",
    seq: Seq[Environment] = Seq.empty
)
