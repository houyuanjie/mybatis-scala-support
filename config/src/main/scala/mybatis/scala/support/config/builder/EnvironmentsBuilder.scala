package mybatis.scala.support.config.builder

import mybatis.scala.support.config.model.Environments
import org.apache.ibatis.mapping.Environment

import scala.annotation.implicitNotFound

@implicitNotFound("Please put me inside 'dsl.environments' or give me a 'builder.EnvironmentsBuilder'")
class EnvironmentsBuilder(default: String) extends Builder[Environments]:

  // field

  private var environmentVector: Vector[Environment] = Vector.empty

  // update

  def appendEnvironment(environment: Environment): Unit =
    this.environmentVector = this.environmentVector.appended(environment)

  // override

  override def build(): Environments =
    new Environments(default, environmentVector)
