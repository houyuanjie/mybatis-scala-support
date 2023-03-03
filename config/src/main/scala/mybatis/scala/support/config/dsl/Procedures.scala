package mybatis.scala.support.config.dsl

import mybatis.scala.support.config.builder.{Builder, ConfigurationBuilder, EnvironmentsBuilder}
import org.apache.ibatis.mapping.Environment
import org.apache.ibatis.session.Configuration
import org.apache.ibatis.transaction.TransactionFactory

import javax.sql.DataSource

/** Context Procedure
  * @tparam Context
  *   Needed type to perform this procedure
  */
type With[Context] = Context ?=> Unit

def configuration(procedure: With[ConfigurationBuilder]): Configuration =
  val configurationBuilder = new ConfigurationBuilder
  procedure(using configurationBuilder)
  configurationBuilder.build()

def environments(default: String)(procedure: With[EnvironmentsBuilder])(using
    configurationBuilder: ConfigurationBuilder
): Unit =
  val environmentsBuilder = new EnvironmentsBuilder(default)
  procedure(using environmentsBuilder)
  val environments = environmentsBuilder.build()
  configurationBuilder.setEnvironments(environments)

def environment(id: String)(transactionFactory: TransactionFactory, dataSource: DataSource)(using
    environmentsBuilder: EnvironmentsBuilder
): Unit =
  val environment = new Environment(id, transactionFactory, dataSource)
  environmentsBuilder.appendEnvironment(environment)
