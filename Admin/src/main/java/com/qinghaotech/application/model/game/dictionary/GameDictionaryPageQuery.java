package com.qinghaotech.application.model.game.dictionary;

import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.domain.primitive.GameDictionary;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jinx
 */
@Getter
@Setter
public class GameDictionaryPageQuery extends PageQuery {
    /**
     * 游戏id
     */
    private String gameId;
    /**
     * REQUIRED 游戏编码
     */
    private GameDictionary gameDictionary;
    /**
     * 名称
     */
    private String name;
}
