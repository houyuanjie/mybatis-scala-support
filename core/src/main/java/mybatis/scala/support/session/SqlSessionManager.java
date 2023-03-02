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

    public SqlSessionContext readOnly(ExecutorType execType, TransactionIsolationLevel level) {
        return new SqlSessionContext(() -> sqlSessionFactory.openSession(execType, level)) {
            @Override
            public <T> T behavior(SqlSession sqlSession, SqlSessionFunction<T> sqlSessionFunction) {
                try (sqlSession) {
                    T result = sqlSessionFunction.apply(sqlSession);
                    sqlSession.rollback();
                    return result;
                }
            }
        };
    }

    public SqlSessionContext readOnly() {
        return this.readOnly(ExecutorType.SIMPLE, null);
    }

    public SqlSessionContext transaction(SqlSession sqlSession) {
        return new SqlSessionContext(() -> sqlSession) {
            @Override
            public <T> T behavior(SqlSession sqlSession, SqlSessionFunction<T> sqlSessionFunction) {
                try (sqlSession) {
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
                }
            }
        };
    }

    public SqlSessionContext transaction(boolean autoCommit) {
        SqlSession sqlSession = sqlSessionFactory.openSession(autoCommit);
        return this.transaction(sqlSession);
    }

    public SqlSessionContext transaction(Connection connection) {
        SqlSession sqlSession = sqlSessionFactory.openSession(connection);
        return this.transaction(sqlSession);
    }

    public SqlSessionContext transaction(TransactionIsolationLevel level) {
        SqlSession sqlSession = sqlSessionFactory.openSession(level);
        return this.transaction(sqlSession);
    }

    public SqlSessionContext transaction(ExecutorType execType, boolean autoCommit) {
        SqlSession sqlSession = sqlSessionFactory.openSession(execType, autoCommit);
        return this.transaction(sqlSession);
    }

    public SqlSessionContext transaction(ExecutorType execType, Connection connection) {
        SqlSession sqlSession = sqlSessionFactory.openSession(execType, connection);
        return this.transaction(sqlSession);
    }

    public SqlSessionContext transaction(ExecutorType execType, TransactionIsolationLevel level) {
        SqlSession sqlSession = sqlSessionFactory.openSession(execType, level);
        return this.transaction(sqlSession);
    }

    public SqlSessionContext managed(ExecutorType execType) {
        return new SqlSessionContext(() -> sqlSessionFactory.openSession(execType)) {
            @Override
            public <T> T behavior(SqlSession sqlSession, SqlSessionFunction<T> sqlSessionFunction) {
                try (sqlSession) {
                    return sqlSessionFunction.apply(sqlSession);
                }
            }
        };
    }

    public SqlSessionContext managed() {
        return this.managed(ExecutorType.SIMPLE);
    }

    public static SqlSessionManager make(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionManager(sqlSessionFactory);
    }

}
