package com.qinghaotech.domain.game.account;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinghaotech.application.model.game.account.GameAccountPageQuery;
import com.qinghaotech.domain.primitive.SortType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.util.StringUtils;

/**
 * @author jinx
 */
@Mapper
public interface GameAccountRepository extends BaseMapper<GameAccountEntity> {

    default Page<GameAccountEntity> selectPage(GameAccountPageQuery query) {
        Page<GameAccountEntity> page = Page.of(query.getCurrent().longValue(), query.getSize().longValue());
        var wrapper = Wrappers.lambdaQuery(GameAccountEntity.class)
                .eq(GameAccountEntity::getGameId, query.getGameId())
                .eq(query.getOriginId() != null, GameAccountEntity::getOriginId, query.getOriginId())
                .eq(query.getSystemId() != null, GameAccountEntity::getSystemId, query.getSystemId())
                .ge(query.getMinPrice() != null, GameAccountEntity::getPrice, query.getMinPrice())
                .le(query.getMaxPrice() != null, GameAccountEntity::getPrice, query.getMaxPrice())
                .like(StringUtils.hasText(query.getTitle()), GameAccountEntity::getTitle, query.getTitle());

        if (query.getSortColumn() != null && query.getSortType() != null) {
            wrapper.orderBy(
                    true,
                    query.getSortType() == SortType.ASC,
                    query.getSortColumn().getColumnFunction()
            );
        }

        return selectPage(page, wrapper);
    }
}
