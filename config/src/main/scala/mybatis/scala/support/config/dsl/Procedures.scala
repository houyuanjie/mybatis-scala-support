package mybatis.scala.support.config.dsl

import mybatis.scala.support.config.builder.*
import mybatis.scala.support.config.model.*
import org.apache.ibatis.`type`.{JdbcType, TypeHandler}
import org.apache.ibatis.mapping.Environment
import org.apache.ibatis.session.Configuration
import org.apache.ibatis.transaction.TransactionFactory

import javax.sql.DataSource

/** Context Procedure
  *
  * Using Context type to perform this procedure
  */
type With[Context] = Context ?=> Unit

// ROOT -> configuration

def configuration(procedure: With[ConfigurationBuilder]): ConfigurationBuilder =
  val configurationBuilder = new ConfigurationBuilder
  procedure(using configurationBuilder)
  configurationBuilder

// ROOT -> configuration -> typeHandlers

def typeHandlers(procedure: With[TypeHandlersBuilder])(using
    configurationBuilder: ConfigurationBuilder
): Unit =
  val typeHandlersBuilder = new TypeHandlersBuilder
  procedure(using typeHandlersBuilder)
  val typeHandlers = typeHandlersBuilder.build()
  configurationBuilder.appendAllTypeHandlers(typeHandlers)

// ROOT -> configuration -> typeHandlers -> typeHandler

def typeHandler[T](typeHandler: TypeHandler[T], javaType: Class[T], jdbcType: JdbcType)(using
    typeHandlersBuilder: TypeHandlersBuilder
): Unit =
  val concreteTypeHandler = new ConcreteTypeHandler(typeHandler, javaType, jdbcType)
  typeHandlersBuilder.appendTypeHandler(concreteTypeHandler)

// ROOT -> configuration -> typeHandlers -> typeHandler

def typeHandler(packageName: String)(using
    typeHandlersBuilder: TypeHandlersBuilder
): Unit =
  val packageTypeHandler = new PackageTypeHandler(packageName)
  typeHandlersBuilder.appendTypeHandler(packageTypeHandler)

// ROOT -> configuration -> environments

def environments(defaultId: String)(procedure: With[EnvironmentsBuilder])(using
    configurationBuilder: ConfigurationBuilder
): Unit =
  val environmentsBuilder = new EnvironmentsBuilder(defaultId)
  procedure(using environmentsBuilder)
  val environments = environmentsBuilder.build()
  configurationBuilder.setEnvironments(environments)

// ROOT -> configuration -> environments -> environment

def environment(id: String)(transactionFactory: TransactionFactory, dataSource: DataSource)(using
    environmentsBuilder: EnvironmentsBuilder
): Unit =
  val environment = new Environment(id, transactionFactory, dataSource)
  environmentsBuilder.appendEnvironment(environment)
