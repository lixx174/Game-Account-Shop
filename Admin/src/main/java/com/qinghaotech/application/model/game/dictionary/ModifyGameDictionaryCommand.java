package com.qinghaotech.application.model.game.dictionary;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.springframework.util.Assert;

/**
 * @author jinx
 */
@Getter
public class ModifyGameDictionaryCommand {

    /**
     * id
     */
    private final Integer id;
    /**
     * 名称
     */
    private final String name;
    /**
     * 备注
     */
    private final String remark;
    @JsonCreator
    public ModifyGameDictionaryCommand(Integer id, String name, String remark) {
        Assert.notNull(id, "id为空");
        Assert.hasText(name, "name为空");

        this.id = id;
        this.name = name;
        this.remark = remark;
    }
}
