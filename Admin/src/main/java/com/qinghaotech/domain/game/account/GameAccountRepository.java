package com.qinghaotech.domain.game.account;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinghaotech.application.model.game.account.GameAccountPageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * @author jinx
 */
@Mapper
public interface GameAccountRepository extends BaseMapper<GameAccountEntity> {

    default Page<GameAccountEntity> selectPage(GameAccountPageQuery query) {
        Page<GameAccountEntity> page = Page.of(query.getCurrent().longValue(), query.getSize().longValue());
        var wrapper = Wrappers.lambdaQuery(GameAccountEntity.class)
                .eq(query.getGameId() != null, GameAccountEntity::getGameId, query.getGameId())
                .like(StringUtils.hasText(query.getTitle()), GameAccountEntity::getTitle, query.getTitle());

        return selectPage(page, wrapper);
    }

    default Collection<GameAccountEntity> selectByNo(String accountNo) {
        var wrapper = Wrappers.lambdaQuery(GameAccountEntity.class)
                .eq(GameAccountEntity::getAccountNo, accountNo);

        return selectList(wrapper);
    }
}
