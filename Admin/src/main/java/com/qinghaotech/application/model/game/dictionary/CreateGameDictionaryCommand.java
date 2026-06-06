package com.qinghaotech.application.model.game.dictionary;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.qinghaotech.domain.primitive.GameDictionary;
import lombok.Getter;
import org.springframework.util.Assert;

/**
 * @author jinx
 */
@Getter
public class CreateGameDictionaryCommand {

    /**
     * 游戏id
     */
    private final Integer gameId;
    /**
     * 游戏字典
     */
    private final GameDictionary gameDictionary;
    /**
     * 名称
     */
    private final String name;
    /**
     * 备注
     */
    private final String remark;
    @JsonCreator
    public CreateGameDictionaryCommand(Integer gameId, GameDictionary gameDictionary, String name, String remark) {
        Assert.notNull(gameId, "游戏id为空");
        Assert.notNull(gameDictionary, "游戏字典为空");
        Assert.hasText(name, "字典内容为空");

        this.gameId = gameId;
        this.gameDictionary = gameDictionary;
        this.name = name;
        this.remark = remark;
    }
}
