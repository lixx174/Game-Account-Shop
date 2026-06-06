package com.qinghaotech.domain.game.dictionary;

import com.qinghaotech.domain.primitive.GameDictionary;
import lombok.Builder;
import lombok.Getter;

/**
 * @author jinx
 */
@Getter
@Builder
public class GameDictionaryQuery {

    private Integer gameId;

    private GameDictionary gameDictionary;

    private String name;
}
