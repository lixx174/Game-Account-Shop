package com.qinghaotech.application.model.game.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author jinx
 */
@Getter
public class CreateGameAccountCommand {

    @JsonCreator
    public CreateGameAccountCommand(Integer gameId,
                                    String title,
                                    Integer originId,
                                    Integer serverId,
                                    Integer systemId,
                                    Collection<Integer> tagIds,
                                    BigDecimal price,
                                    Collection<String> images,
                                    String remark) {
        Assert.notNull(gameId, "游戏id为空");
        Assert.hasText(title, "游戏标题为空");
        Assert.notNull(originId, "游戏来源为空");
        Assert.notNull(serverId, "游戏区服为空");
        Assert.notNull(systemId, "游戏系统为空");
        Assert.notEmpty(tagIds, "游戏标签为空");
        Assert.notNull(price, "价格为空");
        Assert.notEmpty(images, "游戏截图为空");

        this.gameId = gameId;
        this.title = title;
        this.originId = originId;
        this.serverId = serverId;
        this.systemId = systemId;
        this.tagIds = tagIds;
        this.price = price;
        this.images = images;
        this.remark = remark;
    }

    /**
     * 游戏id
     */
    private final Integer gameId;
    /**
     * 标题
     */
    private final String title;
    /**
     * 账号来源id
     */
    private final Integer originId;
    /**
     * 账号区服id
     */
    private final Integer serverId;
    /**
     * 游戏系统id
     */
    private final Integer systemId;
    /**
     * 账号标签ids
     */
    private final Collection<Integer> tagIds;
    /**
     * 价格
     */
    private final BigDecimal price;
    /**
     * 账号截图
     */
    private final Collection<String> images;
    /**
     * 备注
     */
    private final String remark;
}
