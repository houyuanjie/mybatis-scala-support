package mybatis.scala.support.session

import org.apache.ibatis.session.{SqlSession as MybatisSqlSession, *}

import java.sql.Connection

type SqlSession = MybatisSqlSession
type SqlSessionFunction[T] = SqlSession => T

object SqlSession:

  class Manager(sqlSessionFactory: SqlSessionFactory):

    def openSession(): SqlSession =
      sqlSessionFactory.openSession()

    def getConfiguration: Configuration =
      sqlSessionFactory.getConfiguration

    def readOnly[T](function: SqlSessionFunction[T])(
        execType: ExecutorType = ExecutorType.SIMPLE,
        level: TransactionIsolationLevel = null
    ): T =
      val session = sqlSessionFactory.openSession(execType, level)

      try
        val result = function(session)
        session.rollback()
        result
      finally session.close()

    def transaction[T](function: SqlSessionFunction[T])(
        session: SqlSession
    ): T =
      try
        val result = function(session)
        session.commit()
        result
      catch
        case commitThrowable: Throwable =>
          try session.rollback()
          catch case rollbackThrowable: Throwable => throw rollbackThrowable
          throw commitThrowable
      finally session.close()

    def transaction[T](function: SqlSessionFunction[T])(
        autoCommit: Boolean
    ): T =
      val session = sqlSessionFactory.openSession(autoCommit)
      transaction(function)(session)

    def transaction[T](function: SqlSessionFunction[T])(
        connection: Connection
    ): T =
      val session = sqlSessionFactory.openSession(connection)
      transaction(function)(session)

    def transaction[T](function: SqlSessionFunction[T])(
        level: TransactionIsolationLevel
    ): T =
      val session = sqlSessionFactory.openSession(level)
      transaction(function)(session)

    def transaction[T](function: SqlSessionFunction[T])(
        execType: ExecutorType,
        autoCommit: Boolean
    ): T =
      val session = sqlSessionFactory.openSession(execType, autoCommit)
      transaction(function)(session)

    def transaction[T](function: SqlSessionFunction[T])(
        execType: ExecutorType,
        connection: Connection
    ): T =
      val session = sqlSessionFactory.openSession(execType, connection)
      transaction(function)(session)

    def transaction[T](function: SqlSessionFunction[T])(
        execType: ExecutorType,
        level: TransactionIsolationLevel
    ): T =
      val session = sqlSessionFactory.openSession(execType, level)
      transaction(function)(session)

    def managed[T](function: SqlSessionFunction[T])(
        execType: ExecutorType
    ): T =
      val session = sqlSessionFactory.openSession(execType)

      try function(session)
      finally session.close()
