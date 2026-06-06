package com.qinghaotech.domain.game.dictionary;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPickerQuery;
import com.qinghaotech.domain.Entity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jinx
 */
@Mapper
public interface GameDictionaryRepository extends BaseMapper<GameDictionaryEntity> {

    default Page<GameDictionaryEntity> selectPage(GameDictionaryPickerQuery query) {
        Page<GameDictionaryEntity> page = Page.of(query.getCurrent().longValue(), query.getSize().longValue());
        var wrapper = Wrappers.lambdaQuery(GameDictionaryEntity.class)
                .eq(GameDictionaryEntity::getGameId, query.getGameId())
                .eq(GameDictionaryEntity::getGameDictionary, query.getGameDictionary())
                .orderByDesc(Entity::getCreateAt);

        return selectPage(page, wrapper);
    }
}
