package mybatis.scala.support.typing;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import scala.Option;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DelegateScalaOptionTypeHandler<T> implements TypeHandler<Option<T>> {

    public abstract TypeHandler<T> delegate();

    @Override
    public void setParameter(PreparedStatement ps, int i, Option<T> parameter, JdbcType jdbcType) throws SQLException {
        if (parameter.isDefined()) {
            delegate().setParameter(ps, i, parameter.get(), jdbcType);
        } else {
            delegate().setParameter(ps, i, null, jdbcType);
        }
    }

    @Override
    public Option<T> getResult(ResultSet rs, String columnName) throws SQLException {
        T result = delegate().getResult(rs, columnName);
        return Option.apply(result);
    }

    @Override
    public Option<T> getResult(ResultSet rs, int columnIndex) throws SQLException {
        T result = delegate().getResult(rs, columnIndex);
        return Option.apply(result);
    }

    @Override
    public Option<T> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        T result = delegate().getResult(cs, columnIndex);
        return Option.apply(result);
    }

}
