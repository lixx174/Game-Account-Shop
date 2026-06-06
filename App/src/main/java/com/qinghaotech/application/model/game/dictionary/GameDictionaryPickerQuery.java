package com.qinghaotech.application.model.game.dictionary;

import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.domain.primitive.GameDictionary;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

/**
 * @author jinx
 */
@Getter
@Setter
public class GameDictionaryPickerQuery extends PageQuery {

    /**
     * REQUIRED 游戏id
     */
    private String gameId;
    /**
     * REQUIRED 游戏编码
     */
    private GameDictionary gameDictionary;

    public void check() {
        Assert.hasText(gameId, "游戏id为空");
        Assert.notNull(gameDictionary, "游戏编码为空");
    }
}
