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

    public <T> SqlSessionFunctionConsumer<T> readOnly(ExecutorType execType, TransactionIsolationLevel level) {
        return new SqlSessionFunctionConsumer<T>() {
            @Override
            public T accept(SqlSessionFunction<T> sqlSessionFunction) {
                SqlSession sqlSession = sqlSessionFactory.openSession(execType, level);

                try {
                    T result = sqlSessionFunction.apply(sqlSession);
                    sqlSession.rollback();
                    return result;
                } finally {
                    sqlSession.close();
                }
            }
        };
    }

    public <T> SqlSessionFunctionConsumer<T> readOnly() {
        return this.readOnly(ExecutorType.SIMPLE, null);
    }

    public <T> SqlSessionFunctionConsumer<T> transaction(SqlSession sqlSession) {
        return new SqlSessionFunctionConsumer<T>() {
            @Override
            public T accept(SqlSessionFunction<T> sqlSessionFunction) {
                try {
                    T result = sqlSessionFunction.apply(sqlSession);
                    sqlSession.commit();
                    return result;
                } catch (Throwable commitThrowable) {
                    try {
                        sqlSession.rollback();
                    } catch (Throwable rollbackThrowable) {
                        rollbackThrowable.addSuppressed(commitThrowable);
                        throw rollbackThrowable;
                    }

                    throw commitThrowable;
                } finally {
                    sqlSession.close();
                }
            }
        };
    }

    public <T> SqlSessionFunctionConsumer<T> transaction(boolean autoCommit) {
        SqlSession sqlSession = sqlSessionFactory.openSession(autoCommit);
        return this.transaction(sqlSession);
    }

    public <T> SqlSessionFunctionConsumer<T> transaction(Connection connection) {
        SqlSession sqlSession = sqlSessionFactory.openSession(connection);
        return this.transaction(sqlSession);
    }

    public <T> SqlSessionFunctionConsumer<T> transaction(TransactionIsolationLevel level) {
        SqlSession sqlSession = sqlSessionFactory.openSession(level);
        return this.transaction(sqlSession);
    }

    public <T> SqlSessionFunctionConsumer<T> transaction(ExecutorType execType, boolean autoCommit) {
        SqlSession sqlSession = sqlSessionFactory.openSession(execType, autoCommit);
        return this.transaction(sqlSession);
    }

    public <T> SqlSessionFunctionConsumer<T> transaction(ExecutorType execType, Connection connection) {
        SqlSession sqlSession = sqlSessionFactory.openSession(execType, connection);
        return this.transaction(sqlSession);
    }

    public <T> SqlSessionFunctionConsumer<T> transaction(ExecutorType execType, TransactionIsolationLevel level) {
        SqlSession sqlSession = sqlSessionFactory.openSession(execType, level);
        return this.transaction(sqlSession);
    }

    public <T> SqlSessionFunctionConsumer<T> managed(ExecutorType execType) {
        return new SqlSessionFunctionConsumer<T>() {
            @Override
            public T accept(SqlSessionFunction<T> sqlSessionFunction) {
                SqlSession sqlSession = sqlSessionFactory.openSession(execType);

                try {
                    T result = sqlSessionFunction.apply(sqlSession);
                    return result;
                } finally {
                    sqlSession.close();
                }
            }
        };
    }

    public <T> SqlSessionFunctionConsumer<T> managed() {
        return this.managed(ExecutorType.SIMPLE);
    }

    public static SqlSessionManager make(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionManager(sqlSessionFactory);
    }

}
