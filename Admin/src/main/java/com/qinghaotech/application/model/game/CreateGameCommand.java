package com.qinghaotech.application.model.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.springframework.util.Assert;

/**
 * @author jinx
 */
@Getter
public class CreateGameCommand {

    @JsonCreator
    public CreateGameCommand(String name, String icon) {
        Assert.hasText(name, "游戏名称为空");
        Assert.hasText(icon, "游戏图标为空");

        this.name = name;
        this.icon = icon;
    }

    /**
     * 名称
     */
    private final String name;
    /**
     * 图标地址
     */
    private final String icon;
}
