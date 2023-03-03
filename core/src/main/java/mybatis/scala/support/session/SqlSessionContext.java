package mybatis.scala.support.session;

import org.apache.ibatis.session.SqlSession;

import java.util.function.Supplier;

public abstract class SqlSessionContext {

    private final Supplier<SqlSession> sqlSessionSupplier;

    protected SqlSessionContext(Supplier<SqlSession> sqlSessionSupplier) {
        this.sqlSessionSupplier = sqlSessionSupplier;
    }

    public SqlSession getSqlSession() {
        return this.sqlSessionSupplier.get();
    }

    public <T> T use(SqlSessionFunction<T> sqlSessionFunction) {
        SqlSession sqlSession = this.getSqlSession();
        return behavior(sqlSession, sqlSessionFunction);
    }

    /**
     * Please Call {@code sqlSession.close()} before the method returns
     */
    public abstract <T> T behavior(SqlSession sqlSession, SqlSessionFunction<T> sqlSessionFunction);

}
