package mybatis.scala.support.config.model

import org.apache.ibatis.mapping.Environment

case class Environments(
    default: String = "default",
    seq: Vector[Environment] = Vector.empty
)
