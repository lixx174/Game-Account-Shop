package com.qinghaotech.infra.configuration.mp;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * @author jinx
 */
@MappedTypes(Collection.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class CollectionStringTypeHandler extends BaseTypeHandler<Collection<?>> {


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Collection<?> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, StringUtils.collectionToCommaDelimitedString(parameter));
    }

    @Override
    public Collection<?> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return StringUtils.commaDelimitedListToSet(rs.getString(columnName));
    }

    @Override
    public Collection<?> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return StringUtils.commaDelimitedListToSet(rs.getString(columnIndex));
    }

    @Override
    public Collection<?> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return StringUtils.commaDelimitedListToSet(cs.getString(columnIndex));
    }
}

