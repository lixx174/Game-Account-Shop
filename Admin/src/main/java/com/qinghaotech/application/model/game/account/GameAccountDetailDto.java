package com.qinghaotech.application.model.game.account;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author jinx
 */
@Getter
@Setter
public class GameAccountDetailDto {
    /**
     * id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 账号来源id
     */
    private Integer originId;
    /**
     * 账号区服id
     */
    private Integer serverId;
    /**
     * 游戏系统
     */
    private Integer systemId;
    /**
     * 账号标签id
     */
    private Collection<Integer> tagIds;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 备注
     */
    private String remark;
}
