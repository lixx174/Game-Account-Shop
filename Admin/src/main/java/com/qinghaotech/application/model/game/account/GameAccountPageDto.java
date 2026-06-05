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
public class GameAccountPageDto {
    /**
     * id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 账号来源
     */
    private String originName;
    /**
     * 账号区服
     */
    private String serverName;
    /**
     * 游戏系统
     */
    private String systemName;
    /**
     * 账号标签
     */
    private Collection<String> tags;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private BigDecimal createAt;
}
