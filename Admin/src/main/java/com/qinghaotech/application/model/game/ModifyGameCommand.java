package com.qinghaotech.application.model.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

/**
 * @author jinx
 */
@Getter
@Setter
public class ModifyGameCommand {

    /**
     * id
     */
    private final Integer id;
    /**
     * 名称
     */
    private final String name;
    /**
     * 图标地址
     */
    private final String icon;
    @JsonCreator
    public ModifyGameCommand(Integer id, String name, String icon) {
        Assert.notNull(id, "id为空");
        Assert.hasText(name, "游戏名称为空");
        Assert.hasText(icon, "游戏图标为空");

        this.id = id;
        this.name = name;
        this.icon = icon;
    }
}
