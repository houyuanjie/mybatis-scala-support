package mybatis.scala.support.session;

import org.apache.ibatis.session.SqlSession;

@FunctionalInterface
public interface SqlSessionFunction<T> {
    T apply(SqlSession sqlSession);
}
