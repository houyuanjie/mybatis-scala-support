package mybatis.scala.support.session;

@FunctionalInterface
public interface SqlSessionFunctionConsumer<T> {
    T accept(SqlSessionFunction<T> sqlSessionFunction);
}
