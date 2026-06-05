package com.qinghaotech.domain.game.dictionary;

import com.qinghaotech.domain.Entity;
import com.qinghaotech.domain.primitive.GameDictionary;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jinx
 */
@Getter
@Setter
public class GameDictionaryEntity extends Entity {

    private String gameId;

    private GameDictionary gameDictionary;

    private String name;

    private String remark;
}
