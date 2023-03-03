package mybatis.scala.support.config.model

import org.apache.ibatis.mapping.Environment

class Environments(
    val default: String,
    val vector: Vector[Environment]
)
