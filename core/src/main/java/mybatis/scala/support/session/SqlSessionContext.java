package mybatis.scala.support.session;

@FunctionalInterface
public interface SqlSessionContext<T> {
    T use(SqlSessionFunction<T> sqlSessionFunction);
}
