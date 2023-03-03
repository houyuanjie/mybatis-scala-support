package mybatis.scala.support.config.dsl

import org.apache.ibatis.mapping.Environment
import org.apache.ibatis.session.Configuration

trait Builder[T]:
  def build(): T

class ConfigurationBuilder extends Builder[Configuration]:

  private var environments: Environments = Environments()

  def setEnvironments(environments: Environments): Unit =
    this.environments = environments

  override def build(): Configuration =
    val result = new Configuration()

    // setEnvironment
    val default = environments.default
    val filtered = for (env <- environments.seq if env.getId == default) yield env
    if filtered.isEmpty then throw new IllegalStateException(s"Can NOT found an Environment with id=$default")
    else if filtered.size == 1 then
      val env = filtered.head
      result.setEnvironment(env)
    else throw new IllegalStateException(s"Found multiple Environments where id=$default")

    result

class EnvironmentsBuilder(default: String) extends Builder[Environments]:

  private var environmentVector: Vector[Environment] = Vector.empty

  def addEnvironment(environment: Environment): Unit =
    this.environmentVector = this.environmentVector :+ environment

  override def build(): Environments =
    Environments(default, environmentVector)
