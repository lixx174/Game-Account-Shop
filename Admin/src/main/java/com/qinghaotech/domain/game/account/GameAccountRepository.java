package com.qinghaotech.domain.game.account;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinghaotech.application.model.game.account.GameAccountPageQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * @author jinx
 */
@Repository
public interface GameAccountRepository extends BaseMapper<GameAccountEntity> {

    default Page<GameAccountEntity> selectPage(GameAccountPageQuery query) {
        Page<GameAccountEntity> page = Page.of(query.getCurrent().longValue(), query.getSize().longValue());
        var wrapper = Wrappers.lambdaQuery(GameAccountEntity.class)
                .eq(GameAccountEntity::getGameId, query.getGameId())
                .like(StringUtils.hasText(query.getTitle()), GameAccountEntity::getTitle, query.getTitle());

        return selectPage(page, wrapper);
    }
}
