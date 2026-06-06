package com.qinghaotech.domain.game.dictionary;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinghaotech.domain.Entity;
import com.qinghaotech.domain.primitive.GameDictionary;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jinx
 */
@Getter
@Setter
@TableName(value = "game_dictionary")
public class GameDictionaryEntity extends Entity {

    private Integer gameId;

    private GameDictionary gameDictionary;

    private String name;

    private String remark;
}
