package mybatis.scala.support.config.model

import org.apache.ibatis.mapping.Environment

class Environments(
    val defaultEnvironmentId: String,
    val vector: Vector[Environment]
)
