package mybatis.scala.support.typing;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import scala.Option;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DelegateScalaOptionTypeHandler<T> implements TypeHandler<Option<T>> {

    private final TypeHandler<T> typeHandler;

    protected DelegateScalaOptionTypeHandler(TypeHandler<T> typeHandler) {
        this.typeHandler = typeHandler;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, Option<T> parameter, JdbcType jdbcType) throws SQLException {
        if (parameter.isDefined()) {
            typeHandler.setParameter(ps, i, parameter.get(), jdbcType);
        } else {
            typeHandler.setParameter(ps, i, null, jdbcType);
        }
    }

    @Override
    public Option<T> getResult(ResultSet rs, String columnName) throws SQLException {
        T result = typeHandler.getResult(rs, columnName);
        return Option.apply(result);
    }

    @Override
    public Option<T> getResult(ResultSet rs, int columnIndex) throws SQLException {
        T result = typeHandler.getResult(rs, columnIndex);
        return Option.apply(result);
    }

    @Override
    public Option<T> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        T result = typeHandler.getResult(cs, columnIndex);
        return Option.apply(result);
    }

}
