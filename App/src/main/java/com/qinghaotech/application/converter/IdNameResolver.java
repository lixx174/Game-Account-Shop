package com.qinghaotech.application.converter;

import java.util.Collection;

/**
 * @author jinx
 */
@FunctionalInterface
public interface IdNameResolver {

    /**
     * 通过id获取name
     *
     * @param id 表id
     * @return 对应的name
     */
    String resolve(Integer id);

    default Collection<String> resolve(Collection<Integer> ids) {
        return ids.stream()
                .map(this::resolve)
                .toList();
    }
}
