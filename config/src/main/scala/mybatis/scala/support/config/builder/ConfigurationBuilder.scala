package mybatis.scala.support.config.builder

import mybatis.scala.support.config.model.*
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
  private var typeHandlers: Vector[TypeHandlerModel] =
    Vector(new PackageTypeHandler(packageName = "mybatis.scala.support.typing.typehandlers"))
  private var environments: Environments = new Environments(defaultId = "default", vector = Vector.empty)

  // update

  def setObjectFactory(objectFactory: ObjectFactory): Unit =
    this.objectFactory = objectFactory

  def setObjectWrapperFactory(objectWrapperFactory: ObjectWrapperFactory): Unit =
    this.objectWrapperFactory = objectWrapperFactory

  def appendAllTypeHandlers(typeHandlers: Vector[TypeHandlerModel]): Unit =
    this.typeHandlers = this.typeHandlers.appendedAll(typeHandlers)

  def setEnvironments(environments: Environments): Unit =
    this.environments = environments

  // override

  override def build(): Configuration =
    val defaultEnvironmentId = this.environments.defaultId
    build(defaultEnvironmentId)

  def build(defaultEnvironmentId: String): Configuration =
    val configuration = new Configuration()

    configuration.setObjectFactory(this.objectFactory)
    configuration.setObjectWrapperFactory(this.objectWrapperFactory)
    doRegistryTypeHandlers(configuration, this.typeHandlers)
    doSetEnvironment(configuration, defaultEnvironmentId, this.environments)

    configuration

  // private

  private def doRegistryTypeHandlers(
      configuration: Configuration,
      typeHandlers: Vector[TypeHandlerModel]
  ): Unit =
    val typeHandlerRegistry = configuration.getTypeHandlerRegistry
    for th <- typeHandlers do
      th match
        case cth: ConcreteTypeHandler[?] => typeHandlerRegistry.register(cth.javaType, cth.jdbcType, cth.typeHandler)
        case pth: PackageTypeHandler     => typeHandlerRegistry.register(pth.packageName)

  private def doSetEnvironment(
      configuration: Configuration,
      defaultEnvironmentId: String,
      environments: Environments
  ): Unit =
    if environments.vector.isEmpty then throw new IllegalStateException("Please define at least one Environment")

    val filtered = for env <- environments.vector if env.getId == defaultEnvironmentId yield env

    if filtered.isEmpty then
      throw new IllegalStateException(s"Could NOT found an Environment with id=$defaultEnvironmentId")
    else if filtered.size == 1 then
      val env = filtered.head
      configuration.setEnvironment(env)
    else throw new IllegalStateException(s"Found multiple Environments where id=$defaultEnvironmentId")
