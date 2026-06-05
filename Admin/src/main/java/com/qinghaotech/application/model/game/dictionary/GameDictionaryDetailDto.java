package com.qinghaotech.application.model.game.dictionary;

import com.qinghaotech.domain.primitive.GameDictionary;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jinx
 */
@Getter
@Setter
public class GameDictionaryDetailDto {

    /**
     * id
     */
    private Integer id;
    /**
     * 游戏id
     */
    private String gameId;
    /**
     * 游戏字典
     */
    private GameDictionary gameDictionary;
    /**
     * 名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
}
