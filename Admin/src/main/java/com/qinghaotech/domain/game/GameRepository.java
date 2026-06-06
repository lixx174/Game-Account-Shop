package com.qinghaotech.domain.game;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinghaotech.application.model.game.GamePageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * @author jinx
 */
@Mapper
public interface GameRepository extends BaseMapper<GameEntity> {

    default Page<GameEntity> selectPage(GamePageQuery query) {
        Page<GameEntity> page = Page.of(query.getCurrent().longValue(), query.getSize().longValue());
        var wrapper = Wrappers.lambdaQuery(GameEntity.class)
                .like(StringUtils.hasText(query.getName()), GameEntity::getName, query.getName());

        return selectPage(page, wrapper);
    }

    default Collection<GameEntity> selectByName(String name) {
        var wrapper = Wrappers.lambdaQuery(GameEntity.class)
                .eq(StringUtils.hasText(name), GameEntity::getName, name);

        return selectList(wrapper);
    }
}
