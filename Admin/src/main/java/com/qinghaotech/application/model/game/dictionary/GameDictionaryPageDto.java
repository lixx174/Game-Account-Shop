package com.qinghaotech.application.model.game.dictionary;

import com.qinghaotech.domain.primitive.GameDictionary;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author jinx
 */
@Getter
@Setter
public class GameDictionaryPageDto {
    /**
     * id
     */
    private Integer id;
    /**
     * 游戏名称
     */
    private String gameName;
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
    /**
     * 创建时间
     */
    private LocalDateTime createAt;

}
