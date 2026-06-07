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
     * 账号编号
     */
    private String accountNo;
    /**
     * 标题
     */
    private String title;
    /**
     * 游戏id
     */
    private Integer gameId;
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
     * 流程
     */
    private String process;
    /**
     * 政策
     */
    private String policy;
    /**
     * 账号截图
     */
    private Collection<String> images;
    /**
     * 备注
     */
    private String remark;
}
