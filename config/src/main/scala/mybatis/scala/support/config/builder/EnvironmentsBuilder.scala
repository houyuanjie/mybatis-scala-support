package mybatis.scala.support.config.builder

import mybatis.scala.support.config.model.Environments
import org.apache.ibatis.mapping.Environment

class EnvironmentsBuilder(default: String) extends Builder[Environments]:

  private var environmentVector: Vector[Environment] = Vector.empty

  def appendEnvironment(environment: Environment): Unit =
    this.environmentVector = this.environmentVector.appended(environment)

  override def build(): Environments =
    Environments(default, environmentVector)
