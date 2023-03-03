package mybatis.scala.support.config.builder

import mybatis.scala.support.config.model.Environments
import mybatis.scala.support.objecting.{ScalaObjectFactory, ScalaObjectWrapperFactory}
import org.apache.ibatis.reflection.factory.ObjectFactory
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory
import org.apache.ibatis.session.Configuration

import scala.annotation.implicitNotFound

@implicitNotFound("Please put me inside 'dsl.configuration' or give me a 'builder.ConfigurationBuilder'")
class ConfigurationBuilder extends Builder[Configuration]:

  // field

  private var objectFactory: ObjectFactory = new ScalaObjectFactory
  private var objectWrapperFactory: ObjectWrapperFactory = new ScalaObjectWrapperFactory
  private var environments: Environments = Environments()

  // setter

  def setObjectFactory(objectFactory: ObjectFactory): Unit =
    this.objectFactory = objectFactory

  def setObjectWrapperFactory(objectWrapperFactory: ObjectWrapperFactory): Unit =
    this.objectWrapperFactory = objectWrapperFactory

  def setEnvironments(environments: Environments): Unit =
    this.environments = environments

  // override

  override def build(): Configuration =
    val defaultEnvironmentId = this.environments.default
    build(defaultEnvironmentId)

  def build(defaultEnvironmentId: String): Configuration =
    val configuration = new Configuration()

    doSetEnvironment(configuration, defaultEnvironmentId, environments)

    configuration

  // private

  private def doSetEnvironment(configuration: Configuration, default: String, environments: Environments): Unit =
    if environments.seq.isEmpty then throw new IllegalStateException("Please define at least one Environment")

    val filtered = for (env <- environments.seq if env.getId == default) yield env

    if filtered.isEmpty then throw new IllegalStateException(s"Could NOT found an Environment with id=$default")
    else if filtered.size == 1 then
      val env = filtered.head
      configuration.setEnvironment(env)
    else throw new IllegalStateException(s"Found multiple Environments where id=$default")
