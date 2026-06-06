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
import java.util.stream.Collectors;

/**
 * @author jinx
 */
@SuppressWarnings("all")
@MappedTypes(Collection.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class IntegerCollectionStringTypeHandler extends BaseTypeHandler<Collection<Integer>> {


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Collection<Integer> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, StringUtils.collectionToCommaDelimitedString(parameter));
    }

    @Override
    public Collection<Integer> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return StringUtils.commaDelimitedListToSet(rs.getString(columnName))
                .stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Integer> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return StringUtils.commaDelimitedListToSet(rs.getString(columnIndex))
                .stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Integer> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return StringUtils.commaDelimitedListToSet(cs.getString(columnIndex))
                .stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}

