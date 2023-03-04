package mybatis.scala.support.config.model

import org.apache.ibatis.mapping.Environment

class Environments(
    val defaultId: String,
    val vector: Vector[Environment]
)
