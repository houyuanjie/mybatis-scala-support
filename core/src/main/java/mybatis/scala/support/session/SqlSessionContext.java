package mybatis.scala.support.session;

import org.apache.ibatis.session.SqlSession;

public abstract class SqlSessionContext {

    private final SqlSession sqlSession;

    public SqlSessionContext(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public abstract <T> T use(SqlSessionFunction<T> sqlSessionFunction);

}
