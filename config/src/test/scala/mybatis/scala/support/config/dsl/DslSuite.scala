package mybatis.scala.support.config.dsl

import munit.*
import mybatis.scala.support.objecting.ScalaObjectFactory
import org.apache.ibatis.mapping.Environment
import org.apache.ibatis.reflection.factory.DefaultObjectFactory
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory
import org.apache.ibatis.session.Configuration
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory

import java.io.PrintWriter
import java.sql.Connection
import java.util.logging.Logger
import javax.sql.DataSource

class DslSuite extends FunSuite:

  test("configuration build dsl") {
    val fakeDataSource = new DataSource:
      override def getConnection: Connection = null
      override def getConnection(username: String, password: String): Connection = null
      override def getLogWriter: PrintWriter = null
      override def setLogWriter(out: PrintWriter): Unit = ()
      override def setLoginTimeout(seconds: Int): Unit = ()
      override def getLoginTimeout: Int = 9999
      override def getParentLogger: Logger = null
      override def unwrap[T](iface: Class[T]): T = null.asInstanceOf[T]
      override def isWrapperFor(iface: Class[_]): Boolean = false

    val fakeTransactionFactory = new ManagedTransactionFactory

    val obtained =
      configuration {
        objectFactory := new ScalaObjectFactory
        objectWrapperFactory := new DefaultObjectWrapperFactory

        environments("test2") {
          environment("test1")(
            transactionFactory = new JdbcTransactionFactory,
            dataSource = fakeDataSource
          )
          environment("test2")(
            transactionFactory = fakeTransactionFactory,
            dataSource = fakeDataSource
          )
        }
      }.build()

    val expected =
      new Configuration(new Environment("test2", fakeTransactionFactory, fakeDataSource))

    expected.setObjectFactory(new ScalaObjectFactory)

    assertEquals(obtained.getEnvironment.getId, expected.getEnvironment.getId)
    assertEquals(obtained.getEnvironment.getTransactionFactory, expected.getEnvironment.getTransactionFactory)
    assertEquals(obtained.getEnvironment.getDataSource, expected.getEnvironment.getDataSource)
    assertEquals(obtained.getObjectFactory.getClass, expected.getObjectFactory.getClass)
    assertEquals(obtained.getObjectWrapperFactory.getClass, expected.getObjectWrapperFactory.getClass)
  }
