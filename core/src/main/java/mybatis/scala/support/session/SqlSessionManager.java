package mybatis.scala.support.session;

import org.apache.ibatis.session.*;

import java.sql.Connection;

public class SqlSessionManager {

    private final SqlSessionFactory sqlSessionFactory;

    public SqlSessionManager(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

    public Configuration getConfiguration() {
        return sqlSessionFactory.getConfiguration();
    }

    public <T> SqlSessionContext<T> readOnly(ExecutorType execType, TransactionIsolationLevel level) {
        return sqlSessionFunction -> {
            try (SqlSession sqlSession = sqlSessionFactory.openSession(execType, level)) {
                T result = sqlSessionFunction.apply(sqlSession);
                sqlSession.rollback();
                return result;
            }
        };
    }

    public <T> SqlSessionContext<T> readOnly() {
        return this.readOnly(ExecutorType.SIMPLE, null);
    }

    public <T> SqlSessionContext<T> transaction(SqlSession sqlSession) {
        return sqlSessionFunction -> {
            try {
                T result = sqlSessionFunction.apply(sqlSession);
                sqlSession.commit();
                return result;
            } catch (Exception commitException) {
                try {
                    sqlSession.rollback();
                } catch (Exception rollbackException) {
                    rollbackException.addSuppressed(commitException);
                    throw rollbackException;
                }
                throw commitException;
            } finally {
                sqlSession.close();
            }
        };
    }

    public <T> SqlSessionContext<T> transaction(boolean autoCommit) {
        SqlSession sqlSession = sqlSessionFactory.openSession(autoCommit);
        return this.transaction(sqlSession);
    }

    public <T> SqlSessionContext<T> transaction(Connection connection) {
        SqlSession sqlSession = sqlSessionFactory.openSession(connection);
        return this.transaction(sqlSession);
    }

    public <T> SqlSessionContext<T> transaction(TransactionIsolationLevel level) {
        SqlSession sqlSession = sqlSessionFactory.openSession(level);
        return this.transaction(sqlSession);
    }

    public <T> SqlSessionContext<T> transaction(ExecutorType execType, boolean autoCommit) {
        SqlSession sqlSession = sqlSessionFactory.openSession(execType, autoCommit);
        return this.transaction(sqlSession);
    }

    public <T> SqlSessionContext<T> transaction(ExecutorType execType, Connection connection) {
        SqlSession sqlSession = sqlSessionFactory.openSession(execType, connection);
        return this.transaction(sqlSession);
    }

    public <T> SqlSessionContext<T> transaction(ExecutorType execType, TransactionIsolationLevel level) {
        SqlSession sqlSession = sqlSessionFactory.openSession(execType, level);
        return this.transaction(sqlSession);
    }

    public <T> SqlSessionContext<T> managed(ExecutorType execType) {
        return sqlSessionFunction -> {
            try (SqlSession sqlSession = sqlSessionFactory.openSession(execType)) {
                return sqlSessionFunction.apply(sqlSession);
            }
        };
    }

    public <T> SqlSessionContext<T> managed() {
        return this.managed(ExecutorType.SIMPLE);
    }

    public static SqlSessionManager make(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionManager(sqlSessionFactory);
    }

}
