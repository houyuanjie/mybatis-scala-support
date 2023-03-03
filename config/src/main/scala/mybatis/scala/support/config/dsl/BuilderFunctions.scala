package mybatis.scala.support.config.dsl

import org.apache.ibatis.mapping.Environment
import org.apache.ibatis.session.Configuration
import org.apache.ibatis.transaction.TransactionFactory

import javax.sql.DataSource

def configuration(function: ConfigurationBuilder ?=> Unit): Configuration =
  val configurationBuilder = new ConfigurationBuilder
  function(using configurationBuilder)
  configurationBuilder.build()

def environments(default: String)(
    function: EnvironmentsBuilder ?=> Unit
)(using configurationBuilder: ConfigurationBuilder): Unit =
  val environmentsBuilder = new EnvironmentsBuilder(default)
  function(using environmentsBuilder)
  val environments = environmentsBuilder.build()
  configurationBuilder.setEnvironments(environments)

def environment(id: String)(
    transactionFactory: TransactionFactory,
    dataSource: DataSource
)(using esb: EnvironmentsBuilder): Unit =
  val environment = new Environment(id, transactionFactory, dataSource)
  esb.addEnvironment(environment)
