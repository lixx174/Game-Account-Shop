package com.qinghaotech.domain.primitive;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.qinghaotech.domain.game.account.GameAccountEntity;

/**
 * 排序字段
 *
 * @author jinx
 */
public enum SortColumn {
    /**
     * 发布时间
     */
    PUBLISH_TIME {
        @Override
        public SFunction<GameAccountEntity, String> getColumnFunction() {
            return e -> "create_at";
        }
    },
    /**
     * 价格
     */
    PRICE {
        @Override
        public SFunction<GameAccountEntity, String> getColumnFunction() {
            return e -> "price";
        }
    };

    /**
     * 获取字段名称
     *
     * @return db排序字段名称
     */
    public abstract SFunction<GameAccountEntity, String> getColumnFunction();
}
