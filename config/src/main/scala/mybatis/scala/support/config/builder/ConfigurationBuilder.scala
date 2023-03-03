package mybatis.scala.support.config.builder

import mybatis.scala.support.config.model.Environments
import org.apache.ibatis.session.Configuration

class ConfigurationBuilder extends Builder[Configuration]:

  private var environments: Environments = Environments()

  def setEnvironments(environments: Environments): Unit =
    this.environments = environments

  override def build(): Configuration =
    val configuration = new Configuration()

    doSetEnvironment(configuration, environments)

    configuration

  private def doSetEnvironment(configuration: Configuration, environments: Environments): Unit =
    if environments.seq.isEmpty then throw new IllegalStateException("Please define at least one Environment")

    val default = environments.default
    val filtered = for (env <- environments.seq if env.getId == default) yield env

    if filtered.isEmpty then throw new IllegalStateException(s"Could NOT found an Environment with id=$default")
    else if filtered.size == 1 then
      val env = filtered.head
      configuration.setEnvironment(env)
    else throw new IllegalStateException(s"Found multiple Environments where id=$default")
