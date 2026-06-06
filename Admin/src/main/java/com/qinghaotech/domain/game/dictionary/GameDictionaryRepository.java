package com.qinghaotech.domain.game.dictionary;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPageQuery;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPickerQuery;
import com.qinghaotech.domain.Entity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * @author jinx
 */
@Mapper
public interface GameDictionaryRepository extends BaseMapper<GameDictionaryEntity> {

    default Page<GameDictionaryEntity> selectPage(GameDictionaryPageQuery query) {
        Page<GameDictionaryEntity> page = Page.of(query.getCurrent().longValue(), query.getSize().longValue());
        var wrapper = Wrappers.lambdaQuery(GameDictionaryEntity.class)
                .eq(StringUtils.hasText(query.getGameId()), GameDictionaryEntity::getGameId, query.getGameId())
                .eq(query.getGameDictionary() != null, GameDictionaryEntity::getGameDictionary, query.getGameDictionary())
                .like(StringUtils.hasText(query.getName()), GameDictionaryEntity::getName, query.getName())
                .orderByDesc(Entity::getCreateAt);

        return selectPage(page, wrapper);
    }

    default Page<GameDictionaryEntity> selectPage(GameDictionaryPickerQuery query) {
        Page<GameDictionaryEntity> page = Page.of(query.getCurrent().longValue(), query.getSize().longValue());
        var wrapper = Wrappers.lambdaQuery(GameDictionaryEntity.class)
                .eq(GameDictionaryEntity::getGameId, query.getGameId())
                .eq(GameDictionaryEntity::getGameDictionary, query.getGameDictionary())
                .like(StringUtils.hasText(query.getName()), GameDictionaryEntity::getName, query.getName())
                .orderByDesc(Entity::getCreateAt);

        return selectPage(page, wrapper);
    }

    default Collection<GameDictionaryEntity> selectByCondition(GameDictionaryQuery query) {
        var wrapper = Wrappers.lambdaQuery(GameDictionaryEntity.class)
                .eq(query.getGameId() != null, GameDictionaryEntity::getGameId, query.getGameId())
                .eq(query.getGameDictionary() != null, GameDictionaryEntity::getGameDictionary, query.getGameDictionary())
                .eq(StringUtils.hasText(query.getName()), GameDictionaryEntity::getName, query.getName());

        return selectList(wrapper);
    }
}
